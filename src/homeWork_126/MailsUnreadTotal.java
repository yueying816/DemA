package homeWork_126;

import java.util.List;

import launch.Browsers;
import launch.BrowsersType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import practiceFour.ParseProperties;
import practiceFour.Wait;

public class MailsUnreadTotal {
	private WebDriver driver = null ;
	private String projectPath = System.getProperty("user.dir") ;
	private ParseProperties data ;
	private ParseProperties locators ;
	private Wait wait ;
	
	@Parameters({"data" , "locators"})
	@BeforeClass
	public void inital(@Optional("aaa")String da , @Optional("aaa") String locator) {
		Browsers browser = new Browsers(BrowsersType.firefox) ;
		driver = browser.driver ;
		wait = new Wait(driver) ;

		data = new ParseProperties( projectPath + da) ;
		locators = new ParseProperties( projectPath + locator) ;
	}
	
	@Test
	public void loginMail() {
		
		driver.get(data.getValue("url"));
		
		driver.switchTo().frame(driver.findElement(By.xpath(locators.getValue("iframe"))));
		
		driver.findElement(By.xpath(locators.getValue("userName"))).clear();
		driver.findElement(By.xpath(locators.getValue("userName"))).sendKeys(data.getValue("userName")); 
		driver.findElement(By.xpath(locators.getValue("password"))).sendKeys(data.getValue("password")); 
		driver.findElement(By.xpath(locators.getValue("submit"))).click();
		
		wait.waitFor(3000);
		wait.waitForElementPresent(locators.getValue("homePage"));
	}
	
	@Test
	public void countUnreadMails() {
		//获取收件箱的未读总数
		String totalMails = driver.findElement(By.xpath(locators.getValue("totalMails"))).getText();
		System.out.println("--totalMails--:" + totalMails);
		int totalMailsNum = Integer.parseInt(totalMails.substring(1, totalMails.length()-1));
		System.out.println("--totalMailsNum--:" + totalMailsNum);
		//统计实际的未读邮件
		driver.findElement(By.xpath(locators.getValue("inBox"))).click();
		wait.waitFor(3000);
		driver.findElement(By.xpath(locators.getValue("unReadMails"))).click();
		wait.waitFor(5000);
		wait.waitForElementPresent(locators.getValue("listPage"));
		String listPage1 = driver.findElement(By.xpath(locators.getValue("listPage"))).getText();
		System.out.println("--listPage1--" + listPage1) ;

		//int listPage = Integer.parseInt(listPage1.split("/")[1]);
		int unreadMailsCounts = 0;
		while(true) {
			List<WebElement> elements = driver.findElements(By.xpath(locators.getValue("selectButten")));			
			unreadMailsCounts = elements.size() + unreadMailsCounts ;
			System.out.println("--unreadMailsCounts--:" + unreadMailsCounts);
			try{
				driver.findElement(By.xpath(locators.getValue("nextPageButten"))).click();;
				wait.waitFor(3000);
			} catch(Exception e) {
				break;
			}
		
		}
		
		System.out.println("--unreadMailsCounts--:" + unreadMailsCounts);
		Assert.assertEquals(totalMailsNum, unreadMailsCounts);
		
		
	}
	
	@AfterClass
	public void release() {
		driver.quit();
	}
	
	

}
