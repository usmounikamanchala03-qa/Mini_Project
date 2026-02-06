import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelData {
    @DataProvider(name="Excel Data")
    public Object[][] excelDP(){
        Object[][] arrobj=readExcelData();
        return arrobj;
    }

    public Object[][] readExcelData() {
        Object[][] data = null;
        try {

            String path = System.getProperty("user.dir");
            File file = new File(path + "\\src\\test\\java\\LoginData.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Sheet1");
            Row row = sheet.getRow(0);
            int NoOfRows = sheet.getPhysicalNumberOfRows();
            int NoOfColumns = row.getLastCellNum();
            Cell cell;
            data = new Object[NoOfRows - 1][NoOfColumns];
            for (int i = 1; i < NoOfRows; i++) {
                for (int j = 0; j < NoOfColumns; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    switch (cell.getCellType()) {
                        case STRING:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            data[i - 1][j] = cell.getNumericCellValue();
                            break;
                        case BLANK:
                            data[i - 1][j] = "";
                            break;
                        default:
                            data[i - 1][j] = null;
                    }

                }
            }
        }
        catch (Exception e){
            System.out.println("The exception is "+e.getMessage());
        }
        return data;
    }
}
