
import org.testng.annotations.*;
public class qq {
    
    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest");
    }
    
    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }
    
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }
    
    @Test(groups="submodule1")
    public void test1() {
        System.out.println("test1");
    }
    
    @Test(groups="submodule2")
    public void test2() {
        System.out.println("test2");
    }
    
    @Test(groups="submodule3")
    public void test3() {
        System.out.println("test3");
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }
    
    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }
    
    @AfterTest
    public void afterTest() {
        System.out.println("afterTest");
    }
}
