package newScripts;

import org.testng.annotations.Test;

public class TestScenario_004 {

    @Test(priority = 1)
    public void TC001_Scenario004(){
        System.out.println("This is TC 001 under Scenario004");
    }

    @Test() // Default priority === 0
    public void TC002_Scenario004(){
        System.out.println("This is TC 002 under Scenario004");
    }

    @Test(priority = -1)
    public void TC003_Scenario004(){
        System.out.println("This is TC 003 under Scenario004");
    }

    @Test(priority = -2)
    public void TC004_Scenario004(){
        System.out.println("This is TC 004 under Scenario004");
    }
}



