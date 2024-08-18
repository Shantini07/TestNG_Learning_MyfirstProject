package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import reusable.Actions;
import reusable.Reusable;
import pageObject.*;

import java.time.Duration;

    public class SauceLabDemo {

            private WebDriver driver;
            Reusable RES;
            reusable.Actions ACT;
            signInPage SignIn_Page;

            @BeforeSuite
            public void Do_SomeDataSetUp(){
                System.out.println("This is Before Suite");
            }
            @BeforeClass
            public void launchapp() {
                try {

                    SignIn_Page=new signInPage();
                    RES = new Reusable();
                    driver=RES.getDriver();
                    ACT= new Actions(driver);
                    //DRIVER WHICH IS NULL IN ACTIONS TO MAKE AS ACTIVE..TO MAKE THE LOCAL ACTIONS NULL TO MAKE AS ACTIVE..

                    //CREATED RESUSABLE METHODS SO I COMMNETED THE BELOW LOGIN CODE
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get("url"); //instead of https://www.saucedemo.com/ we can simply write url as properties file.
//            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

                }
                catch (Exception e) {
                    e.printStackTrace();
                }

            }


            @Test
            public void validateCartFunctionality(){
                try {
                    loginToSauce();
                    readAvailableProductsData();
                    Add_To_Cart();
                }
                catch(Exception e){e.printStackTrace();}


            }


            public void loginToSauce() {
                try {
                    ACT.TypeIntoATextBox(SignIn_Page.UserName(),RES.getGlobalData("username"));
                    driver.findElement(By.xpath(SignIn_Page.Password())).sendKeys(RES.getGlobalData("password"));
                    driver.findElement(By.xpath(SignIn_Page.Submit())).click();
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                    if (driver.findElement(By.xpath("//button[text()='Open Menu']")).isDisplayed()) {
                        System.out.println("User Logged in Success ......");
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


            public void readAvailableProductsData() {
                try {


                    // First Product Details
                    String First_Name = ACT.readText("//div[@class='inventory_list']/div[1]/div[2]//a");
                    String First_price = driver.findElement(By.xpath("//div[@class='inventory_list']/div[1]/div[2]//div[@class='inventory_item_price']")).getText();
                    System.out.println("The First Product Name is==>"+First_Name);
                    System.out.println("The First Product Price is==>"+First_price);

                    // Second Product Details
                    String Second_Name = driver.findElement(By.xpath("//div[@class='inventory_list']/div[2]/div[2]//a")).getText();
                    String Second_Price = driver.findElement(By.xpath("//div[@class='inventory_list']/div[2]/div[2]//div[@class='inventory_item_price']")).getText();
                    System.out.println("The Second Product Name is==>"+Second_Name);
                    System.out.println("The Second Product Price is==>"+Second_Price);

                    // Third Product Details
                    String Third_Name = driver.findElement(By.xpath("//div[@class='inventory_list']/div[3]/div[2]//a")).getText();
                    String Third_Price = driver.findElement(By.xpath("//div[@class='inventory_list']/div[3]/div[2]//div[@class='inventory_item_price']")).getText();
                    System.out.println("The Third Product Name is==>"+Third_Name);
                    System.out.println("The Third Product Price is==>"+Third_Price);

                } catch(Exception e){e.printStackTrace();}
            }

            public void Add_To_Cart() {
                try {


                    // Click on First 3 products for Add to CaRT
                    driver.findElement(By.xpath("//div[@class='inventory_list']/div[1]/div[2]//button")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//div[@class='inventory_list']/div[2]/div[2]//button")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//div[@class='inventory_list']/div[3]/div[2]//button")).click();
                    Thread.sleep(2000);

                    // Check there are 3 remove buttons ...
                    int RemoveBTNCOunt = driver.findElements(By.xpath("//button[text()='Remove']")).size();
                    Assert.assertTrue(RemoveBTNCOunt==3);

                    // Now validate the Cart Image has count as 3 ...
                    String CartImageNumber = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
                    Assert.assertTrue(Integer.valueOf(CartImageNumber)==3);

                    // Click on Any Remove Button ...
                    driver.findElement(By.xpath("(//button[text()='Remove'])[1]")).click();
                    Thread.sleep(2000);

                    // Check there are 2 remove buttons now...
                    int RemoveBTNCOunt_new = driver.findElements(By.xpath("//button[text()='Remove']")).size();
                    Assert.assertTrue(RemoveBTNCOunt_new==2);

                    // Now validate the Cart Image has count as 3 ...
                    String CartImageNumber_new = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
                    Assert.assertTrue(Integer.valueOf(CartImageNumber_new)==2);

                    // CLick on Cart Icon ...
                    driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
                    Thread.sleep(5000);

                } catch(Exception e){e.printStackTrace();}
            }

            @AfterClass
            public void closeApp(){

                driver.quit();
            }
            @AfterSuite
            public void EndDataSetUp(){

                System.out.println("This is AfterSuite");
            }
        }

