package pages;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends Page {

    private String url = "http://automationpractice.com/index.php";

    private TextBox searchTextBox() {
        return new TextBox(driver, By.id("search_query_top"));
    }

    private Button searchIconButton() {
        return new Button(driver, By.name("submit_search"));
    }

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public LandingPage open() {
        driver.get(url);
        return this;
    }


    public LandingPage clearAndInputItemName(String itemName) {
        searchTextBox().clear();
        searchTextBox().fill(itemName);
        return this;
    }

    public LandingPage clickOnSearchIcon() {
        searchIconButton().click();
        waitUntilLoaded();
        return this;
    }
}
