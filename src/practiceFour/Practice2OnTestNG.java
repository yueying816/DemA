package practiceFour;

import launch.Browsers;
import launch.BrowsersType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice2OnTestNG {
	
	protected static WebDriver driver = null;
	private static DesiredCapabilities caps = null;
	private String projectPath = System.getProperty("user.dir");
	
	private ParseProperties data;
	private ParseProperties locators;
	private Wait wait ;
	
	@Parameters({"data","locators"})
	@BeforeClass
	public void startIE(@Optional("data") String da , @Optional("locator1")String loc) {
		data = new ParseProperties( projectPath + da) ;
		locators = new ParseProperties( projectPath + loc) ;
		
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		wait = new Wait(driver);
		
	}
	
	@Test
	public void accessMail() {
		
		driver.get(data.getValue("url"));
		 String currentWindow1 = driver.getWindowHandle();
		 System.out.println("---1----:"+ currentWindow1);

		driver.switchTo().frame(driver.findElement(By.xpath(locators.getValue("iframe"))));
		wait.waitForElementPresent(locators.getValue("userName"));
	
		driver.findElement(By.xpath(locators.getValue("userName"))).clear();
		driver.findElement(By.xpath(locators.getValue("userName"))).sendKeys(data.getValue("userName"));
		driver.findElement(By.xpath(locators.getValue("password"))).sendKeys(data.getValue("password"));
		driver.findElement(By.xpath(locators.getValue("submit"))).click();
		wait.waitFor(5000);
		String currentWindow2 = driver.getWindowHandle();

		System.out.println("---2----:"+ currentWindow2);
		System.out.println(locators.getValue("homePage"));
		System.out.println(locators.getValue("sendBox"));
		
		wait.waitForElementPresent(locators.getValue("homePage"));
		
		//Assert.assertEquals(driver.findElement(By.xpath(locators.getValue("sendBox"))).isDisplayed(), true);
		
		wait.waitFor(5000);
	}
	
	//@Test
	public void getUnReadMails() {
		int expectedRes = 40;
		String unreadMailsNum = driver.findElement(By.xpath(locators.getValue("inboxMailsNum"))).getText();
		String str = unreadMailsNum.substring(1, unreadMailsNum.length()-1);
		int i = Integer.valueOf(str);
		System.out.println(i);
		Assert.assertEquals((expectedRes==i), true);
	}
	
	@AfterClass
	public void release() {
		driver.quit();
	}

}
