package launch;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBrowsers {
	private WebDriver driver;
	private String caseName;
	
	@BeforeClass
	public void beforeClass() {
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		
	}
	
	@Test
	public void start() {
		caseName = "DoOne";
		driver.get("http://www.baidu.com");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='kw']")).clear();
		driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@id='kw']")).submit();
		//driver.findElement(By.xpath("//input[@name='email']")).clear();
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("yueying816");
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("602215ly");
		//driver.findElement(By.xpath("//input[@name='password']")).submit();
		Assert.assertEquals(true, true);
	}
	
	@AfterClass
	public void stop() {
		driver.quit();
	}

}
