package operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Emp_id_name {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();

		driver.findElement(By.xpath("//img[@src='images/Branches_but.jpg']")).click();

		// 1) Selecting table
		WebElement emp_table = driver.findElement(By.id("DGBanker"));

		// 2) Select rows
		List<WebElement> rows, cols;
		rows = emp_table.findElements(By.tagName("tr"));

		for (int i = 1; i < rows.size() - 1; i++) {
			// 3) Select Columns
			cols = rows.get(i).findElements(By.tagName("td"));
			String Emp_id = cols.get(0).getText();
			String Emp_name = cols.get(1).getText();
			System.out.println(Emp_id + "::" + Emp_name);
		}
	}

}
