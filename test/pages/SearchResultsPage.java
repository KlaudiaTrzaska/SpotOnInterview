package pages;

import controls.Button;
import controls.UIElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends Page{

    private final String SUCCESS_MESSAGE = "Product successfully added to your shopping cart";


    private UIElement productListingHeader() {
        return new UIElement(driver, By.className("product-listing"));
    }

    private UIElement shirtName() {
        return new UIElement(driver, By.cssSelector("h5[itemprop='name']>.product-name"));
    }

    private UIElement dressName() {
        return new UIElement(driver, By.cssSelector("h5[itemprop='name']>a[title='Printed Dress']"));
    }

    private Button addToCartButton() {
        return new Button(driver, By.cssSelector("a[title='Add to cart']"));
    }

    private Button continueShoppingButton() {
        return new Button(driver, By.cssSelector("span[title='Continue shopping']"));
    }

    private Button proceedToCheckoutButton() {
        return new Button(driver, By.cssSelector("a[title='Proceed to checkout']"));
    }

    private Button addToCompareButton() {
        return new Button(driver, By.className("add_to_compare"));
    }

    private Button compareButton() {
        return new Button(driver, By.className("bt_compare"));
    }

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage clickOnAddToCartButton() {
        addToCartButton().scrollIntoView();
        addToCartButton().click();
        return this;
    }

    public SearchResultsPage assertDressName(String dressName) {
        dressName().scrollIntoView();
        dressName().assertContains(dressName);
        return this;
    }
    public SearchResultsPage assertShirtName(String shirtName) {
        shirtName().scrollIntoView();
        shirtName().assertContains(shirtName);
        return this;
    }

    public SearchResultsPage assertProductListingHeaderText(String searchString) {
        productListingHeader().assertContains(searchString);
        return this;
    }

    public SearchResultsPage assertSuccessMessageWhenProductIsAddedToTheCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = js.executeScript("return document.querySelector('.layer_cart_product > h2').textContent.trim()").toString();
        Assert.assertEquals(text, SUCCESS_MESSAGE);
        return this;
    }

    public SearchResultsPage clickOnContinueShoppingButton() {
        continueShoppingButton().click();
        return this;
    }

    public SearchResultsPage clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton().click();
        return this;
    }

    public SearchResultsPage addItemToCompare() {
        addToCompareButton().scrollIntoView();
        addToCompareButton().click();
        return this;
    }

    public SearchResultsPage clickOnCompareButton() {
        compareButton().waitUntilClickable();
        compareButton().click();
        compareButton().waitUntilNotVisible();
        return this;
    }




}
