package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.Base.TestBase;

public class LaptopsAndNotebooksPage extends TestBase {

	public LaptopsAndNotebooksPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h2")
	WebElement laptopsAndNotebboksText;

	@FindBy(css = "div.col-md-4  select.form-control")
	WebElement sortByDropDown;

	// @FindBy(css = "button[onclick*='wishlist.add('47"]
	@FindBy(css = "#content>div:nth-of-type(4)>div:first-of-type button:nth-of-type(2)")
	WebElement firstProductAddToWishlistButton;

	@FindBy(css = "#content>div:nth-of-type(4)>div:nth-of-type(2) button:nth-of-type(2)")
	WebElement secondProductAddToWishlistButton;

	@FindBy(css = "#content>div:nth-of-type(4)>div:nth-of-type(3) button:nth-of-type(2)")
	WebElement thirdproductAddToWishlistButton;

	@FindBy(css = "div.alert-success")
	WebElement successBanner;

	@FindBy(css = "div.alert-success a:first-of-type")
	WebElement produtNameInSuccessBanner;

	@FindBy(css = "div.alert-success a:last-of-type")
	WebElement wishListInSuccessBanner;

	@FindBy(css = "ul.list-inline>li:nth-of-type(3) span")
	WebElement wishListLink;

	public String getLaptopsAndNotebooksHeadingText() {
		return laptopsAndNotebboksText.getText();
	}

	public void selectSortingMethodFromDropDown() {
		Select sc = new Select(sortByDropDown);
		sc.selectByVisibleText("Rating (Highest)");
	}

	public void addToWishlistFirstLaptop() {
		firstProductAddToWishlistButton.click();
	}

	public void addToWishlistSecondLaptop() {
		secondProductAddToWishlistButton.click();
	}

	public void addToWishlistThirdLaptop() {
		thirdproductAddToWishlistButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getTextFromSuccesBanner() {
		return successBanner.getText();
	}

	public String getProductNameInSuccessBanner() {
		return produtNameInSuccessBanner.getText();
	}

	public String getWishListInSuccessBanner() {
		return wishListInSuccessBanner.getText();
	}

	public MyWishListPage clickWishlistLink() {
		wishListLink.click();
		return new MyWishListPage();
	}
}
