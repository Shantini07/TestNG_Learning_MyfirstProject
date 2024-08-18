package reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class Actions {


        public WebDriver driver=null;

        public boolean CheckForElement(String xpath){
            boolean FLAG = false;
            try{
                driver.findElement(By.xpath(xpath)).isDisplayed();
                FLAG = true;
            }
            catch(Exception e){e.printStackTrace();}
            return FLAG;
        }



        public Actions(WebDriver driver){
            this.driver = driver; //parametrized constructor
        }


        // Creating a Reusable Method to type into a Tex Box ....


        public void TypeIntoATextBox(String xpath,String data){
            try{
                driver.findElement(By.xpath(xpath)).sendKeys(data);
            }
            catch(Exception e){e.printStackTrace();}
        }


        public String readText(String xpath){
            String FLAG = null;
            try{
                FLAG = driver.findElement(By.xpath(xpath)).getText();
            }
            catch(Exception e){e.printStackTrace();}
            return FLAG;
        }


        public boolean ClickAndWait(String xpath,String data){
            boolean FLAG = false;
            try{
                driver.findElement(By.xpath(xpath)).sendKeys(data);
                FLAG = true;
            }
            catch(Exception e){e.printStackTrace();}
            return FLAG;
        }


        public boolean SelectADropDown(String xpath,String data){
            boolean FLAG = false;
            try{
                driver.findElement(By.xpath(xpath)).sendKeys(data);
                FLAG = true;
            }
            catch(Exception e){e.printStackTrace();}
            return FLAG;
        }

        public String getCSSValue(String xpath , String what){
            String FLAG = null;
            try{
                FLAG = driver.findElement(By.xpath(xpath)).getCssValue(what);
            }
            catch(Exception e){e.printStackTrace();}
            return FLAG;
        }



    }






