package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Button extends UIElement {

    public Button(WebDriver driver, By signInButtonLocator) {
        super(driver, signInButtonLocator);
    }

    public void click() {
        element().click();
    }
}
