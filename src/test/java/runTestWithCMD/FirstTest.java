package runTestWithCMD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
    
    static String browser = "chrome";  // Browser type
    static WebDriver driver;
    
    @Test
    public static void loginTest() {
        // Switch case to select browser for the test
        switch(browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().clearResolutionCache();
                WebDriverManager.chromedriver().setup();
                
                // Set Chrome options for headless mode
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");  // Enable headless mode
                chromeOptions.addArguments("--disable-gpu");  // Disable GPU hardware acceleration
                driver = new ChromeDriver(chromeOptions);  // Launch Chrome with the specified options
                break;
                
            case "firefox":
                WebDriverManager.firefoxdriver().clearResolutionCache();
                WebDriverManager.firefoxdriver().setup();
                
                // Set Firefox options for headless mode
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");  // Enable headless mode using addArguments
                driver = new FirefoxDriver(firefoxOptions);  // Launch Firefox with the specified options
                break;
                
            case "edge":
                WebDriverManager.edgedriver().clearResolutionCache();
                WebDriverManager.edgedriver().setup();
                
                // Set Edge options for headless mode
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");  // Enable headless mode
                driver = new EdgeDriver(edgeOptions);  // Launch Edge with the specified options
                break;
        }
        
        // Navigate to the website and perform login
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        
        // Find the login button and click
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        // Enter email address in the username field
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("machotechnology88@gmail.com");
        // Enter password in the password field
        driver.findElement(By.name("password")).sendKeys("abc123");
        // Click the login button
        driver.findElement(By.cssSelector("button[class='btn btn-default'][data-qa='login-button']")).click();
        
        // Print page title and current URL after login
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());  // Prints the current URL
        
        // Navigate back to the previous page
        driver.navigate().back();
        System.out.println("Page Title: " + driver.getTitle());  // Prints page title after navigating back
        
        // Close the browser
        driver.close();
        
        /* Uncomment the following lines to run Maven commands for testing manually:
        
        C:\Users\DUNCAN>cd C:\Users\DUNCAN\workspace-clean\runTestWithCMD
        C:\Users\DUNCAN\workspace-clean\runTestWithCMD>mvn clean install
        
        */
    }
}
