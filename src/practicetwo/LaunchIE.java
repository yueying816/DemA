package practicetwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchIE {
	
	private static WebDriver iewb = null;
	private static DesiredCapabilities caps = null ;  //�������������ʱ�Ĳ������ã�����session��ʱ���Ǳ����ṩ��
	private String projectPath = System.getProperty("user.dir");  //�û��ĵ�ǰ����Ŀ¼ 
	
	@BeforeClass
	public void startIE() {
		System.out.println(projectPath);
		System.setProperty("webdriver.ie.driver", projectPath + "/tool/IEDriverServer.exe");  //����IEDriver·��
		caps = DesiredCapabilities.internetExplorer();  //IE������ֵ
		//caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);  //ʵ�ֺ���IE��Protected Mode����
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");  //����ΪInPrivate ģʽ����ģʽ�²��Ỻ������
		caps.setCapability("ignoreZoomSetting", true);  //�Ŵ���С����
		iewb = new InternetExplorerDriver(caps);  //selenium����IE
		
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
