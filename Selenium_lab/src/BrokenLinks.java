import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinks {

	static String url = "http://primusbank.qedgetech.com/sitemap1.html";
	static HttpURLConnection huc = null;
	static String urls = null;

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println();
		Iterator<WebElement> link = links.iterator();

		while (link.hasNext()) {
			urls = link.next().getAttribute("href"); //
			System.out.println(urls);
			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if (!url.startsWith(url)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			huc = (HttpURLConnection) (new URL(urls).openConnection());
			huc.connect();
			int response_Code = huc.getResponseCode();
			if (response_Code == 200) {
				System.out.println(urls + "Connected");
			} else {
				System.out.println("Link Broken" + urls);
			}

		}
		huc = (HttpURLConnection) (new URL(url).openConnection());
		huc.connect();
		int response_Code = huc.getResponseCode();
		if (response_Code == 200) {
			System.out.println(url + "Connected");
		} else {
			System.out.println("Link Broken" + url);
		}
	}

}
