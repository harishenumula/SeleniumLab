package operations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class cleartrip_calendar1 {
	static WebDriver driver;

	public static void cleartrip_calendar() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");

		String Exp_date = "32/March/2020";
		String[] Exp_date1 = Exp_date.split("/");
		String Exp_year = Exp_date1[2];
		String Exp_Month = Exp_date1[1];
		String Exp_day1 = Exp_date1[0];

		driver.findElement(By.id("DepartDate")).click();

		WebElement table = driver.findElement(By.className("calendar"));

		String Act_year = driver.findElement(By.className("ui-datepicker-year")).getText();
		System.out.println(Act_year);

		// 2020==2019
		while (!Exp_year.equals(Act_year)) {
			driver.findElement(By.className("nextMonth")).click();
			Act_year = driver.findElement(By.className("ui-datepicker-year")).getText();
			System.out.println(Act_year);

		}
		System.out.println("Years match,going for month");
		String Act_mon = driver.findElement(By.className("ui-datepicker-month")).getText();
		System.out.println(Act_mon);
		System.out.println("Exp mon" + Exp_Month + "::" + "Atc_month" + Act_mon);

		while (!Exp_Month.equalsIgnoreCase(Act_mon)) {
			driver.findElement(By.className("nextMonth")).click();
			Act_mon = driver.findElement(By.className("ui-datepicker-month")).getText();
			System.out.println(Act_mon);
		}
		System.out.println("month match,going for date/day");
		// find table
		WebElement table1 = driver.findElement(By.className("calendar"));
		// find rows
		List<WebElement> rows, cols;
		rows = table1.findElements(By.tagName("tr"));
		// find columns
		boolean found = false;
		for (int i = 1; i < rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) {
				System.out.println(cols.get(j).getText());
				if (Exp_day1.equals(cols.get(j).getText())) {
					cols.get(j).click();
					found = true;
					break;
				}
			}
			if (found) {
				break;
			}
		}

	}

	public static void main(String[] args) {
		cleartrip_calendar();
	}
}
