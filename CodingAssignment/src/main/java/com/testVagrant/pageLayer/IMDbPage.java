/**
 * 
 */
package com.testVagrant.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testVagrant.testBase.TestBase;

/**
 * @author SUJIT
 *
 */
public class IMDbPage extends TestBase {

	public IMDbPage() {
		PageFactory.initElements(driver, this);
	}

	// select IMDB result
	@FindBy(partialLinkText = "Pushpa: The Rise - Part 1 (2021) - IMDb")
	private WebElement IMDb_result;

	public void clickOnIMDbResult() {
		IMDb_result.click();
	}

	// extract country
	@FindBy(xpath = "//li//span[contains(text(),'Country of origin')]//parent::li//div//ul//li//a")
	private WebElement country_imdb;

	public String getCountryName() {
		return country_imdb.getText();
	}

	// choose correct country for release date
	@FindBy(xpath = "//a[contains(text(),'January 7, 2022 (United States)')]")
	private WebElement release_date_details;

	// extract Release Date
	@FindBy(xpath = "//tbody[1]/tr[6]/td[2]")
	private WebElement release_date_imdb;

	public String getReleaseDate() {
		release_date_details.click();
		return release_date_imdb.getText();
	}

}
