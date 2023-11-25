import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Eximpe {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    //Go to https://eximpe.com/
    @Test
    public void Open() throws InterruptedException {
        driver.get("https://eximpe.com/");
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        Thread.sleep(5000);
    }
    //Navigate to the "About" section and then to the "About EximPe" page.
    @Test(priority=1)
    public void About() throws InterruptedException {
        WebElement about=driver.findElement(By.xpath("//*[@id=\"menu-1-366d1e90\"]/li[4]"));
        about.click();
        driver.findElement(By.xpath("//body/header[@class='elementor elementor-350 elementor-location-header']/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[2]/a[1]"))
                .click();
        Thread.sleep(5000);

    }

    // Locate and retrieve the value indicating the number of employees working at EximPe
    @Test(priority=2)
    public void Employee(){
        List<WebElement> emp=driver.findElements(By.tagName("h4"));
        int sizeofi=emp.size();
        System.out.println("total number of employees="+sizeofi);

        List<WebElement> e = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[1]/section[2]/div[2]/div/div/section"));
        for (WebElement l : e) {
            String employee = l.getText();
            System.out.println(employee);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
