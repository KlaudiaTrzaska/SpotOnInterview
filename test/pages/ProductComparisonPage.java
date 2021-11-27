package pages;

import controls.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductComparisonPage extends Page {

    private Text productComparisonHeader() {
        return new Text(driver, By.id("products-comparison"));
    }

    public ProductComparisonPage(WebDriver driver) {
        super(driver);
    }

    public ProductComparisonPage assertProductComparisonPageIsOpened(String header) {
        productComparisonHeader().assertContains(header);
        return this;
    }


}
