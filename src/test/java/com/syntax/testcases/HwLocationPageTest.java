package com.syntax.testcases;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.HwLocationPage;
import com.syntax.pages.LocationPage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class HwLocationPageTest extends BaseClass {

	@Test(dataProvider = "locationData")

	public void addLocation(String nameData, String countryData, String cityData, String zipData) {

		// login
		LoginPage login = new LoginPage();

		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);

		// Admin tab
		HwLocationPage home = new HwLocationPage();

		CommonMethods.click(home.Admin);

		// Organization
		CommonMethods.click(home.Organization);

		// Location
		CommonMethods.click(home.Locations);

		// click add button
		LocationPage locations = new LocationPage();
		CommonMethods.click(locations.add);

		// fillout the addlocation form
		CommonMethods.sendText(locations.name, nameData);
		CommonMethods.click(locations.country);
		CommonMethods.waitForElementBeClickable(locations.selectCountry, 10);
		CommonMethods.selectList(locations.selectCountry, countryData);

		// CommonMethods.sendText(locations.country, countryData);
		CommonMethods.sendText(locations.city, cityData);
		CommonMethods.sendText(locations.zipCode, zipData);
		CommonMethods.click(locations.saveBtn);
		CommonMethods.takeScreenshot("06132019", nameData + "_location_data");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.toast-message"),
				"Successfully Saved"));
		List<WebElement> locationInfo = driver.findElements(By.xpath("//table/tbody/tr"));

		// verify row by row
		// draft
		// for (WebElement element : locationInfo) {
		// System.out.println(element.getText());
		// if (element.getText().contains(nameData)) {
		// System.out.println("Found added name on the table");
		// break;
		// }
		// }
		// or

		for (int i = 1; i <= locationInfo.size(); i++) {
			if (driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText().equals(nameData)) {
				System.out.println("Found added name on the table");
				break;
			}
		}
	}

	@DataProvider(name = "locationData")
	public Object[][] locationData() {
		Object[][] data = new Object[5][4];

		data[0][0] = "Liza";
		data[0][1] = "Ukraine";
		data[0][2] = "Kiev";
		data[0][3] = "20005";

		data[1][0] = "Kasu";
		data[1][1] = "Ethiopia";
		data[1][2] = "Addis";
		data[1][3] = "4561";

		data[2][0] = "Ryan";
		data[2][1] = "Korea";
		data[2][2] = "Seoul";
		data[2][3] = "15478";

		data[3][0] = "Douglas";
		data[3][1] = "Kenya";
		data[3][2] = "Nairobi";
		data[3][3] = "452315";

		data[0][0] = "Velleria";
		data[0][1] = "Ukraine";
		data[0][2] = "Kiev";
		data[0][3] = "20005";

		return data;
	}
}
