package pages;

import controls.Text;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsErrors extends Page {

    private Text errorField() {
        return new Text(driver, By.className("alert-danger"));
    }

    private Text errorNumber() {
        return new Text(driver, new By.ByCssSelector("div.alert-danger > p"));
    }

    public ContactUsErrors(WebDriver driver) {
        super(driver);
    }

    public ContactUsErrors assertErrorNumber(int number) {
        errorNumber().assertContains(String.valueOf(number));
        return this;
    }

    public ContactUsErrors assertInvalidEmail () {
        errorField().assertContains("Invalid email address.");
        return this;
    }

    public ContactUsErrors assertMessageBlank () {
        errorField().assertContains("The message cannot be blank.");
        return this;
    }
    public ContactUsErrors assertSubjectNotProvided () {
        errorField().assertContains("Please select a subject from the list provided.");
        return this;
    }

}
