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
public class VerifyReleaseDateTest extends TestBase {

	@Test
	public void compareReleaseDate() {
		wikiPage.clickOnWikipediaResult();
		String relDate_wiki = wikiPage.getReleaseDate();
		driver.navigate().back();
		imdbPage.clickOnIMDbResult();
		String relDate_imdb = imdbPage.getReleaseDate();
		Assert.assertEquals(relDate_wiki, relDate_imdb);
	}

}
