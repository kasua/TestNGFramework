package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.syntax.utils.BaseClass;

public class HwLocationPage extends BaseClass {
	
	@FindBy(xpath = "//li[text()='Dashboard']")
	public WebElement dashboardText;
	 
	@FindBy(partialLinkText = "PIM")
	public WebElement PIM;
	
	@FindBy(xpath = "//div[@id='menu-content']//span[text()='Admin']")
	public WebElement Admin;
	
	@FindBy(xpath = "//div[@id='menu-content']//span[text()='Organization']")
	public WebElement Organization;
	
	@FindBy(xpath = "//div[@id='menu-content']//span[text()='Locations']")
	public WebElement Locations;
	
	@FindBy(partialLinkText = "Add Employee")
	public WebElement addEmployee;
	
	@FindBy(css="//input#name]")
    public WebElement empCheck;
    

	public HwLocationPage() {
		PageFactory.initElements(driver, this);
		
		
	}
}