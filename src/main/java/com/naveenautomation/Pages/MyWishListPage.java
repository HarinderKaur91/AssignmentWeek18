package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class MyWishListPage extends TestBase {
	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tbody tr:last-of-type td:last-of-type a")
	WebElement deleteButton;
	
	
	@FindBy(css = "div.alert-success")
	WebElement successBannerAfterDelete;
	

	public WebElement getElementFromTheTable(String productName, WishList column) {

		int columnIndex = getIndexForColumn(column);

		List<WebElement> rowsInTable = driver
				.findElements(By.cssSelector("table.table.table-bordered.table-hover tbody tr"));

		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));
			
			String productNameText = cells.get(1).getText();
			
			if (productNameText.equals(productName)) {
				return cells.get(columnIndex);
			}
		}

		System.out.println("Column name was not found!!!");
		return null;
	}

	public int getIndexForColumn(WishList column) {
		List<WebElement> headers = driver
				.findElements(By.cssSelector("table.table.table-bordered.table-hover thead tr td"));

		for (WebElement webElement : headers) {
			String headerText = webElement.getText();
			if (headerText.equals(column.getName())) {
				return headers.indexOf(webElement);
			}
		}
		System.out.println("Column does not exist.....");
		return -1;
	}

	public void deleteLastProductInWishList() {
		deleteButton.click();
	}
	public String getTextFromSuccessBannerAfterDelete() {
		return successBannerAfterDelete.getText();
	}

	public enum WishList {

		PRODUCTNAME("Product Name"), MODEL("Model"), STOCK("Stock"), UNITPRICE("Unit Price");

		String name;

		private WishList(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
