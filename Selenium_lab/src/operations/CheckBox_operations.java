package operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox_operations {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com");

		List<WebElement> check_box = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(check_box.size());
		Thread.sleep(4000);
		for (int i = 0; i < check_box.size(); i++) {
			String chec = check_box.get(i).getAttribute("name");
			System.out.println(chec + "555");
		}
		driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
		// check_box.get(i).click();
		Thread.sleep(2000);

		driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
		driver.close();
	}

	public static void browser_config() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		// ChromeDriver driver = new ChromeDriver();
		driver = new FirefoxDriver();
	}

	public static void open_site() {
		driver.get("http://spicejet.com");
	}
}
