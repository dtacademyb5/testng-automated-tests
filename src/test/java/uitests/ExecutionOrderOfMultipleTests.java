package uitests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ExecutionOrderOfMultipleTests {

   // Default execution order of multiple Tests in one class is alphabetical

    @Test (priority = 245, enabled = false)
    public void m1(){
        System.out.println("m1");
    }


    @Ignore
    public void z(){
        System.out.println("z");
    }


    @Test (groups = {"smoke"})
    public void a(){
        System.out.println("a");
    }


    @Test (priority = 0)
    public void n(){
        System.out.println("n");
    }
}
