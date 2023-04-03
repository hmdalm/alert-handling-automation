package com.hammad.alert.handling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_Handling_Demo {
	private static WebDriver driver = null;

	@BeforeClass
	public static void demo_site() throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/delete_customer.php");
	}

	@Test(priority =0)
	public void capturingAlertmsg() throws Exception {
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("21212");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).submit();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String alrtTxt = driver.switchTo().alert().getText();
		System.out.println(alrtTxt.contains("really"));
		System.out.println(alrtTxt);
		Thread.sleep(5000);
		alert.accept();
	}
	@Test(priority =1)
	public void dismissAlertmsg() throws Exception {
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("52411");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).submit();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String alrtTxt = driver.switchTo().alert().getText();
		System.out.println(alrtTxt.contains("xyz"));
		System.out.println(alrtTxt);
		Thread.sleep(5000);
		alert.dismiss();
	}
@AfterClass
public void close () throws Exception {
	Thread.sleep(3000);
	driver.close();
}

}
