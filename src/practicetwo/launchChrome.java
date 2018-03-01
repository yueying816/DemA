package practicetwo;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class launchChrome {

	
	private static WebDriver chromewb = null;
	private static DesiredCapabilities caps = null ;  //负责启动服务端时的参数设置，启动session的时候是必须提供的
	private String projectPath = System.getProperty("user.dir");  //用户的当前工作目录 
	
	@BeforeClass
	public void startChromewb() {
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/tool/chromedriver.exe"); //设置IEDriver路径
		caps = DesiredCapabilities.chrome();
		caps.setCapability("chrome.switche", Arrays.asList("--start-maximized"));  //最大化browser
		chromewb = new ChromeDriver(caps);  //selenium启动chrome
	}
	
	@Test
	public void searchOnBaiduChrome() {
		chromewb.get("http://www.baidu.com");
		
		try{
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void releaseIEDriver() {
		chromewb.quit();
	}
	

}
