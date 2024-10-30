package EatasamAutomation.Garage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LandingScreen {
    public AndroidDriver driver;
    public Locators locators; // Use the Locators class if applicable
    
    ExtentReports extent;
    ExtentTest LandingScreen;

    // Generate a formatted timestamp for filenames and report
    String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    @BeforeTest
    public void config() {
        // Append formatted timestamp to make report file unique and more readable
        String path = System.getProperty("user.dir") + "//report//LandingScreen_" + timestamp + ".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Landing Screen Test Report - " + formattedDate);  // Add date to report name

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Eatasam Ahmed Siddiqui");
        extent.setSystemInfo("Test Date", formattedDate);  // Include date in report details
    }

    // Method to capture screenshots with formatted timestamp
    public String captureScreenshot(String testName) {
        String screenshotPath = System.getProperty("user.dir") + "//screenshots//LandingScreen_" + testName + "_" + timestamp + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "//screenshots//"));
            Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }

    @Test(groups = {"Regression"})
    public void Landing() throws MalformedURLException, InterruptedException {
        // Initialize the driver
        ExtentTest LandingSc = extent.createTest("Landing Screen");

        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("Pixel");
            options.setApp("C://Users//eatas//eclipse-workspace//Garage_CustomerApp//src//test//java//resources//app-staging_azure_new.apk");
            options.setCapability("appWaitForLaunch", "false");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

            Thread.sleep(10000);
            long startTime, endTime;

            startTime = System.currentTimeMillis();
            LandingSc.info("Adding Phone Number");
            WebElement el1 = driver.findElement(AppiumBy.id("karage.sa.customer:id/edtPhoneNo"));
            el1.click();
            el1.sendKeys("123456789");
            Thread.sleep(10000);
            endTime = System.currentTimeMillis();
            LandingSc.info("Time taken: " + (endTime - startTime) + "ms");
            
            
            startTime = System.currentTimeMillis();

            LandingSc.info("Clicking on continue for navigating to OTP screen");
            WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Continue\")"));
            el2.click();
            Thread.sleep(20000);
            endTime = System.currentTimeMillis();
            LandingSc.info("Time taken: " + (endTime - startTime) + "ms");
           
            
            
            startTime = System.currentTimeMillis();
            LandingSc.info("Adding OTP");
            WebElement el3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")"));
            el3.sendKeys("123111");
            Thread.sleep(10000);
            endTime = System.currentTimeMillis();
            LandingSc.info("Time taken: " + (endTime - startTime) + "ms");
           
            
            
            startTime = System.currentTimeMillis();

            LandingSc.info("Clicking on Login Button");

            WebElement elcont = driver.findElement(AppiumBy.id("karage.sa.customer:id/login"));
            elcont.click();
            Thread.sleep(20000);
            endTime = System.currentTimeMillis();
            LandingSc.info("Time taken: " + (endTime - startTime) + "ms");
           
            
            
            startTime = System.currentTimeMillis();

            WebElement elnoti = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
            elnoti.click();

            Thread.sleep(5000);
            endTime = System.currentTimeMillis();
            LandingSc.info("Time taken: " + (endTime - startTime) + "ms");
            
            
            
            startTime = System.currentTimeMillis();

            LandingSc.info("Navigating to search bar");
            WebElement el4 = driver.findElement(AppiumBy.id("karage.sa.customer:id/searchBar"));
            el4.click();
            Thread.sleep(10000);
            endTime = System.currentTimeMillis();
            LandingSc.info("Time taken: " + (endTime - startTime) + "ms");
            
            
            startTime = System.currentTimeMillis();

            LandingSc.info("Entering text to search bar");

            WebElement el6 = driver.findElement(AppiumBy.id("karage.sa.customer:id/search_src_text"));
            el6.sendKeys("Oil");
            Thread.sleep(5000);
            endTime = System.currentTimeMillis();
            LandingSc.info("Time taken: " + (endTime - startTime) + "ms");
            
            
            
            startTime = System.currentTimeMillis();

            LandingSc.info("Clicking the first location");

            WebElement el7 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"));
            el7.click();

            Thread.sleep(10000);
            endTime = System.currentTimeMillis();
            LandingSc.info("Time taken: " + (endTime - startTime) + "ms");
            
            
            startTime = System.currentTimeMillis();

            LandingSc.info("Checking the working hours");
            WebElement el8 = driver.findElement(AppiumBy.id("karage.sa.customer:id/layoutWorkingHour"));
            el8.click();
            Thread.sleep(1000);
            endTime = System.currentTimeMillis();
            LandingSc.info("Time taken: " + (endTime - startTime) + "ms");
            

            WebElement el9 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Working hours\"]/android.view.ViewGroup/android.widget.ImageButton"));
            el9.click();

            Thread.sleep(1000);

            // Scroll to Amenities and click
            LandingSc.info("Clicking the Amenities");

            WebElement el10 = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Amenities\"));"));
            el10.click();

            Thread.sleep(1000);

            WebElement el13 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Amenities\"]/android.view.ViewGroup/android.widget.ImageButton"));
            el13.click();

            Thread.sleep(1000);
            
            
            
            startTime = System.currentTimeMillis();

            LandingSc.info("Clicking the services");

            WebElement el11 = driver.findElement(AppiumBy.id("karage.sa.customer:id/layoutServices"));
            Thread.sleep(1000);
            el11.click();
            Thread.sleep(500);
            endTime = System.currentTimeMillis();
            LandingSc.info("Time taken: " + (endTime - startTime) + "ms");
            
            
            WebElement el00 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Services\"]/android.view.ViewGroup/android.widget.ImageButton"));
            el00.click();
            Thread.sleep(500);

            // Log success in the ExtentReport
            LandingSc.pass("Landing screen interaction successful.");

        } catch (NoSuchElementException e) {
            // Capture screenshot on failure and log in ExtentReport
            String screenshotPath = captureScreenshot("LandingScreen_Failure");
            LandingSc.fail("Element not found: " + e.getMessage())
                    .addScreenCaptureFromPath(screenshotPath);  // Attach screenshot

        } catch (Exception e) {
            // Capture screenshot on general exception and log in ExtentReport
            String screenshotPath = captureScreenshot("LandingScreen_Exception");
            LandingSc.fail("Test encountered an exception: " + e.getMessage())
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
