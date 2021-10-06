package uitests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

   public void onTestStart(ITestResult result) {
       System.out.println("before the start of the test");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("when test passes");
    }


    public void onTestFailure(ITestResult result) {
        System.out.println("when test fails");
    }

    public  void onTestSkipped(ITestResult result) {
        System.out.println("when test skips");
    }






}
