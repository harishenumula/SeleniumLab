package operations;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table_operations {
	static WebDriver driver;
	static Table_operations t_operation = new Table_operations();

	public static void main(String[] args) {
		// t_operation.method1();
		t_operation.method2();
		t_operation.view_emp_data();
	}

	public void view_emp_data() {
		driver = new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/");
		WebElement uid = driver.findElement(By.id("txtuId"));
		uid.sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();

		driver.findElement(By.xpath("//img[@src='images/emp_btn.jpg']")).click();

	}

	public void method2() {
		// Edit
		// driver.findElement(By.xpath("//*[contains(text(),'AAAAqqq')]//parent::td//following-sibling::td[1]//a")).click();
		// Delete;
		// using empid
		driver.findElement(By.xpath("//*[contains(text(),'1675')]//parent::td//following-sibling::td[6]//a")).click();
		Alert deleteconfirmation = driver.switchTo().alert();
		deleteconfirmation.accept();

	}/*
		 * //*[contains(text(),'AAAAqqq')]/parent:td//following-sibling::td[2]//a
		 * //*[contains(text(),'AAAAqqq')]//parent::td//following-sibling::td[2]//a
		 * //*[contains(text(),'AAAAqqq')]//parent:td//following-sibling::td[2]//a
		 */

	public void method1() {
		driver = new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();

		driver.findElement(By.xpath("//img[@src='images/emp_btn.jpg']")).click();

		// 1) Selecting table
		WebElement emp_table = driver.findElement(By.id("DGBanker"));

		// 2) Select rows
		List<WebElement> rows, cols;
		rows = emp_table.findElements(By.tagName("tr"));

		// 3) No of Rows
		System.out.println("No of Rows ::" + rows.size());

		// 4) No of Columns in table
		for (int i = 0; i < rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));
			System.out.println("rows ::" + (i + 1) + "No of columns" + cols.size());
		}

		System.out.println("---------------------------");
		// System.out.println("No of Columns in tables"+cols.size());

		// Only data no table Header
		System.out.println("********************************************");
		for (int i = 1; i < rows.size() - 1; i++) {
			System.out.println(rows.get(i).getText());
		}

		System.out.println("********************************************");
		// Full Data Include table Header and last row of table
		for (int i = 0; i < rows.size(); i++) {
			System.out.println(rows.get(i).getText());
		}
		// printing Only Emp_No,Emp-name,
		System.out.println();

		System.out.println("no of rows********************" + rows.size());
		for (int i = 1; i < rows.size() - 1; i++) {

			cols = rows.get(i).findElements(By.tagName("td"));

			// System.out.println(cols.size());
			String Emp_no = cols.get(0).getText();
			String Emp_name = cols.get(1).getText();
			System.out.println(Emp_no + "::" + Emp_name);

		}
		driver.close();

	}
}
