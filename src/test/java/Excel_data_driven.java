import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Excel_data_driven {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\velocity\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        driver.get("https://www.moneycontrol.com/fixed-income/calculator" +
                "/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
       String path = "E://Practice//CalData.xlsx";
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        int rowcount = sheet.getLastRowNum();
        int columncount = sheet.getRow(0).getLastCellNum();
        System.out.println("No. of records in Excel Sheet" + rowcount);
        for (int i=1;i<=rowcount;i++){
            XSSFRow row = sheet.getRow(i);
            XSSFCell principlecell =row.getCell(0);
           int princ = (int)principlecell.getNumericCellValue();
            XSSFCell roi =row.getCell(1);
            int rateofinterest = (int)roi.getNumericCellValue();
            XSSFCell period =row.getCell(2);
            int per = (int)period.getNumericCellValue();
            XSSFCell frequency=row.getCell(3);
            String freq = frequency.getStringCellValue();
            XSSFCell MaturityValue=row.getCell(4);
            Double mv = (Double)MaturityValue.getNumericCellValue();

            WebElement prc = driver.findElement(By.id("principal"));
           prc.clear();
            prc.sendKeys(String.valueOf(princ));
           WebElement in= driver.findElement(By.id("interest"));
            in.clear();
            in.sendKeys(String.valueOf(rateofinterest));
            WebElement ten = driver.findElement(By.id("tenure"));
            ten.clear();
            ten.sendKeys(String.valueOf(per));
            Select periods = new Select(driver.findElement(By.id("tenurePeriod")));
            periods.selectByVisibleText("year(s)");
            Select compound = new Select(driver.findElement(By.id("frequency")));
            compound.selectByVisibleText("Simple Interest");
            driver.findElement(By.xpath("//body/div[@id='mc_mainWrapper']/div[2]/div[1]" +
                    "/div[5]/div[1]/div[1]/div[3]/form[1]/div[2]/a[1]/img[1]")).click();
            String actualmvalue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
            Thread.sleep(3000);
            if(Double.parseDouble(actualmvalue)==mv){
                System.out.println("Test Passed");
            }
            else{
                System.out.println("test Failed");
            }

        }
        driver.quit();
    }
}
