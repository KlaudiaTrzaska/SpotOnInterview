package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Text extends UIElement{

    public String getText() {
       return element().getText();
    }

    public Text(WebDriver driver, By locator) {
        super(driver, locator);
    }


}
