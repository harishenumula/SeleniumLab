package primusbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Primusbankhome {

	public static WebDriver driver;

	public void launch_app(String url) {
		driver = new FirefoxDriver();
		driver.get(url);
	}

	public boolean login(String uid,String password) {
		driver.findElement(By.id("txtuId")).sendKeys("");
		return false;
	}

	public void close_app() {
	}
}
