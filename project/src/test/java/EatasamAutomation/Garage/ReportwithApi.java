package EatasamAutomation.Garage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

public class ReportwithApi {
    public AndroidDriver driver;
    public BrowserMobProxy proxy;
    public Locators locators;

    ExtentReports extent;
    ExtentTest LandingScreen;

    // Generate a formatted timestamp for filenames and report
    String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    @BeforeTest
    public void config() throws Exception {
        // Setup Extent Reporting
        String path = System.getProperty("user.dir") + "//report//LandingScreen_" + timestamp + ".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Landing Screen Test Report - " + formattedDate);

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Eatasam Ahmed Siddiqui");
        extent.setSystemInfo("Test Date", formattedDate);

        // Start BrowserMob Proxy
        proxy = new BrowserMobProxyServer();
        proxy.start(0);  // Start proxy on any available port

        // Get the proxy details
        String hostIp = Inet4Address.getLocalHost().getHostAddress();
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
        seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());

        // Add proxy to DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        // Set appium options and start AndroidDriver with proxy
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setDeviceName("Pixel");
        options.setApp("C://Users//eatas//eclipse-workspace//Garage_CustomerApp//src//test//java//resources//app-staging_azure_new.apk");
        options.setCapability("appWaitForLaunch", "false");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // Capture HAR for the entire test
        proxy.newHar("landingScreen");
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

            // Capture HAR for the API interaction
            proxy.newHar("landingScreen");

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
            
            
            
            startTime = System.currentTimeMillis();

            LandingSc.info("Navigating to search bar");
            WebElement el4 = driver.findElement(AppiumBy.id("karage.sa.customer:id/searchBar"));
            el4.click();
            Thread.sleep(10000);
            endTime = System.currentTimeMillis();
            LandingSc.info("Time taken: " + (endTime - startTime) + "ms");
            
            
            // Capture and log API response
            String apiSearchEndpoint = "https://mykarageuat.azurewebsites.net/api/Setting/locationsSearch";
            LandingSc.info("Searching for location 'zzzzz'");
            WebElement searchInput = driver.findElement(AppiumBy.id("karage.sa.customer:id/search_src_text"));
            searchInput.sendKeys("zzzzzzzzz");
            Thread.sleep(5000);

            // Capture HAR log and look for the API request
         // Log all API calls and responses
            Har har = proxy.getHar();
            for (HarEntry entry : har.getLog().getEntries()) {
                String apiRequest = entry.getRequest().getUrl();
                int statusCode = entry.getResponse().getStatus();
                String responseBody = entry.getResponse().getContent().getText();

                // Log the API request and response in the Extent Report
                LandingSc.info("API Request: " + apiRequest);
                LandingSc.info("API Status: " + statusCode);
                LandingSc.info("API Response: " + responseBody);
            }
            // Continue with other steps after logging the API response
            LandingSc.info("Clicking the first location");
            WebElement el7 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"));
            el7.click();
            Thread.sleep(10000);

            // Log success in the ExtentReport
            LandingSc.pass("Landing screen interaction successful.");

        } catch (NoSuchElementException e) {
            // Capture screenshot on failure and log in ExtentReport
            String screenshotPath = captureScreenshot("LandingScreen_Failure");
            LandingSc.fail("Element not found: " + e.getMessage())
                    .addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            // Capture screenshot on general exception and log in ExtentReport
            String screenshotPath = captureScreenshot("LandingScreen_Exception");
            LandingSc.fail("Test encountered an exception: " + e.getMessage())
                    .addScreenCaptureFromPath(screenshotPath);

            throw new AssertionError("Test encountered an exception: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
        if (driver != null) {
            driver.quit();
        }
        if (proxy != null) {
            proxy.stop();
        }
    }
}
