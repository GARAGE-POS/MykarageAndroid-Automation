package EatasamAutomation.Garage.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	
	AndroidDriver driver;
	public FormPage(AndroidDriver driver) {
		
		
		this.driver= driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "karage.sa.customer:id/edtPhoneNo")
	private  WebElement PhoneNum;
	
	
	
	public void SetPhoneNo(String phoneno) {
		
		PhoneNum.click();
		PhoneNum.sendKeys(phoneno);
		
		
	}

}
