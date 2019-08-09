package alertpopups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertS_popups {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();

		String alert_msg = alert.getText();
		System.out.println(alert_msg);
		if (alert_msg.equalsIgnoreCase("Please enter a valid user name")) {
			System.out.println("Correct");
		} else {
		}
		System.out.println("Incorrect");

		alert.accept();
		
		
		//fileup

	}

}
