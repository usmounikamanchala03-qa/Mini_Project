import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeAutomation {
    public static void main(String[] args) throws Exception {
        IframeAutomation frauto=new IframeAutomation();
        frauto.textWrite();

    }
    public void textWrite()throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String value="mytext";
        for (int i=0;i<4;i++){
            driver.switchTo().frame(i);
            int n=i+1;
            driver.findElement(By.name(value+n))
                    .sendKeys("Frame "+n);
            Thread.sleep(1000);
            if(i==2){
                //driver.switchTo().frame(2);
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'docs.google.com')]")));
                driver.findElement(By.xpath("//span[text()='Hi, I am the UI.Vision IDE']")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//span[text()='Web Testing']")).click();
                Thread.sleep(1000);
                driver.switchTo().parentFrame();
            }
            driver.switchTo().defaultContent();
        }
        driver.quit();
    }

}
