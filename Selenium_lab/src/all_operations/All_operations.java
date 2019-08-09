package all_operations;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class All_operations {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new FirefoxDriver();

		login();
		remove_Employee();

	}

	public static void login() {
		driver.get("http://orangehrm.qedgetech.com");// get()
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");// by.id
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");// by.name
		driver.findElement(By.id("btnLogin")).click();

	}

	public static void add_employee() throws InterruptedException {
		Actions act = new Actions(driver);// Actions

		Thread.sleep(3000);
		act.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")));
		act.build().perform();

		driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();// xpath partial
		Thread.sleep(3000);

		String Act_Title = driver.getTitle();
		System.out.println("title" + Act_Title);

		if (Act_Title.equalsIgnoreCase("http://orangehrm.qedgetech.com/symfony/web/index.php/pim/addEmployee")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test Fail");
		}
		// add Employee Details

		driver.findElement(By.name("firstName")).sendKeys("Harish7894s");
		driver.findElement(By.id("lastName")).sendKeys("89755");

		System.out.println("" + driver.findElement(By.id("employeeId")).isDisplayed());// isdispalyed

		String Default_Emp_id = driver.findElement(By.id("employeeId")).getText();
		System.out.println("Emp id::" + Default_Emp_id);
		driver.findElement(By.id("employeeId")).click();
		driver.findElement(By.id("employeeId")).sendKeys("00078");

		if (!driver.findElement(By.id("chkLogin")).isSelected()) {// checkbox operation
			System.out.println("Checkbox not selected,\n selecting check box");
			driver.findElement(By.id("chkLogin")).click();
		}
		driver.findElement(By.id("user_name")).sendKeys("harish234567");
		driver.findElement(By.id("user_password")).sendKeys("Harish1234!@#$");
		driver.findElement(By.id("re_password")).sendKeys("Harish1234!@#$");
		WebElement status = driver.findElement(By.id("status"));
		Select status_select = new Select(status);

		status_select.selectByVisibleText("Enabled");
		Thread.sleep(3000);

		status_select.selectByVisibleText("Disabled");
		Thread.sleep(3000);

		status_select.selectByVisibleText("Enabled");
		Thread.sleep(3000);
		driver.findElement(By.id("btnSave")).click();

		// String Act_url= driver.getCurrentUrl();
		// if(Act_url.equalsIgnoreCase(""))

	}

	public static void remove_Employee() throws InterruptedException {
		Thread.sleep(1000);

		driver.navigate().to("http://orangehrm.qedgetech.com/symfony/web/index.php/pim/viewEmployeeList/reset/1");

		Thread.sleep(1000);
		WebElement table = driver.findElement(By.id("resultTable"));
		List<WebElement> cols, rows;
		rows = table.findElements(By.tagName("tr"));
		boolean found = false;
		// html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[4]/td[3]/a
		for (int i = 1; i < rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) {
				System.out.println(cols.get(j).getText());
				if (cols.get(j).getText().contains("harish")) {
					cols.get(0).click();
					found = true;
					break;
				}

			}
			if (found) {
				break;
			}
		}
		driver.findElement(By.name("btnDelete")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
}
