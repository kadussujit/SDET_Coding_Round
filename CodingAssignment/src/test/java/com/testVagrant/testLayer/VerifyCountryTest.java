/**
 * 
 */
package com.testVagrant.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testVagrant.testBase.TestBase;

/**
 * @author SUJIT
 *
 */
public class VerifyCountryTest extends TestBase {

	@Test
	public void compareCountry() {
		wikiPage.clickOnWikipediaResult();
		String country_wiki = wikiPage.getCountry();
		driver.navigate().back();
		imdbPage.clickOnIMDbResult();
		String country_imdb = imdbPage.getCountryName();
		Assert.assertEquals(country_wiki, country_imdb);
	}

}
