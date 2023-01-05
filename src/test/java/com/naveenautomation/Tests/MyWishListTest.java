package com.naveenautomation.Tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.LaptopsAndNotebooksPage;
import com.naveenautomation.Pages.MyWishListPage;
import com.naveenautomation.Pages.MyWishListPage.WishList;

public class MyWishListTest extends TestBase {
	LaptopsAndNotebooksPage laptopsAndNotebooksPage;
	SoftAssert softAssert;
	HomePage homePage;
	AccountLoginPage accountLoginPage;
	MyWishListPage myWishListPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		softAssert = new SoftAssert();
		homePage = new HomePage();
		laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
		accountLoginPage = new AccountLoginPage();
		homePage.clickLoginLink();
		accountLoginPage.login("harinder21@gmail.com", "Password1");
		myWishListPage = laptopsAndNotebooksPage.clickWishlistLink();
	}

	@Test
	public void validateTitle() {
		softAssert.assertEquals(driver.getTitle(), "My Wish List", "Title doesn't match");
		softAssert.assertAll();
	}

	@Test(priority = 1)
	public void verifyProductName() {
		WebElement nameElement1 = myWishListPage.getElementFromTheTable("MacBook Air", WishList.PRODUCTNAME);
		WebElement nameElement2 = myWishListPage.getElementFromTheTable("MacBook Pro", WishList.PRODUCTNAME);
		WebElement nameElement3 = myWishListPage.getElementFromTheTable("Sony VAIO", WishList.PRODUCTNAME);

		softAssert.assertEquals(nameElement1.getText(), "MacBook Air", "Product1 name doesn't match");
		softAssert.assertEquals(nameElement2.getText(), "MacBook Pro", "Product2 name doesn't match");
		softAssert.assertEquals(nameElement3.getText(), "Sony VAIO", "Product3 name doesn't match");
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void verifyProductPrice() {
		WebElement priceElement1 = myWishListPage.getElementFromTheTable("MacBook Air", WishList.UNITPRICE);
		WebElement priceElement2 = myWishListPage.getElementFromTheTable("MacBook Pro", WishList.UNITPRICE);
		WebElement priceElement3 = myWishListPage.getElementFromTheTable("Sony VAIO", WishList.UNITPRICE);

		softAssert.assertEquals(priceElement1.getText(), "$1,202.00", "Price for product1 doesn't match");
		softAssert.assertEquals(priceElement2.getText(), "$2,000.00", "Price for product2 doesn't match");
		softAssert.assertEquals(priceElement3.getText(), "$1,202.00", "Price for product3 doesn't match");
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void verifyModifyBannerAfterDelete() {
		
		myWishListPage.deleteLastProductInWishList();
		softAssert.assertEquals(myWishListPage.getTextFromSuccessBannerAfterDelete(),
				"Success: You have modified your wish list!\n×", "Element not deleted");
		softAssert.assertAll();
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
