package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//RTTC 011 2nd test case//
	
	@FindBy(name="username")
	private WebElement userName; 

	@FindBy(name="password")
	private WebElement password;

	@FindBy(xpath="//button[@class='btn btn-primary']")
	//@FindBy(linkText=" Login")
	private WebElement submit; 

	@FindBy(id="menu-catalog")
	private WebElement catalog;

	@FindBy(linkText="Categories")
	private WebElement catagories;

	@FindBy(xpath="//li[@id='menu-catalog']//ul//li//a[contains(text(),'Products')]")
	private WebElement catalogproduct;

	@FindBy(id="button-filter")
	private WebElement clickFilter;

	public void sendUserName(String userName) {

		this.userName.clear();
		this.userName.sendKeys(userName);

	}

	public void sendPassword(String password) {

		this.password.clear(); 
		this.password.sendKeys(password); 

	}

		public void clickLoginBtn() {
		this.submit.click();

	}

		public void clickCatalogName() {
		this.catalog.click();

	}

		public void clickCatagories() {

		this.catagories.click();}
}
