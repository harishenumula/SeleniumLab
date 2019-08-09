package operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Orangehrm_calendar_operation {
	static WebDriver driver;

	

	public static void Orangehrm_calendar_operations() {
		driver = new ChromeDriver();

		driver.get("http://orangehrm.qedgetech.com");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");

		driver.findElement(By.id("btnLogin")).click();

		driver.findElement(By.linkText("Recruitment")).click();
		driver.findElement(By.linkText("Candidates")).click();
		driver.findElement(By.id("candidateSearch_fromDate")).click();

		WebElement year = driver.findElement(By.className("ui-datepicker-year"));
		// year
		Select year_list = new Select(year);
		year_list.selectByVisibleText("1950");

		WebElement mon = driver.findElement(By.className("ui-datepicker-month"));
		// month
		Select month_list = new Select(mon);
		month_list.selectByVisibleText("Nov");
		// Date
		WebElement Cal_table = driver.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> Rows, Cols;

		// picking Rows

		Rows = Cal_table.findElements(By.tagName("tr"));

		String Exp_date = "15/Nov/1950";
		String[] date_temp = Exp_date.split("/");
		boolean Date_found = false;

		System.out.println(date_temp);
		for (int i = 1; i < Rows.size(); i++) {
			Cols = Rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < Cols.size(); j++) {
				String date = Cols.get(j).getText();
				System.out.println(date);
				if (date_temp[0].equalsIgnoreCase(date)) {
					Cols.get(j).click();
					Date_found = true;
					break;

				}

			}
			if (Date_found) {
				break;

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orangehrm_calendar_operations();
	}
}
