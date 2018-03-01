package practiceFour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	private WebDriver driver;
	private int timeOut = 60;
	
	public Wait(WebDriver driver) {
		this.driver = driver ;
	}
	
	public void waitForElementPresent(String locator) {
		try {
			(new WebDriverWait(driver , timeOut)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		} catch(Exception e) {
			
		}
	}
	
	public void watiForElementIsEnable(String locator) {
		(new WebDriverWait(driver , timeOut)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	
	
	public void waitFor(long timeOut) {
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
