package operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio_operations {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com");

		List<WebElement> radios = driver.findElements(By.xpath("//*[@type='radio']"));

		System.out.println(radios.size());

		for (int i = 0; i < radios.size(); i++) {
			String radio_name = radios.get(i).getAttribute("value");
			System.out.println(radio_name);
		}

		WebElement radio_button = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));

		radio_button.click();
		System.out.println("clicking :: "+radio_button.getAttribute("value"));
		Thread.sleep(4000);
		System.out.println("Waiting");
		radio_button.click();
		System.out.println("clicking  again:: "+radio_button.getAttribute("value"));
		if (!radio_button.isSelected())
			radio_button.click();
	}

}
