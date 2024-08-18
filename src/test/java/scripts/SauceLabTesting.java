package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceLabTesting {
    public WebDriver driver;

    @BeforeSuite //before all test this before suite will execute
    @Parameters({"url"})
    public void launchSauceDemoApp(String url) {
        try {
            System.out.println("This is Before Suite");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
@Test
@Parameters({"username", "password"})
    public void SignIn(String username, String password) {
        try {
            if (driver.findElement(By.xpath("//div[text()='Swag Labs']")).isDisplayed()) {
                System.out.println("Swag Labs Header is Present ......");
            }
            else{
                System.out.println("Sauce Lab Header is not present");
            }

            driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("username");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
            driver.findElement(By.xpath("//input[@id='login-button']")).click();
            System.out.println("Login successfully done");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

@AfterSuite //after all test this will run
public void closeApp(){
    System.out.println("This is After Suite");
    driver.quit();
}

}
