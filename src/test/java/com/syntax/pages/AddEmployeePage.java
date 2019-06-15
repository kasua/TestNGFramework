package com.syntax.pages;
/*
 * US24548: Add Employee DetailsTestCase:
 *  Add Employee VerificationStep 
 *  1: Login to the OrangeHRMStep 
 *  2: Click on PIMStep 
 *  3: Click on Add EmployeeStep 
 *  4: Enter fName, lName, select LocationStep
 *  5 Click SaveStep
 *   6: Verify employee is added
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.syntax.utils.BaseClass;

public class AddEmployeePage extends BaseClass{
	
	@FindBy(id="firstName")
    public WebElement firstName;
    
    @FindBy(id="middleName")
    public WebElement middleName;
    
    @FindBy(id="lastName")
    public WebElement lastName;
    
    @FindBy(id="employeeId")
    public WebElement employeeId;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//input")
    public WebElement location;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//ul")
    public WebElement locationList;
    
    @FindBy(xpath="//input[@id='chkLogin']")
    public WebElement createLoginDetails;
    
    @FindBy(id="systemUserSaveBtn")
    public WebElement saveBtn;
    
    @FindBy(xpath="//span[@id='pim.navbar.employeeName']")
    public WebElement empCheck;
    
    public AddEmployeePage() {
        PageFactory.initElements(driver,this);
    }
}

