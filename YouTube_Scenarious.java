package scenarios;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*Launch an empty browser, enter the url of youtube application (Verification & Validation)
identify searchbox enter doremon, click on search button, play a video of doremon*/

public class YouTube_Scenarious {
	public static void verification(boolean status, String TCname) {
		if (status) {
			System.out.println(TCname+" - TC passed");
		} else {
			System.out.println(TCname+" - TC failed");
		}
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		verification(driver.getCurrentUrl().equals("https://www.youtube.com/"), "YouTube HomePage");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement search=driver.findElement(By.name("search_query"));
		search.sendKeys("doremon");
		driver.findElement(By.id("search-icon-legacy")).click();
		driver.findElement(By.xpath("//a[contains(@title,'Doraemon Cartoon')]")).click();
		driver.manage().window().fullscreen();
	}

}
