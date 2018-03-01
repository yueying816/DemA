package practiceFive;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Switch {
	private WebDriver driver;
	private String currentWindow;
	
	public Switch(WebDriver driver) {
		this.driver = driver;
		currentWindow = driver.getWindowHandle();
	}
	
	//��ת���ƶ���window
	public void toSpecificWindow(String partialTitleName){
		Set<String> handles = driver.getWindowHandles();
		String titleName;
		for(String handle:handles) {
			titleName = driver.switchTo().window(handle).getTitle();
			if (titleName.equals(partialTitleName)) 
				break;
		}
	}
	
	//����ԭwindow
	public void backToCurrentWindow() {
		driver.switchTo().window(currentWindow);
	}

}
