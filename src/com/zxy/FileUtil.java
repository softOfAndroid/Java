package com.zxy;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;

public class FileUtil {

    public static void main(String[] args) {
        writeExcelFile("C:\\Users\\my\\Desktop\\测试.xls");
    }

    /**
     * 读取 txt 最后一行文本
     * @param filePath
     */
    public static void readZtFile(String filePath) {
        File file = new File(filePath);
        RandomAccessFile raf = null;
        if (file != null && file.isFile()) {
            try {
                raf = new RandomAccessFile(file, "r");
                long len = raf.length();
                if (len == 0L) {
                    return;
                } else {
                    long pos = len - 1;
                    while (pos > 0) {
                        pos--;
                        raf.seek(pos);
                        if (raf.readByte() == '\n') {
                            break;
                        }
                    }
                    if (pos == 0) {
                        raf.seek(0);
                    }
                    byte[] bytes = new byte[(int) (len - pos)];
                    raf.read(bytes);
                    String s = new String(bytes, "utf-8");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (raf != null) {
                    try {
                        raf.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * 读取 (txt) 的每行最后一个数字相加
     *
     * @param filePath
     * @return
     */
    public static void readFcUploadAmount(String filePath) {
        Integer result = 0;
        BufferedReader bufferedReader = null;
        File file = new File(filePath);
        if (file != null && file.isFile()) {
            try {
                InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "gbk");
                bufferedReader = new BufferedReader(reader);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] split = lineTxt.split("\\|");
                    String str = split[4];
                    result += Integer.parseInt(str);
                }
                System.out.println(result.toString());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取明细 Excel 文件
     * @param filePath
     * @return
     */
    public static ConcurrentHashMap readExsl(String filePath) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        File file = new File(filePath);
        if (file != null && file.isFile()) {
            try {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
                // 打开HSSFWorkbook
                POIFSFileSystem fs = new POIFSFileSystem(in);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                    HSSFSheet st = wb.getSheetAt(0);
                    int rowNum = st.getLastRowNum() - 3;
                    // 行
                    for (int rowIndex = 0; rowIndex < rowNum; rowIndex++) {
                        HSSFRow row = st.getRow(rowIndex);
                        if (row == null) {
                            continue;
                        }
                        //列
                        int columnNum = row.getLastCellNum();
                        for (short columnIndex = 5; columnIndex < columnNum; columnIndex++) {
                            HSSFCell cell = row.getCell(columnIndex);
                            if (cell != null) {
                                //根据类型不同
                                switch (cell.getCellType()) {
                                    case HSSFCell.CELL_TYPE_STRING:
                                        String date = sdf.format(sdf.parse(cell.getStringCellValue()));
                                        break;
                                    case HSSFCell.CELL_TYPE_NUMERIC:
                                        double money = cell.getNumericCellValue();
                                        break;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /***
     * 按照一定的格式写入excel
     */
    public static void writeExcelFile(String filePath) {
        FileOutputStream fos = null;
        HSSFWorkbook workbook = null;
        HSSFSheet sheet = null;
        HSSFCellStyle style = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                //不存在excel,创建excel
                workbook = new HSSFWorkbook();
                String sheetName = "bill";
                sheet = workbook.createSheet(sheetName);
                //样式
                sheet.setDefaultColumnWidth((short) 22);
                style = getStyle(workbook);
                //头
                String[] title = new String[]{"日期", "交易金额", "入账手续费", "入账金额", "XX上账", "XX上账", "缴款明细上账", "差额"};
                HSSFRow titleRow = sheet.createRow(0);
                for (short i = 0; i < 8; i++) {
                    titleRow.setHeight((short) 500);
                    HSSFCell cell = titleRow.createCell(i);
                    cell.setCellStyle(style); // 样式
                    cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                    cell.setCellValue(title[i]);
                }
            } else {
                //追加数据
                FileInputStream fis = new FileInputStream(filePath);
                POIFSFileSystem ps = new POIFSFileSystem(fis);
                workbook = new HSSFWorkbook(ps);
                sheet = workbook.getSheetAt(0);
                style = getStyle(workbook);
            }
            fos = new FileOutputStream(file);
            // 写5行数据
            for (int k = 0; k < 5; k++) {
                //写数据
                HSSFRow row = sheet.createRow(sheet.getLastRowNum() + 1);
                row.setHeight((short) 460);
                HSSFCell[] cells = new HSSFCell[8];
                for (short i = 0; i < 8; i++) {
                    cells[i] = row.createCell(i);
                    cells[i].setCellStyle(style); // 样式
                    cells[i].setEncoding(HSSFCell.ENCODING_UTF_16);
                    cells[i].setCellValue("测试" + k);
                }
            }
            workbook.write(fos);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 设置 Excel 样式
     * @param workbook
     * @return
     */
    public static HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle(); // 样式对象
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
        style.setWrapText(true);// 指定当单元格内容显示不下时自动换行
        HSSFFont font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeight((short) 260);
        style.setFont(font);
        return style;
    }
}
