import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingData_Excel {
    public static void main(String[] args) throws IOException {
        String path = "E://Practice//writingdata.xlsx";
        FileOutputStream fis = new FileOutputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet =  wb.createSheet("Data");
       for(int i=0;i<=5;i++){
           XSSFRow row = sheet.createRow(i);
           for(int j=0; j<=5;j++){
               row.createCell(j).setCellValue("xyz");
           }

       }
       wb.write(fis);
       fis.close();
        System.out.println("Written data in excelsheet is complete");

    }
}
