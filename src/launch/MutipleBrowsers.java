package launch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MutipleBrowsers {
	private Browsers browser = null ;
	private WebDriver driver = null;
	
	@Parameters({"Browser"})
	@BeforeClass(groups="browser")
	public void inital(String platform){
		if(platform.equals("ie")) {
			browser = new Browsers(BrowsersType.ie);
		}
		else if(platform.equals("chrome")) {
			browser = new Browsers(BrowsersType.chrome);
		}
		else{
			browser = new Browsers(BrowsersType.firefox);
		}
		
		driver = browser.driver;
	}
	
	@Test(groups="method1")
	public void method2() {
		driver.get("http://www.baidu.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("---method1---");
	}
	
	@Test(groups="method2")
	public void method3() {
		driver.get("http://www.qq.com");
	}
	
	@Test(groups="method3")
	public void method4() {
		driver.get("http://mail.qq.com");
	}
	
	@Test(groups="method4")
	public void method5() {
		driver.get("http://www.126.com");
	}
	
	@AfterClass (groups="browser")
	public void release() {
		driver.quit();
	}
	

}
