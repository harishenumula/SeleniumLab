package headlessmode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxHeadless {
	public static void main(String[] args) {

		FirefoxBinary firefoxBinary = new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");

		System.setProperty("webdriver.gecko.driver", "E:\\selenium jars\\geckodriver-v0.24.0-win64\\geckodriver.exe");

		FirefoxOptions fo = new FirefoxOptions();
		fo.setBinary(firefoxBinary);

		WebDriver driver = new FirefoxDriver(fo);
		driver.get("http://www.facebook.com");
		System.out.println("Title :: " + driver.getTitle());
	}

}
