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
import java.util.Random;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class AddCar {


	private String generateRandomCarPlate() {
	    Random random = new Random();
	    String carPlate = "";
	   

	    // Keep trying until a valid car plate is generated
	    while (!carPlate.matches("^([ABJDRSXTEGKLZNHUV]{1,3}|((?!0*-)[0-9]{1,3}))-[0-9]{1,4}(?<!0{4})")) {
	        StringBuilder carPlateBuilder = new StringBuilder();

	        if (random.nextBoolean()) {
	            // Generate letter-dash-digits format (1 to 3 letters, followed by a dash, and 1 to 6 digits)
	            int letterCount = random.nextInt(3) + 1; // 1 to 3 letters
	            for (int i = 0; i < letterCount; i++) {
	                carPlateBuilder.append((char) (random.nextInt(26) + 'A')); // Random letters A-Z
	            }
	            carPlateBuilder.append('-');
	            // Generate 1 to 6 digits after the dash
	            int digitCount = random.nextInt(6) + 1;
	            for (int i = 0; i < digitCount; i++) {
	                carPlateBuilder.append(random.nextInt(10)); // Random digits 0-9
	            }
	        } else {
	            // Generate digit-only format (1 to 6 digits)
	            int digitCount = random.nextInt(6) + 1; // 1 to 6 digits
	            for (int i = 0; i < digitCount; i++) {
	                carPlateBuilder.append(random.nextInt(10)); // Random digits 0-9
	            }
	        }

	        carPlate = carPlateBuilder.toString();
	    }

	    return carPlate;
	}
	



    private AndroidDriver driver;
    ExtentReports extent;
    ExtentTest AddCar;

    String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    @BeforeTest
    public void config() {
        String path = System.getProperty("user.dir") + "//report//AddCar_" + timestamp + ".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Landing Screen Test Report - " + formattedDate);

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Eatasam Ahmed Siddiqui");
        extent.setSystemInfo("Test Date", formattedDate);
    }

    public String captureScreenshot(String testName) {
        String screenshotPath = System.getProperty("user.dir") + "//screenshots//" + testName + "_" + timestamp + ".png";
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
    public void Login() throws MalformedURLException, InterruptedException {
        AddCar = extent.createTest("Add Car");

        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("Pixel");
            options.setApp("C://Users//eatas//eclipse-workspace//Garage_CustomerApp//src//test//java//resources//app-staging_azure_new.apk");
            options.setCapability("appWaitForLaunch", "false");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));


            Thread.sleep(10000);

            // Perform interactions
            
            
            long startTime, endTime;

            startTime = System.currentTimeMillis();
            AddCar.info("Adding phone number.");

            WebElement el1 = driver.findElement(AppiumBy.id("karage.sa.customer:id/edtPhoneNo"));
            el1.click();
            el1.sendKeys("123456789");
            Thread.sleep(10000);
            endTime = System.currentTimeMillis();
            AddCar.info("Time taken: " + (endTime - startTime) + "ms");
            
            

            

            startTime = System.currentTimeMillis();
            AddCar.info("Clicking on Continue.");

            WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Continue\")"));
            el2.click();

            Thread.sleep(20000);
            endTime = System.currentTimeMillis();
            AddCar.info("Time taken: " + (endTime - startTime) + "ms");
            
            
            
            
            startTime = System.currentTimeMillis();
            AddCar.info("Adding OTP.");

            WebElement el3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")"));
            el3.sendKeys("123111");

            Thread.sleep(10000);
            endTime = System.currentTimeMillis();
            AddCar.info("Time taken: " + (endTime - startTime) + "ms");
            

            
            startTime = System.currentTimeMillis();
            AddCar.info("Clicking on Login Button.");

            WebElement elcont = driver.findElement(AppiumBy.id("karage.sa.customer:id/login"));
            elcont.click();
            Thread.sleep(20000);
            endTime = System.currentTimeMillis();
            AddCar.info("Time taken: " + (endTime - startTime) + "ms");
            
            
            
            startTime = System.currentTimeMillis();
            AddCar.info("Giving permisson to allow access.");

            WebElement elnoti = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
            elnoti.click();

            Thread.sleep(5000);
            endTime = System.currentTimeMillis();
            AddCar.info("Time taken: " + (endTime - startTime) + "ms");
            
            
            
            
            startTime = System.currentTimeMillis();

            AddCar.info("Navigating to 'My Cars'.");
            WebElement el4 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("My Cars")));
            el4.click();
            endTime = System.currentTimeMillis();
            AddCar.info("Time taken: " + (endTime - startTime) + "ms");
            
            
            
            startTime = System.currentTimeMillis();

            AddCar.info("Clicking to add a car.");
            WebElement el5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("karage.sa.customer:id/extended_fab")));
            el5.click();
            endTime = System.currentTimeMillis();
            AddCar.info("Time taken: " + (endTime - startTime) + "ms");
            
            // Fill out the form step by step with logs
            AddCar.info("Selecting year.");
            WebElement el16 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("karage.sa.customer:id/edtYear")));
            el16.click();

            AddCar.info("Selecting a year option.");
            WebElement el17 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")));
            el17.click();

            AddCar.info("Selecting maker.");
            WebElement el18 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("karage.sa.customer:id/edtMaker")));
            el18.click();

            AddCar.info("Selecting maker option.");
            WebElement el19 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")));
            el19.click();

            AddCar.info("Selecting model.");
            WebElement el20 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("karage.sa.customer:id/edtModel")));
            el20.click();

            AddCar.info("Selecting model option.");
            WebElement el21 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")));
            el21.click();

            AddCar.info("Entering car plate number.");
            WebElement el22 = driver.findElement(AppiumBy.id("karage.sa.customer:id/edtCarPlate"));
            el22.click();
            String randomCarPlate = generateRandomCarPlate();
            el22.sendKeys(randomCarPlate);
            Thread.sleep(1000);

            // Confirm the car plate was entered
            AddCar.info("Car Plate entered: " + randomCarPlate);

            // Refetch the car plate element to verify it's retained
           // el22 = driver.findElement(AppiumBy.id("karage.sa.customer:id/edtCarPlate"));
            //String enteredPlate = el22.getText();
            //if (!enteredPlate.equals(randomCarPlate)) {
              //  throw new AssertionError("Car Plate text is not retained!");
           // }

            // Scroll to the end of the screen to make sure all fields are visible
           AddCar.info("Scrolling to the end of the screen.");
            WebElement scrollToEnd = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"
            ));

            // Enter Nickname after scrolling
            AddCar.info("Entering nickname.");
            WebElement el23 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("karage.sa.customer:id/edtNickName")));
            el23.click();
            el23.sendKeys("t");
            
            
           // Scroll to the end of the screen to make sure all fields are visible
             //  AddCar.info("Scrolling to the end of the screen.");
               //WebElement scrollToEnd = driver.findElement(AppiumBy.androidUIAutomator(
                 // "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"
               //));

            // Enter kilometers
            AddCar.info("Entering kilometers.");
            WebElement el24 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("karage.sa.customer:id/edtKiloMeter")));
            el24 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("karage.sa.customer:id/edtKiloMeter")));
            el24.click();
            el24.sendKeys("53");

            
            startTime = System.currentTimeMillis();

            // Scroll to the 'btnPost' button (Submit)
            AddCar.info("Scrolling to the Submit button.");
            WebElement el25 = driver.findElement(AppiumBy.id("karage.sa.customer:id/btnPost"));

            // Click the 'btnPost' button (Submit)
            AddCar.info("Clicking the Submit button.");
            el25.click();

            
            Thread.sleep(5000);

            endTime = System.currentTimeMillis();
            AddCar.info("Time taken: " + (endTime - startTime) + "ms");
            
            AddCar.info("Confirming car addition.");
            WebElement el26 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("karage.sa.customer:id/btnDone")));
            el26.click();
            
            
            AddCar.pass("Car addedd successfully");

            // Validate if the car was successfully added by checking a confirmation message
            //AddCar.info("Checking for success message.");
            //WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("successMessageElementId")));  // Replace with actual element ID
            //if (successMessage.isDisplayed()) {
              //  AddCar.pass("Car added successfully and confirmation message displayed.");
            //} else {
              //  throw new AssertionError("Success message not displayed.");
            //}

        } catch (NoSuchElementException e) {
            AddCar.fail("Test failed due to missing element: " + e.getMessage());
            captureScreenshot("AddCar_NoSuchElementException");
            throw new AssertionError("Test failed: " + e.getMessage());
        } catch (Exception e) {
            AddCar.fail("Test encountered an exception: " + e.getMessage());
            captureScreenshot("AddCar_Exception");
            throw new AssertionError("Test failed due to an exception: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}
