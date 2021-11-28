package pages;

import controls.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends Page {
    private String url = "http://automationpractice.com/index.php?controller=contact";

    private UIElement validation() {
        return new UIElement(driver, new By.ByCssSelector("p.form-group"));
    }

    private TextBox emailInput() {
        return new TextBox(driver, By.id("email"));
    }

    private TextBox orderReferenceInput() {
        return new TextBox(driver, By.id("id_order"));
    }

    private Button sendButton() {
        return new Button(driver, By.id("submitMessage"));
    }

    private TextBox messageTextBox() {
        return new TextBox(driver, By.id("message"));
    }

    // this is a dummy button to force validation checks on current input field
    private Button unselectButton() {
        return new Button(driver, By.className("page-heading"));
    }

    private UIElement contactUsHeader() {
        return new UIElement(driver, By.className("page-heading"));
    }

    private UIElement successMessage() {
        return new UIElement(driver, By.className("alert-success"));
    }

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage open() {
        driver.get(url);
        return this;
    }

    public ContactUsPage assertContactUsPageIsOpened(String header) {
        contactUsHeader().assertContains(header);
        return this;
    }

    public ContactUsPage selectCustomerService() {
        new Select(driver.findElement(new By.ByCssSelector("select[name=id_contact]")))
                .selectByIndex(1);
        return this;
    }

    public ContactUsPage clearAndInputEmail(String input) {
        emailInput().clear();
        emailInput().fill(input);
        return this;
    }

    public ContactUsPage clearAndInputMessage(String input) {
        messageTextBox().clear();
        messageTextBox().fill(input);
        return this;
    }

    public ContactUsPage sendForm() {
        sendButton().click();
        return this;
    }

    public ContactUsPage unselectFields() {
        unselectButton().click();
        return this;
    }

    public ContactUsPage assertEmailValidationOk() {
        validation().assertHasCSSClass("form-ok");
        return this;
    }

    public ContactUsPage assertEmailValidationError() {
        validation().assertHasCSSClass("form-error");
        return this;
    }

    public void assertSuccess() {
        successMessage().assertContains("Your message has been successfully sent to our team.");
    }
}
