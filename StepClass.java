package com.automation.steps;


import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//import com.automation.tests.NoAlertPresentException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StepClass {

	public WebDriver driver;
	public void browserlaunch(String browser){
		
		if (browser.equalsIgnoreCase("chrome")) {
//		        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		        
			WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver();
		        
		    } else if (browser.equalsIgnoreCase("firefox")) {
		        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDrivers\\geckodriver.exe");
		        driver = new FirefoxDriver();
		    } else if (browser.equalsIgnoreCase("edge")) {
		        System.setProperty("webdriver.edge.driver", "C:\\SeleniumDrivers\\msedgedriver.exe");
		        driver = new EdgeDriver();
		    }
		
		 File profile = new File("C:/Temp/ChromeCleanProfile");
	        if (profile.exists()) {
	            deleteDirectory(profile); // Call helper method
	        }
	        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

	        chromePrefs.put("credentials_enable_service", false);
	        chromePrefs.put("profile.password_manager_enabled", false);
	        chromePrefs.put("autofill.profile_enabled", false);
	        
		
//		driver = new ChromeDriver(popup());
		
//		ChromeOptions options = new ChromeOptions();
//
//		Map<String, Object> prefs = new HashMap<>();
//        prefs.put("credentials_enable_service", false);
//        prefs.put("profile.password_manager_enabled", false);
//        options.setExperimentalOption("prefs", prefs);

        // Optional: disable Chrome’s save password bubble
//        options.addArguments("--disable-save-password-bubble");

        // Initialize driver with options
//        ChromeDriver driver = new ChromeDriver(options);
		
//		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	public static void deleteDirectory(File file) {
	    if (file.isDirectory()) {
	        for (File sub : file.listFiles()) {
	            deleteDirectory(sub);
	        }
	    }
	    file.delete();
	}
	
	public void urlLaunch() {
		driver.get("https://www.saucedemo.com");
	}
	
	public void login() throws InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		try {
		    Alert alert = driver.switchTo().alert();
		    alert.accept(); // or alert.dismiss();
		} catch (org.openqa.selenium.NoAlertPresentException e) {
		    System.out.println("No popup found.");
		}
		
	}
	
	public void invalidLogin() throws InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("wrong");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		
		driver.navigate().refresh();
	    implicitWait();
	}
	
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void selectFromDropdown(By locator, String visibleText) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(visibleText);
    }
	
	public void addtocart() {
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		
	}
	
	public void toValidate(String actual, String expected) {
		driver.findElement(By.className("shopping_cart_link")).click();
		Assert.assertEquals(actual, expected, "Values do not match!");
	}
	
	public void checkout() {
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Guest");
		driver.findElement(By.id("last-name")).sendKeys("User");
		driver.findElement(By.id("postal-code")).sendKeys("110045");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		driver.findElement(By.id("back-to-products")).click();
	}
	
	public void invalidCheckout(){
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("continue")).click();
	}
	
	public ChromeOptions popup(){
	    ChromeOptions options = new ChromeOptions();

	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
//
	    options.setExperimentalOption("prefs", prefs);
//
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-infobars");
	    options.addArguments("--start-maximized");
//
	    options.addArguments("user-data-dir=C:/Temp/ChromeCleanProfile"); 
	    options.addArguments("--disable-save-password-bubble");
	    options.addArguments("--disable-password-generation");

	    return options;
	}


}
