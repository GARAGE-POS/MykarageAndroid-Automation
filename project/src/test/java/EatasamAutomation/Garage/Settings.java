package EatasamAutomation.Garage;

import io.appium.java_client.AppiumBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.util.Assert;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;



public class Settings {
	
	
	 	
	 public AndroidDriver driver;
	    public Locators locators; // Use the Locators class if applicable
	    
	    ExtentReports extent;
	    ExtentTest Setting;

	    // Generate a formatted timestamp for filenames and report
	    String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	    String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

	    @BeforeTest
	    public void config() {
	        // Append formatted timestamp to make report file unique and more readable
	        String path = System.getProperty("user.dir") + "//report//Setting_" + timestamp + ".html";
	        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	        reporter.config().setReportName("Setting Screen Test Report - " + formattedDate);  // Add date to report name

	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	        extent.setSystemInfo("Tester", "Eatasam Ahmed Siddiqui");
	        extent.setSystemInfo("Test Date", formattedDate);  // Include date in report details
	    }

	    // Method to capture screenshots with formatted timestamp
	    public String captureScreenshot(String testName) {
	        String screenshotPath = System.getProperty("user.dir") + "//screenshots//Setting_" + testName + "_" + timestamp + ".png";
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "//screenshots//"));
	            Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return screenshotPath;
	    }

	    @Test
	    public void Setting() throws MalformedURLException, InterruptedException {
	        // Initialize the driver
	        ExtentTest Setting = extent.createTest("Setting Screen");

	        try {
	            UiAutomator2Options options = new UiAutomator2Options();
	            options.setDeviceName("Pixel");
	            options.setApp("C://Users//eatas//eclipse-workspace//Garage_CustomerApp//src//test//java//resources//app-staging_azure_new.apk");
	            options.setCapability("appWaitForLaunch", "false");
	            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

	            Thread.sleep(10000);

	            // Perform interactions
	            
	            Setting.info("Adding Phone Number");

	            WebElement el1 = driver.findElement(AppiumBy.id("karage.sa.customer:id/edtPhoneNo"));
	            el1.click();
	            el1.sendKeys("123456789");
	            Thread.sleep(10000);
	            
	            
	            Setting.info("Clicking on continue for navigating to OTP screen");

	            WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Continue\")"));
	            el2.click();

	            Thread.sleep(20000);
	            
	            
	            Setting.info("Adding OTP");

	            WebElement el3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")"));
	            el3.sendKeys("123111");

	            Thread.sleep(10000);

	            Setting.info("Clicking on Login Button");

	            WebElement elcont = driver.findElement(AppiumBy.id("karage.sa.customer:id/login"));
	            elcont.click();
	            Thread.sleep(20000);

	           WebElement elnoti = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
	            elnoti.click();

	           Thread.sleep(5000);
	            
	            
	            
	            Setting.info("Navigating to More");
	            
	            WebElement el4 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("More")));

	            el4.click();
	            Thread.sleep(1000);
	            
	            Setting.info("Editing User details");

	            WebElement el5 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.view.ViewGroup"));
	            el5.click();
	            Thread.sleep(1000);

	            Setting.info("Editing full name");

	            WebElement el6 = driver.findElement(AppiumBy.id("karage.sa.customer:id/edtFullName"));
	            el6.sendKeys("123");
	            Thread.sleep(1000);

	            Setting.info("Editing email");

	            WebElement el7 = driver.findElement(AppiumBy.id("karage.sa.customer:id/edtEmail"));
	            el7.sendKeys("e@gmail.com");
	            Thread.sleep(1000);

	            Setting.info("Editing gender");

	            WebElement el8 = driver.findElement(AppiumBy.id("karage.sa.customer:id/edtGender"));
	            el8.click();
	            Thread.sleep(1000);

	            WebElement el9 = driver.findElement(AppiumBy.id("karage.sa.customer:id/edtGender"));
	            el9.click();
	            Thread.sleep(1000);

	            Setting.info("Saving profile details");

	            WebElement el10 = driver.findElement(AppiumBy.id("karage.sa.customer:id/btnPost"));
	            el10.click();
	            
	            Thread.sleep(1000);
	            
	            
	            WebElement el11 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Profile\"]/android.view.ViewGroup/android.widget.ImageButton"));
	            el11.click();
	            Thread.sleep(500);

	            
	            
	            
	            
	            
	            WebElement el28 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup"));
	            el28.click();
	            Thread.sleep(500);
	            
	            WebElement el29 = driver.findElement(AppiumBy.id("karage.sa.customer:id/tvTitle"));
	            el29.click();
	            Thread.sleep(500);
	            
	            
	            

	            WebElement el30 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\\\"Language\\\"]/android.view.ViewGroup/android.widget.ImageButton"));
	            el30.click();
	            Thread.sleep(500);
	            

	            WebElement el31 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\\\"Settings\\\"]/android.view.ViewGroup/android.widget.ImageButton"));
	            el31.click();
	            Thread.sleep(500);
	            

	            WebElement el32 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[5]/android.view.ViewGroup"));
	            el32.click();
	            Thread.sleep(500);
	            

	            WebElement el33 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\\\"Help\\\"]/android.view.ViewGroup/android.widget.ImageButton"));
	            el33.click();
	            Thread.sleep(500);
	            

	            WebElement el34 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[8]/android.view.ViewGroup"));
	            el34.click();
	            Thread.sleep(500);
	            

	            WebElement el35 = driver.findElement(AppiumBy.id("karage.sa.customer:id/btnPostiveButton"));
	            el35.click();
	            Thread.sleep(500);
	            
	            
	            
	            
	            
	            
	            
	            WebElement el12 = driver.findElement(AppiumBy.id("karage.sa.customer:id/tvTitle"));
	            el12.click();
	            Thread.sleep(500);

	            
	            WebElement el13 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Language\"]/android.view.ViewGroup/android.widget.ImageButton"));
	            el13.click();
	            Thread.sleep(500);

	            
	            
	            WebElement el14 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.view.ViewGroup/android.widget.ImageButton"));
	            el14.click();
	            Thread.sleep(500);

	            
	            
	            WebElement el15 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[5]/android.view.ViewGroup"));
	            el15.click();
	            Thread.sleep(500);

	            
	            WebElement el16 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup"));
	            el16.click();
	            Thread.sleep(500);

	            
	            
	            WebElement el17 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Stores\"]/android.view.ViewGroup/android.widget.ImageButton"));
	            el17.click();
	            Thread.sleep(500);

	            
	            
	            WebElement el18 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup"));
	            el18.click();
	            Thread.sleep(500);

	            
	            WebElement el19 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"App and features\"]/android.view.ViewGroup/android.widget.ImageButton"));
	            el19.click();
	            Thread.sleep(500);

	            
	            
	            WebElement el20 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[3]/android.view.ViewGroup"));
	            el20.click();
	            Thread.sleep(500);

	            
	            
	            WebElement el21 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Account and data\"]/android.view.ViewGroup/android.widget.ImageButton"));
	            el21.click();
	            Thread.sleep(500);

	            
	            
	            WebElement el22 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Help\"]/android.view.ViewGroup/android.widget.ImageButton"));
	            el22.click();
	            Thread.sleep(500);

	            
	            
	            WebElement el23 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[7]/android.view.ViewGroup"));
	            el23.click();
	            Thread.sleep(500);

	            
	            WebElement el24 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup"));
	            el24.click();
	            Thread.sleep(500);

	            
	            
	            WebElement el25 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"About app\"]/android.view.ViewGroup/android.widget.ImageButton"));
	            el25.click();
	            Thread.sleep(500);

	            
	            
	            WebElement el26 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[8]/android.view.ViewGroup"));
	            el26.click();
	            Thread.sleep(500);

	            
	            
	            WebElement el27 = driver.findElement(AppiumBy.id("karage.sa.customer:id/btnPostiveButton"));
	            el27.click();
	            Thread.sleep(500);

 
	            
 
    // Log success if no exception occurs
	            Setting.pass("Setting screen interaction successful.");

	        } catch (NoSuchElementException e) {
	            // Capture screenshot on failure and log in ExtentReport
	            String screenshotPath = captureScreenshot("Setting_Failure");
	            Setting.fail("Element not found: " + e.getMessage())
	                    .addScreenCaptureFromPath(screenshotPath);  // Attach screenshot

	        } catch (Exception e) {
	            // Capture screenshot on general exception and log in ExtentReport
	            String screenshotPath = captureScreenshot("Setting_Exception");
	            Setting.fail("Test encountered an exception: " + e.getMessage())
	                    .addScreenCaptureFromPath(screenshotPath);  // Attach screenshot

	            throw new AssertionError("Test encountered an exception: " + e.getMessage());
	        }
	    }

	    @AfterTest
	    public void tearDown() {
	        extent.flush();
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}



	  
	  
	  
	  
