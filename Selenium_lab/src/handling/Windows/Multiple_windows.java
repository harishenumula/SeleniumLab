package handling.Windows;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiple_windows {

	public static void main(String[] args) throws InterruptedException {
//System.se
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String URL = "http://gmail.com";
		driver.get(URL);
		String window1_title = driver.getTitle();
		System.out.println(window1_title);

		Thread.sleep(3000);
		String window1_id = driver.getWindowHandle();
		System.out.println("Window1 id : " + window1_id);

		driver.findElement(By.linkText("Help")).click();

		Set<String> all_windows_ids = driver.getWindowHandles();
		Object[] temp = all_windows_ids.toArray();

		for (int i = 0; i < temp.length; i++) {
			System.out.println("Window No" + (i + 1) + " :: Id is  ::" + temp[i].toString());
		}
		driver.switchTo().window(temp[1].toString());
		boolean Community = driver.findElement(By.linkText("Community")).isDisplayed();
		System.out.println("looking for community" + Community);
		Thread.sleep(1000);

		driver.close();
		// System.out.println("looking for community" +
		// driver.findElement(By.linkText("Community")).isDisplayed());

		//System.out.println("current window id is :" + driver.getWindowHandle());
		//driver.findElement(By.linkText("Create account")).click();
	}

}
