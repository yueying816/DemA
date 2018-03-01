package practicetwo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class launchFF {
	
	private static WebDriver ffwb = null;
	private FirefoxProfile firefoxprofile = null ;
	private String projectPath = System.getProperty("user.dir");  //用户的当前工作目录 
	
	@BeforeClass
	public void startFirefox() throws IOException {
		System.setProperty("webdriver.firefox.bin", "D:/softWare/Mozilla Firefox/firefox.exe");
		firefoxprofile = new FirefoxProfile();
		firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true");
		ffwb = new FirefoxDriver(firefoxprofile);
		//ffwb = new FirefoxDriver();
	}
	
	@Test
	public void searchOnQQMails() {
		ffwb.get("https://mail.qq.com");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ffwb.switchTo().frame(ffwb.findElement(By.xpath("//iframe[@id='login_frame']")));
		ffwb.findElement(By.xpath("//input[@id='u']")).clear();

	}
	
	@AfterClass
	public void releaseFFDriver() {
		ffwb.quit();
	}

}
