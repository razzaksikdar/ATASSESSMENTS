package com.qa.ATassessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
   
	@FindBy(id="j_username")
	private WebElement username;
	
    @FindBy(xpath = "//*[@id=\"main-panel\"]/div/form/table/tbody/tr[2]/td[2]/input")
    private WebElement password;
    
    public void loginclick()
    {
        username.click();
        username.sendKeys("Admin");

        password.click();
        password.sendKeys("London01");
        password.submit();
    }
	
}
