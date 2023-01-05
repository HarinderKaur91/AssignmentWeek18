package com.naveenautomation.Tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.LaptopsAndNotebooksPage;
import com.naveenautomation.Pages.MyAccountPage;

public class LaptopsAndNotebooksTest extends TestBase {

	HomePage homePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	SoftAssert softAssert;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		homePage = new HomePage();
		softAssert = new SoftAssert();
		accountLoginPage = new AccountLoginPage();
		myAccountPage = new MyAccountPage();
		homePage.clickLoginLink();
		accountLoginPage.login("harinder21@gmail.com", "Password1");

	}

	@Test
	public void validateSuccesBannerAfterAddingProductsToWishlist() {

		myAccountPage.hoverOnLaptopAndNotebooks();
		LaptopsAndNotebooksPage laptopsAndNotebooksPage = myAccountPage.clickShowAllLaptops();
		
		laptopsAndNotebooksPage.selectSortingMethodFromDropDown();
		laptopsAndNotebooksPage.addToWishlistFirstLaptop();
		laptopsAndNotebooksPage.addToWishlistSecondLaptop();
		laptopsAndNotebooksPage.addToWishlistThirdLaptop();
		
		System.out.println(laptopsAndNotebooksPage.getTextFromSuccesBanner());
		softAssert.assertEquals(laptopsAndNotebooksPage.getTextFromSuccesBanner(),
				"Success: You have added "+laptopsAndNotebooksPage.getProductNameInSuccessBanner()+ " to your "+laptopsAndNotebooksPage.getWishListInSuccessBanner()+"!\n×", "Text on success banner doesn't match");

		softAssert.assertEquals(laptopsAndNotebooksPage.getLaptopsAndNotebooksHeadingText(), "Laptops & Notebooks",
				"Text doesn't match");
		softAssert.assertEquals(driver.getTitle(), "Laptops & Notebooks", "Title doesn't match");
		laptopsAndNotebooksPage.clickWishlistLink();
		softAssert.assertAll();
		

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
