package com.qa.ATassessment;

import static junit.framework.TestCase.assertEquals;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class JenkinRunnerSteps {

	
	FileOutputStream fileOut = null;
	XSSFWorkbook workbook = null;
	int i=0;
	
	WebDriver driver;
    private static ExtentReports  reports = new ExtentReports(Constants.report, true);
    public ExtentTest test;

    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown()
    {
        driver.quit();
        reports.endTest(test);
        reports.flush();
    }
	

    
    @Given("^that you are on the create UserScreen$")
    public void that_you_are_on_the_create_UserScreen(){
       
    	//Access Jenkin URL
        driver.get(Constants.mainUrl);
        test = reports.startTest("Jenkin User Admin Test Report");
        test.log(LogStatus.INFO, "Browser Started");

        if(driver.getCurrentUrl().equals(Constants.mainUrl))
        {
            test.log(LogStatus.PASS, "Webpage accessed correctly");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed!");
        }

        assertEquals(driver.getCurrentUrl(), Constants.mainUrl);
        
        // Admin Login
        
        LoginPage loginpg = PageFactory.initElements(driver, LoginPage.class);
        loginpg.loginclick();

        assertEquals(driver.getCurrentUrl(), Constants.dashBoardUrl);
        test.log(LogStatus.INFO, "Jenkin login page accessed correctly");
        test.log(LogStatus.PASS, "Successfully Entered to the main Dashboard");
        
      
        User userpg = PageFactory.initElements(driver, User.class);
        
        userpg.manageJenkinLinkClick();
        assertEquals(driver.getCurrentUrl(), Constants.manageJenkin);
        test.log(LogStatus.INFO, "manage Jenkin link accessed correctly");
        test.log(LogStatus.PASS, "Successfully Entered to the Manage Jenkin Dashboard");
        
        
        userpg.manageUserLinkClick();
        assertEquals(driver.getCurrentUrl(), Constants.manageUser);
        test.log(LogStatus.INFO, "manage User link accessed correctly");
        test.log(LogStatus.PASS, "Successfully Entered to the Manage user Dashboard");
        
     
   
        userpg.createUserLinkClick();
        assertEquals(driver.getCurrentUrl(), Constants.createUser);
        test.log(LogStatus.INFO, "manage Create User link accessed correctly");
        test.log(LogStatus.PASS, "Successfully Entered to the Create user Dashboard");
        
     
    }

    @When("^the User details are entered on the Create UserScreen$")
    public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
       

        User userpg = PageFactory.initElements(driver, User.class);
        userpg.addDetails();
        
        test.log(LogStatus.INFO, "Entered to the create user screen");
        test.log(LogStatus.PASS, " User Successfully details Entered");
    
    }

    @When("^the details are submitted on the Create UserScreen$")
    public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
    	User userpg = PageFactory.initElements(driver, User.class);
        userpg.submit();
        test.log(LogStatus.INFO, "Entered to the create user Submision screen");
        test.log(LogStatus.PASS, " User details submitted Successfully");
       
       
    }

    @Then("^the Username should be visible on the UsersScreen$")
    public void the_Username_should_be_visible_on_the_UsersScreen() {
    	
    	ExcelUtils.setExcelFile();
		test.log(LogStatus.INFO, "Workbook Opened and sheet selected");
		
    	
    	driver.get(Constants.peoplePage);
    	test.log(LogStatus.INFO, " Record Table Opened");
    	
    	for (int i = 1 ; i < 5 ; i++) {    	
    	WebElement checkElement = driver.findElement(By.id("people"));
    	if (checkElement.getText().equals("matthewhunt")) {
			test.log(LogStatus.PASS, "The add user and login passed");
			ExcelUtils.setCellData("Pass", i, 2);
		
		} else {
			test.log(LogStatus.FAIL, "There is no record");
			ExcelUtils.setCellData("Fail", i, 2);
		}
    	}
    }

    @When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
    public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
    public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
    public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
    public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
    public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
    public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^the configure button has been clicked on the profile page$")
    public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I change the old email address on the Configure Page to a new email address \"([^\"]*)\"$")
    public void i_change_the_old_email_address_on_the_Configure_Page_to_a_new_email_address(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I save the changes to the Configure Page$")
    public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the Configure Page should show the new email address \"([^\"]*)\"$")
    public void the_Configure_Page_should_show_the_new_email_address(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    
    
    
}
