package newScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScenario_002 {

    @BeforeClass
    public void beforeClass_002(){
        System.out.println("This is Before class under Test Scenario 002");
    }

    @Test(groups = {"sanity","e2e"})
    public void TC001_Scenario002(){
        System.out.println("This is TC 001 under Scenario002");
    }
    @Test(groups = {"sanity","regression"})
    public void TC002_Scenario002(){
        System.out.println("This is TC 002 under Scenario002");
    }
    @Test(groups = {"regression"})
    public void TC003_Scenario002(){
        System.out.println("This is TC 003 under Scenario002");
    }
    @Test(groups = {"sanity","smoke"})
    public void TC004_Scenario002(){
        System.out.println("This is TC 004 under Scenario002");
    }
    @Test(groups = {"smoke"})
    public void TC005_Scenario002(){
        System.out.println("This is TC 005 under Scenario002");
    }
    @Test(groups = {"sanity"})
    public void TC006_Scenario002(){
        System.out.println("This is TC 006 under Scenario002");
    }
    @Test(groups = {"e2e"})
    public void TC007_Scenario002(){
        System.out.println("This is TC 007 under Scenario002");
    }
    @Test(groups = {"smoke", "regression"})
    public void TC008_Scenario002(){
        System.out.println("This is TC 008 under Scenario002");
    }
    @Test(groups = {"smoke", "e2e"})
    public void TC009_Scenario002(){
        System.out.println("This is TC 009 under Scenario002");
    }

    @AfterClass
    public void AFterClass_002(){
        System.out.println("This is After class under Test Scenario 002");
    }

}
