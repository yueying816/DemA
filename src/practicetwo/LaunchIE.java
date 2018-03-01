package practicetwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchIE {
	
	private static WebDriver iewb = null;
	private static DesiredCapabilities caps = null ;  //负责启动服务端时的参数设置，启动session的时候是必须提供的
	private String projectPath = System.getProperty("user.dir");  //用户的当前工作目录 
	
	@BeforeClass
	public void startIE() {
		System.out.println(projectPath);
		System.setProperty("webdriver.ie.driver", projectPath + "/tool/IEDriverServer.exe");  //设置IEDriver路径
		caps = DesiredCapabilities.internetExplorer();  //IE的属性值
		//caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);  //实现忽略IE的Protected Mode设置
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");  //设置为InPrivate 模式，此模式下不会缓存内容
		caps.setCapability("ignoreZoomSetting", true);  //放大缩小功能
		iewb = new InternetExplorerDriver(caps);  //selenium启动IE
		
	}
	
	@Test
	public void searchOnBaidu() {
		iewb.get("http://www.baidu.com");
		try{
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void releaseIEDriver() {
		iewb.quit();
	}
	
	
	
	
	

}
