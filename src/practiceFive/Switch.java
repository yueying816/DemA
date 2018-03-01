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
	
	//跳转到制定的window
	public void toSpecificWindow(String partialTitleName){
		Set<String> handles = driver.getWindowHandles();
		String titleName;
		for(String handle:handles) {
			titleName = driver.switchTo().window(handle).getTitle();
			if (titleName.equals(partialTitleName)) 
				break;
		}
	}
	
	//返回原window
	public void backToCurrentWindow() {
		driver.switchTo().window(currentWindow);
	}

}
