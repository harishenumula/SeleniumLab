package operations;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Practices {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("WebDriver.gecko.Driver", "E:\\selenium jars\\geckodriver-v0.24.0-win64.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://orangehrm.qedgetech.com");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.id("btnLogin")).click();

		/*
		 * driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']")).click();//
		 * 
		 * driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']")).click();
		 */
		search_emp1();

	}

	public static void add_employee() {
		// Add Employee Details
		driver.navigate().to("http://orangehrm.qedgetech.com/symfony/web/index.php/pim/addEmployee");
		driver.findElement(By.id("firstName")).sendKeys("Harish");
		driver.findElement(By.id("lastName")).sendKeys("4562156");
		driver.findElement(By.id("chkLogin")).click();

		driver.findElement(By.id("user_name")).sendKeys("Harish123");
		driver.findElement(By.id("user_password")).sendKeys("Harish@123");
		// re_password
		driver.findElement(By.id("re_password")).sendKeys("Harish@123");
		Select status_selector = new Select(driver.findElement(By.id("status")));
		status_selector.selectByVisibleText("Enabled");

		driver.findElement(By.id("btnSave")).click();
	}

	public static void search_emp() {
		driver.navigate().to("http://orangehrm.qedgetech.com/symfony/web/index.php/pim/viewEmployeeList/reset/1");//
		WebElement emp_table = driver.findElement(By.id("resultTable"));
		java.util.List<WebElement> cols, rows;
		rows = emp_table.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++) {
			rows.get(i).getText();
			System.out.println(rows);
		}

	}

//Using Xpath
	public static void search_emp1() {
		driver.navigate().to("http://orangehrm.qedgetech.com/symfony/web/index.php/pim/viewEmployeeList/reset/1");//

		driver.findElement(
				By.xpath("//*[contains(text(),'harish')]/parent::td//preceding-sibling::td//input[@type='checkbox']"))
				.click();
		driver.findElement(By.id("btnDelete")).click();
//Handling alert
	}

}
