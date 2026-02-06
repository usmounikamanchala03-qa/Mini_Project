import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class FaceBookLogin {
    WebDriver driver;
    @Test(dataProvider="Excel Data",dataProviderClass = ReadExcelData.class)
    public void LoginFunction(String username,String password){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver,60);
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.name("login")).submit();
        WebElement msg=driver.findElement(By.xpath("//div[text()='The email address or mobile number you entered isn't connected to an account. ']"));
        wait.until(ExpectedConditions.visibilityOf(msg));
        Assertions.assertThat(msg.isDisplayed()).isTrue();
    }
    @AfterTest
    public void driverClose(){
        driver.quit();
    }
}
