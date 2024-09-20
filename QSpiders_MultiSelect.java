package scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class QSpiders_MultiSelect {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://demoapps.qspiders.com/ui/dropdown/multiSelect?sublist=1");
		if (driver.getCurrentUrl().equals("https://demoapps.qspiders.com/ui/dropdown/multiSelect?sublist=1")) {
			System.out.println("TC Passed");
		} else {
			System.err.println("TC Failed");
		}
		driver.findElement(By.id("keypoint")).sendKeys("8125181923");
		WebElement gender=driver.findElement(By.id("select40"));
		WebElement country=driver.findElement(By.xpath("(//select[@id='select-multiple-native'])[1]"));
		WebElement state=driver.findElement(By.xpath("(//select[@id='select-multiple-native'])[2]"));
		WebElement city=driver.findElement(By.xpath("(//select[@id='select-multiple-native'])[3]"));
		Select s1=new Select(gender);
		s1.selectByVisibleText("Male");
		s1=new Select(country);
		s1.selectByVisibleText("India");
		s1=new Select(state);
		s1.selectByVisibleText("Chandigarh");
		s1=new Select(city);
		s1.selectByVisibleText("Chandigarh");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.cssSelector("input[value='Upi']")).click();
		driver.findElement(By.id("willing1")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.id("domain1")).click();
		driver.findElement(By.id("mode4")).click();
		driver.findElement(By.id("mode6")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.findElement(By.xpath("(//span[contains(@class,'relative bg-gray-300')])[1]")).click();
		driver.findElement(By.xpath("(//span[contains(@class,'relative bg-gray-300')])[1]")).click();
		driver.findElement(By.xpath("(//span[contains(@class,'relative bg-gray-300')])[1]")).click();
		driver.findElement(By.xpath("(//span[contains(@class,'relative bg-gray-300')])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("togglers")).click();
		Thread.sleep(3000);
		String output=driver.findElement(By.xpath("//p[contains(@class,'text-lg text-orange-600')]")).getText();
		System.out.println(output);
		Thread.sleep(3000);
		driver.close();
	}
}
