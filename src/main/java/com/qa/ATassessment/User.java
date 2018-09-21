package com.qa.ATassessment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class User {

//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(id="")
//	private WebElement ;
//	
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement ManageJenkinsLink;
	
	@FindBy(xpath = "//*[@id=\"management-links\"]/tbody/tr[15]/td[2]/div[1]/a")
	private WebElement ManageUserLink;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement CreateUserLink;
	
	@FindBy(xpath="//*[@id=\"tasks\"]/div[2]/a[2]/b") 
	private WebElement peoplePageLink;
	
	//Create User page>> add user action
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullName;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement email;
	
	@FindBy(id="yui-gen3-button")
	private WebElement createUserBtn;
	
//	@FindBy(id="people")
//	private WebElement userTable;
	
	public void manageJenkinLinkClick() {
		ManageJenkinsLink.click();
	}
	
	public void manageUserLinkClick() {
		
	
		 ManageUserLink.click();
	}

	public void createUserLinkClick() {
		CreateUserLink.click();
	}
	
	public void checkPeopleLink()
	{
		peoplePageLink.click();
	}

	public void addDetails()
	{
		username.click();
		username.sendKeys("matthewhunt");
		
		password.click();
		password.sendKeys("London01");
		confirmPassword.click();
		confirmPassword.sendKeys("London01");
		
		fullName.click();
		fullName.sendKeys("Mattt");
		
		email.click();
		email.sendKeys("MadMatt@qa.com");
		
		
	}
	
	public void submit() {
		createUserBtn.click();
	}
	
//	public void findUser()
//	{
//		userTable.getText();
//		
//	}
	
}
