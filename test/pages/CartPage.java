package pages;

import controls.Button;
import controls.TextBox;
import controls.UIElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends Page{

    private UIElement summaryText () {
        return new UIElement(driver, By.id("summary_products_quantity"));
    }
    private Button dressDeleteIcon() {
        return new Button(driver, By.cssSelector("a[id='5_19_0_0']"));
    }
    private TextBox shirtQuantityTextBox() {
        return new TextBox(driver, By.cssSelector("input[name='quantity_1_1_0_0']"));
    }
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage changeShirtQuantity(int quantity) {
        shirtQuantityTextBox().fill(String.valueOf(quantity));
        return this;
    }
    public CartPage assertProductQuantityEquals(int quantity) {

        summaryText().assertContains(String.valueOf(quantity));
        return this;
    }

    public CartPage deleteDressFromCart() {
        dressDeleteIcon().click();
        return this;
    }

    public CartPage assertPrintedSummerDressNotPresent() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("tr[id='product_5_19_0_0']"),
                "Printed Summer Dress"));
        return this;
    }
}
