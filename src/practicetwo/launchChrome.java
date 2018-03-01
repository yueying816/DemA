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
	private static DesiredCapabilities caps = null ;  //�������������ʱ�Ĳ������ã�����session��ʱ���Ǳ����ṩ��
	private String projectPath = System.getProperty("user.dir");  //�û��ĵ�ǰ����Ŀ¼ 
	
	@BeforeClass
	public void startChromewb() {
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/tool/chromedriver.exe"); //����IEDriver·��
		caps = DesiredCapabilities.chrome();
		caps.setCapability("chrome.switche", Arrays.asList("--start-maximized"));  //���browser
		chromewb = new ChromeDriver(caps);  //selenium����chrome
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
