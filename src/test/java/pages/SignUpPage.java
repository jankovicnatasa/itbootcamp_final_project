package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement signMeUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement errorMessage;

    @FindBy (className = "dlgVerifyAccount")
    private WebElement importantMessage;

    @FindBy (className = "btnClose")
    private WebElement closeMessageButton;

    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getImportantMessage() {
        return importantMessage;
    }

    public WebElement getCloseMessageButton() {
        return closeMessageButton;
    }

    public void signUp(String name, String email, String password, String confirmPassword) {
        this.nameField.clear();
        this.nameField.sendKeys(name);

        this.emailField.clear();
        this.emailField.sendKeys(email);

        this.passwordField.clear();
        this.passwordField.sendKeys(password);

        this.confirmPasswordField.clear();
        this.confirmPasswordField.sendKeys(confirmPassword);

        signMeUpButton.click();
    }

}
