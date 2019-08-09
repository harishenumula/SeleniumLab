package autoit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Fileuploading {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.id("btnLogin")).click();

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();

		driver.findElement(By.id("firstName")).sendKeys("Harish");
		driver.findElement(By.id("lastName")).sendKeys("1283817023");
		Thread.sleep(2000);
		WebElement photo_upload;
		photo_upload=driver.findElement(By.id("photofile"));
		
		photo_upload.sendKeys("e:\\Penguins.jpg");

		Thread.sleep(5000);

	//	Runtime.getRuntime().exec("e:\\fileupload.exe");

		driver.findElement(By.id("btnSave")).click();

	}

}
