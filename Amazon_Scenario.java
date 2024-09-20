package scenarios;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_Scenario {
	
	public static void verification(boolean status, String TCname) {
		if (status) {
			System.out.println(TCname+" - TC passed");
		} else {
			System.out.println(TCname+" - TC failed");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		verification(driver.getCurrentUrl().equals("\"https://www.amazon.in/\""), "Amazon Home Page");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		String windowhandle=driver.getWindowHandle();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		Thread.sleep(3000);
		String s=driver.findElement(By.id("nav-cart-count")).getText();
		Thread.sleep(3000);
		System.out.println(s);
		int i=Integer.parseInt(s);
		verification(i!=0, "Item added to cart");
		driver.findElement(By.id("nav-cart-count")).click();
		Thread.sleep(3000);
		verification(driver.getCurrentUrl().equals("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart"), "Cart Page");
		driver.navigate().back();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 15')]")).click();
		Thread.sleep(3000);
		String window2=driver.getWindowHandle();
		Thread.sleep(3000);
		Set<String> hand_les=driver.getWindowHandles();
		for (String string : hand_les) {
			System.out.println(string);
		}
		Thread.sleep(3000);
		driver.switchTo().window(windowhandle);
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		Thread.sleep(3000);
		driver.switchTo().window(window2);
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(windowhandle);
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
