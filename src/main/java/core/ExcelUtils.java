package core;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Set;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static org.apache.poi.ss.usermodel.Cell Cell;

    private static XSSFRow Row;

    String data;

    public static Object[][] getTableArray(String FilePath, String SheetName, int startCol, int totalCols) throws Exception {

        String[][] tabArray = null;

        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            int startRow = 1;
            int ci, cj;
            int totalRows = ExcelWSheet.getLastRowNum();
            tabArray = new String[totalRows][totalCols];
            ci = 0;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j < totalCols + startCol; j++, cj++) {
                    ExcelWSheet.getRow(i).getCell(j).setCellType(CellType.STRING);
                    tabArray[ci][cj] = ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
                    tabArray[ci][cj] = getCellData(i,j);
                    Cell = ExcelWSheet.getRow(i).getCell(j);
                    System.out.println("p:" + tabArray[ci][cj]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);

    }
    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();

            return CellData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }
}