package testbed;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Exp_date = "5/November/2020";
		String[] temp = Exp_date.split("/");

		String exp_day = temp[0];
		String exp_month = temp[1];
		String exp_year = temp[2];

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.id("DepartDate")).click();
		String act_month = driver.findElement(By.xpath("//div[1]/div/div/span[1]")).getText();
		System.out.println(act_month);
		String act_year = driver.findElement(By.xpath("//div[1]/div/div/span[2]")).getText();
		System.out.println(act_year);
		while (!exp_year.equals(act_year)) {// year
			driver.findElement(By.className("nextMonth")).click();
			act_year = driver.findElement(By.xpath("//div[1]/div/div/span[2]")).getText();
		}
		while (!exp_month.equalsIgnoreCase(act_month)) {// month

			driver.findElement(By.className("nextMonth")).click();
			 act_month = driver.findElement(By.xpath("//div[1]/div/div/span[1]")).getText();
		}

		WebElement cal = driver.findElement(By.className("calendar"));

		List<WebElement> rows, cols;
		boolean found = false;
		rows = cal.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) {
				String date = cols.get(j).getText();
				System.out.println(date);
				if (exp_day.equals(date)) {
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

}
