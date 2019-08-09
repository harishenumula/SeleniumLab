package alreadyOpenBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Already123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		System.setProperty("webdriver.chrome.driver", "E:\\selenium_jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
		WebDriver driver = new ChromeDriver(options);
		System.out.println(driver.getTitle());

	}

}
