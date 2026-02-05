import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile {
    public static void main(String[] args)throws Exception{
        String path=System.getProperty("user.dir");
        File file=new File(path+"\\src\\test\\java\\sample.xlsx");
        FileInputStream fis=new FileInputStream(file);
        XSSFWorkbook work=new XSSFWorkbook(fis);
        XSSFSheet sheet=work.getSheet("Sheet2");
        System.out.println(work.getSheetIndex("Sheet1"));
        System.out.println(work.getNumberOfSheets());
        System.out.println(work.getActiveSheetIndex());
    }
}
