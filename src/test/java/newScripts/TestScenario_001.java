package newScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScenario_001 {

    @BeforeClass
    public void beforeClass_001(){
        System.out.println("This is Before class under Test Scenario 001");
    }

    @Test(groups = {"smoke", "regression"})
    public void TC001_Scenario001(){
        System.out.println("This is TC 001 under Scenario001");
    }
    @Test(groups = {"smoke"})
    public void TC002_Scenario001(){
        System.out.println("This is TC 002 under Scenario001");
    }
    @Test (groups = {"e2e"})
    public void TC003_Scenario001(){
        System.out.println("This is TC 003 under Scenario001");
    }
    @Test(groups = {"smoke", "e2e"})
    public void TC004_Scenario001(){
        System.out.println("This is TC 004 under Scenario001");
    }
    @Test(groups = {"regression", "e2e"})
    public void TC005_Scenario001(){
        System.out.println("This is TC 005 under Scenario001");
    }
    @Test(groups = {"regression"})
    public void TC006_Scenario001(){
        System.out.println("This is TC 006 under Scenario001");
    }
    @Test(groups = {"smoke", "sanity"})
    public void TC007_Scenario001(){
        System.out.println("This is TC 007 under Scenario001");
    }
    @Test(groups = {"sanity"})
    public void TC008_Scenario001(){
        System.out.println("This is TC 008 under Scenario001");
    }
    @Test(groups = {"sanity","e2e"})
    public void TC009_Scenario001(){
        System.out.println("This is TC 009 under Scenario001");
    }

    @AfterClass
    public void AFterClass_002(){
        System.out.println("This is After class under Test Scenario 002");
    }

}

