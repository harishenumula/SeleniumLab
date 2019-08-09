package alertpopups;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Fileupload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://html.com/input-type-file");
		driver.findElement(By.id("fileupload")).sendKeys("E:\\Test_File_upload.txt");
		
	}

}
