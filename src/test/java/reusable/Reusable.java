package reusable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class Reusable {

        public String getGlobalData(String key) {
            String data = null;
            try {

                Properties prop = new Properties(); //creating object for the property file because we are reading the objects ogf the property file..
                prop.load(new FileInputStream(System.getProperty("user.dir")+"\\global.properties"));
                data= prop.getProperty(key);

                // whoever import this project this path will be change
                //so in java by default it is written so we can use that path as default.. using stack flow
                //loading data
                //in global properties left hand side are key and right are the valuses.
                //System.getProperty("user.dir"); ..this immediate project directory where u have the file

            }

            catch (Exception e) {e.printStackTrace();}
            return data;
        }


        public WebDriver getDriver(){
            WebDriver driver= null;
            try{
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(getGlobalData("url")); //RES. NOT REQUIRED
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            }
            catch(Exception e){e.printStackTrace();}
            return driver;
        }
    }


