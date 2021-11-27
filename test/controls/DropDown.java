package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends UIElement{

    public DropDown(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public void expandDropDown() {
        element().click();
    }

    private Select getDropDown() {
        return new Select(element());
    }

    public void selectByIndex(int index) {
        getDropDown().selectByIndex(index);
    }
}
