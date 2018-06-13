package com.weborder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {
		
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dmitr_000\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
		System.out.println(Math.random() * 100);
		int randomNum = (int)(Math.random() * 100);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(String.valueOf(randomNum));
		
		String[] middleNames = {"Peter", "David", "Smith", "Tomas", "Jonson"};
		String middleName = middleNames[(int)(Math.random() * 4)];
		String name = "John " + middleName + " Smith";
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(name);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
		
		int zipCode = (int) (Math.random() * 100000 - 1);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(String.valueOf(zipCode));
		
//ctl00_MainContent_fmwOrder_cardList_0
		
		int randomCard = (int)(Math.random() * 3);
		
		switch(randomCard) {
		case 0: driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click(); break;
		case 1: driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click(); break;
		case 2: driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click(); break;
		}
		
		String cardNum = ""; 
		for (int i = 0; i < 3; i++) {
			cardNum += String.valueOf((int) (Math.random() * 100000 - 1));
		}
		
		switch(randomCard) {
		case 0: cardNum = "4" + cardNum; break;
		case 1: cardNum = "5" + cardNum; break;
		case 2: cardNum = "3" + cardNum.substring(1); break;
		}
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNum);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("11/22");
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
		String expected = "New order has been successfully added";
		String result = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText();
		
		System.out.println(result);
		
		if (result.contains(expected)) {
		//if (driver.getPageSource().toString().contains("New order has been successfully added")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
		//New order has been successfully added

		
	
	
	}
	
	
}
