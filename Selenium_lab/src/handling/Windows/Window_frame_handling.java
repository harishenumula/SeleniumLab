package handling.Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_frame_handling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.setProperty("WebDriver.Chrome.Driver", "E:\\selenium jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/");
		driver.findElement(By.linkText("Droppable")).click();
		String Parent_window_id = driver.getWindowHandle();
		System.out.println("Parent_window_id" + Parent_window_id);
		System.out.println("changing focus  to frame");

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		System.out.println("driver focus is in frame");
		System.out.println("switching to Parent Window");

		System.out.println("Current_f_id" + Parent_window_id);

		System.out.println("changing focus  to parent window");
		driver.switchTo().window(Parent_window_id);
		driver.findElement(By.linkText("Demos")).click();

	}

}
