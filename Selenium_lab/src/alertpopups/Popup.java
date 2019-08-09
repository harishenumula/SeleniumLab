package alertpopups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Popup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://primusbank.qedgetech.com");
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String data = alert.getText();
		Thread.sleep(2000);
		System.out.println("msg" + data);

		alert.accept();
		Thread.sleep(2000);
		//alert.dismiss();
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
	}

}
