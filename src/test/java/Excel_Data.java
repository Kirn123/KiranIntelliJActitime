import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

import java.io.IOException;

public class Excel_Data {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("E://data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook (fis);
        XSSFSheet sheet=workbook.getSheet("Sheet1");
        int rowcount= sheet.getLastRowNum();
        int colcount=sheet.getRow(0).getLastCellNum();
        for (int i=0;i<rowcount;i++){
            XSSFRow currentrow =sheet.getRow(i);//focus on current row
            for(int j=0;j<colcount;j++){
               String value = currentrow.getCell(j).toString();
                System.out.print(" " + value);
            }
            System.out.println(" ");


        }


    }
}
