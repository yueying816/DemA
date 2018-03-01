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
	//��Ҫ���Ի��������������ȡ��ʹ�õ�Actionsģ��
	public void changeiFrame() {
		driver.get("http://jqueryui.com/slider/");
		wait.waitForElementPresent("//div[@id='sidebar']/aside[1]/h3");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		Point initialPoint = driver.findElement(By.xpath("//div[@id='slider']/span")).getLocation() ;
		System.out.println(initialPoint) ;
		
		//��ק����
		Actions dragger = new Actions(driver);
		//dragAndDropBy:�ϡ��Ų���
		dragger.dragAndDropBy(driver.findElement(By.xpath("//div[@id='slider']/span")), initialPoint.getX()+569, initialPoint.getY()).build().perform();
		initialPoint = driver.findElement(By.xpath("//div[@id='slider']/span")).getLocation() ;
		System.out.println(initialPoint) ;
		wait.waitFor(5000);
		
		driver.switchTo().defaultContent();  //��iframe1��ת��top_window
		driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[1]/a")).click();
		wait.waitFor(5000);
	}
	
	@Test
	//��Ҫ��֤selectѡ��
	public void selectItemFromDropDownList(){
		driver.get("http://www.jd.com");
		wait.waitForElementPresent("//a[text()='��ã����¼']");
		driver.findElement(By.xpath("//a[text()='��ã����¼']")).click();
		wait.waitForElementPresent("//a[text()='�˻���¼']");
		driver.findElement(By.xpath("//a[text()='�˻���¼']")).click();
		
		//�û����������¼
		driver.findElement(By.xpath("//input[@id='loginname']")).clear();
		driver.findElement(By.xpath("//input[@id='loginname']")).sendKeys("yueying816@126.com");
		driver.findElement(By.xpath("//input[@id='nloginpwd']")).sendKeys("602215ly");
		driver.findElement(By.xpath("//a[@id='loginsubmit']")).click();
		wait.waitFor(25000);
		
		//��¼������Ϣ
		driver.findElement(By.xpath("//a[text()='�ҵĶ���']")).click();
		wait.waitFor(5000);
		//��תwindow����
		Switch swithcW = new Switch(driver);
		swithcW.toSpecificWindow("�ҵľ���--�ҵĶ���");  
		driver.findElement(By.xpath("//a[text()='������Ϣ']")).click();
	}
	
	@AfterClass
	public void release() {
		driver.quit();
	}

}
