package Tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.MobileLoadAndBundlesPOM;
import io.appium.java_client.MobileBy;

@Test  (priority = 5)

public class PrePaidLoad extends AppSetup{
	@Parameters({"device"})

	public void PrePaidMobileLoad(String device) throws InterruptedException 
	{		


		test = extent.createTest("Prepaid Mobile Load"+ "  ("+"Device Name:"+"  " +device+") ");
		test.assignCategory("Prepaid Load TestCase");

		test.log(Status.INFO, "Execution Started");

		MobileLoadAndBundlesPOM POM=new MobileLoadAndBundlesPOM(driver);
		POM.Appdrawer.click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+ "Prepaid Load" + "\").instance(0))")).click();
		test.log(Status.PASS, "Prepaid Load is Clicked and the user is inside the Jazz Section");
		Thread.sleep(2000);

		POM.SearchMobileNO.click();
		Thread.sleep(2000);

		POM.SearchMobileNO.sendKeys("03025782949");
		Thread.sleep(3000);

		POM.SelectNO.click();
		Thread.sleep(2000);

		test.log(Status.PASS, "Mobile Number Searched and Selected from the List Sccuessfully");

		POM.Three.click();
		Thread.sleep(2000);

		
		if((driver.getPageSource().contains("Success")))
				 
				{
			test.log(Status.PASS, "Required element is present");

				}
		else
				{
			test.log(Status.FAIL, "Required element is missing");
				}
		POM.Zero.click();
		Thread.sleep(2000);

		test.log(Status.PASS, "Amount Entered to Send  Sccuessfully");

		
		POM.LoadRS.click();
		Thread.sleep(2000);
		POM.ConfirmTransaction.click();
		POM.UseMPIM.click();
		Thread.sleep(2000);

		
		//Entering MPIN
		POM.One.click();
		POM.One.click();
		POM.Two.click();
		POM.Two.click();
		test.log(Status.PASS, "MPIN Entered  Sccuessfully");
		Thread.sleep(3000);

		POM.Done.click();
		test.log(Status.PASS, "Mobile Load Successfully Purchased");
		test.log(Status.PASS, "User Landed On HomeScreen");

	}
}
