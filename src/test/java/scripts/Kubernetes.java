package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reusable.*;
import pageObject.*;

public class Kubernetes {

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
        public void Validate_Kubernetes_HeaderMenus(){

            String current_URL=driver.getCurrentUrl();
            String page_title=driver.getTitle();

            System.out.println("Current Page URL ===>" + current_URL);
            System.out.println("Current Page Title ===>" + page_title);

            ACT.CheckForElement(KBT.headerLink("Documentation"));
            ACT.CheckForElement(KBT.headerLink("Kubernetes Blog"));
            ACT.CheckForElement(KBT.headerLink("Training"));
            ACT.CheckForElement(KBT.headerLink("Partners"));
            ACT.CheckForElement(KBT.headerLink("Community"));


            // Get CSS Element ...

            String color = ACT.getCSSValue(KBT.headerLink("Documentation"),"color");
            color = Color.fromString(color).asHex(); //converted Into HexFormat
            String font_weight = ACT.getCSSValue(KBT.headerLink("Documentation"),"font-weight");
            String background_color = ACT.getCSSValue(KBT.headerLink("Documentation"),"background-color");
            background_color = Color.fromString(background_color).asHex(); //converted Into HexFormat
            String font_family = ACT.getCSSValue(KBT.headerLink("Documentation"),"font-family");
            String font_size = ACT.getCSSValue(KBT.headerLink("Documentation"),"font-size");

            System.out.println("color:"+color);
            System.out.println("font-weight:"+font_weight);
            System.out.println("background_color:"+background_color);
            System.out.println("font_family:"+font_family);
            System.out.println("font_size:"+font_size);

        }

        @AfterClass
        public void closeApp(){

            driver.quit();
        }

    }


