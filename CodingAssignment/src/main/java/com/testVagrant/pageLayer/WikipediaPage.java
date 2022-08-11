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
public class WikipediaPage extends TestBase {

	public WikipediaPage() {
		PageFactory.initElements(driver, this);
	}

	// select Wikipedia result
	@FindBy(partialLinkText = "Pushpa: The Rise - Wikipedia")
	private WebElement wikipedia_result;

	public void clickOnWikipediaResult() {
		wikipedia_result.click();
	}

	// extract release date
	@FindBy(xpath = "//tbody/tr[12]/td")
	private WebElement release_date_wiki;

	public String getReleaseDate() {
		return release_date_wiki.getText();
	}

	// extract country
	@FindBy(xpath = "//tbody/tr[14]/td")
	private WebElement country_wiki;

	public String getCountry() {
		return country_wiki.getText();
	}

}
