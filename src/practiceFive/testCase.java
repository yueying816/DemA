package practiceFive;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import launch.Browsers;
import launch.BrowsersType;
import practiceFour.Wait;

public class testCase {
	private WebDriver driver;
	Wait wait ;
	
	@BeforeClass
	public void inital() {
		Browsers browser = new Browsers(BrowsersType.firefox) ;
		driver = browser.driver ;
		wait = new Wait(driver) ;
	}
	
	@Test
	//主要测试滑块拉动，坐标获取，使用到Actions模块
	public void changeiFrame() {
		driver.get("http://jqueryui.com/slider/");
		wait.waitForElementPresent("//div[@id='sidebar']/aside[1]/h3");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		Point initialPoint = driver.findElement(By.xpath("//div[@id='slider']/span")).getLocation() ;
		System.out.println(initialPoint) ;
		
		//拖拽滑块
		Actions dragger = new Actions(driver);
		//dragAndDropBy:拖、放操作
		dragger.dragAndDropBy(driver.findElement(By.xpath("//div[@id='slider']/span")), initialPoint.getX()+569, initialPoint.getY()).build().perform();
		initialPoint = driver.findElement(By.xpath("//div[@id='slider']/span")).getLocation() ;
		System.out.println(initialPoint) ;
		wait.waitFor(5000);
		
		driver.switchTo().defaultContent();  //从iframe1跳转到top_window
		driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[1]/a")).click();
		wait.waitFor(5000);
	}
	
	@Test
	//主要验证select选择
	public void selectItemFromDropDownList(){
		driver.get("http://www.jd.com");
		wait.waitForElementPresent("//a[text()='你好，请登录']");
		driver.findElement(By.xpath("//a[text()='你好，请登录']")).click();
		wait.waitForElementPresent("//a[text()='账户登录']");
		driver.findElement(By.xpath("//a[text()='账户登录']")).click();
		
		//用户名、密码登录
		driver.findElement(By.xpath("//input[@id='loginname']")).clear();
		driver.findElement(By.xpath("//input[@id='loginname']")).sendKeys("yueying816@126.com");
		driver.findElement(By.xpath("//input[@id='nloginpwd']")).sendKeys("602215ly");
		driver.findElement(By.xpath("//a[@id='loginsubmit']")).click();
		wait.waitFor(25000);
		
		//登录个人信息
		driver.findElement(By.xpath("//a[text()='我的订单']")).click();
		wait.waitFor(5000);
		//跳转window窗口
		Switch swithcW = new Switch(driver);
		swithcW.toSpecificWindow("我的京东--我的订单");  
		driver.findElement(By.xpath("//a[text()='个人信息']")).click();
	}
	
	@AfterClass
	public void release() {
		driver.quit();
	}

}
