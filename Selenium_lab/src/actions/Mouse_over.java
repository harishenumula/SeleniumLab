package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_over {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.snapdeal.com/");
		Actions acct = new Actions(driver);
		acct.moveToElement(driver.findElement(By.xpath("//div[2]/ul/li[2]/a/span[2]"))).build().perform();;
		//acct.build().perform();

		Thread.sleep(5000);
		
		acct.contextClick(driver.findElement(By.linkText("Smartphones")));
		acct.build().perform();
		//acct.
		
		
	}

}
