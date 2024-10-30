package EatasamAutomation.Garage;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Locators {
    
    // Instance of the driver
    public RemoteWebDriver driver;

    // Constructor to initialize the driver
    public Locators(RemoteWebDriver driver) {
        this.driver = driver;
    }

    // Method to find element by ID
    public WebElement ID(String id) {
        return driver.findElement(AppiumBy.id(id));
    }

    // Method to find element by XPATH
    public WebElement XPATH(String xpath) {
        return driver.findElement(AppiumBy.xpath(xpath));
    }

    public WebElement UIAutomator(String androidUIAutomator) {
        return driver.findElement(AppiumBy.androidUIAutomator(androidUIAutomator));
    }}



