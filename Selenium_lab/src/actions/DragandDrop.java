package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/");
		driver.findElement(By.linkText("Droppable")).click();

		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement srcElement, trgElement;
		srcElement = driver.findElement(By.id("draggable"));
		trgElement = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.dragAndDrop(srcElement, trgElement).build().perform();
		System.out.println("Task Completed");
	}

}
