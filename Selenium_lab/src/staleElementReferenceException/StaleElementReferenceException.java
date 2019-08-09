package staleElementReferenceException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StaleElementReferenceException {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://primusbank.qedgetech.com");
		driver.findElement(By.linkText("Site Map")).click();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		/*
		 * for (WebElement ee : links) { System.out.println(ee.getText());
		 * System.out.println(ee.getAttribute("href")); }
		 */
		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText() + "\t\t::" + links.get(i).getAttribute("href")+"::"+driver.getCurrentUrl());
			links.get(i).click();
			driver.navigate().back();
			Thread.sleep(3000);

			links=driver.findElements(By.tagName("a"));
		}
	}

}
