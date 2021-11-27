package pages;

import controls.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends Page{

    private TextBox shirtQuantityTextBox() {
        return new TextBox(driver, By.id("input[name='quantity_1_1_0_0_hidden']"));
    }
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage assertShirtQuantityIsChanged(String quantity) {
        shirtQuantityTextBox().fill(quantity);
        return this;
    }
}
