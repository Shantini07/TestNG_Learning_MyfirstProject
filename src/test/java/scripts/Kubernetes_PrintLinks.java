package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.kubernetesPage;
import reusable.Actions;
import reusable.Reusable;

    public class Kubernetes_PrintLinks {

        private WebDriver driver;
        Reusable RES;
        Actions ACT;
        kubernetesPage KBT;


        @BeforeClass
        public void launchApp(){

            try {
                KBT = new kubernetesPage();
                RES = new Reusable();
                driver = RES.getDriver();
                ACT = new Actions(driver);
            }
            catch(Exception e){e.printStackTrace();}
        }

        @Test
        public void print_All_Links(){

            // Get total number if links present ...

            int links = driver.findElements(By.xpath("//a")).size();
            System.out.println("Total links count ==>"+links);

            for(int i=1;i<links;i++){

                String link = driver.findElement(By.xpath("(//a)["+i+"]")).getText();
                System.out.println("The link with position==>"+i+" is==>"+link);
            }
        }

        @AfterClass
        public void closeApp(){

            driver.quit();
        }

    }


