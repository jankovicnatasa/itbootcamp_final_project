package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    private WebElement loginButtonMenu;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]")
    private WebElement signUpButtonMenu;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]")
    private WebElement adminButtonMenu;

    @FindBy(className = "btnAdminCities")
    private WebElement citiesButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button")
    private WebElement languageButtonMenu;

    @FindBy(id = "list-item-75")
    private WebElement languageES;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement languageMessage;

    @FindBy(id = "list-item-73")
    private WebElement languageEN;

    @FindBy(id = "list-item-77")
    private WebElement languageFR;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLoginButtonMenu() {
        return loginButtonMenu;
    }

    public void openLoginPage() {
        loginButtonMenu.click();
    }

    public WebElement getSignUpButtonMenu() {
        return signUpButtonMenu;
    }

    public WebElement getAdminButtonMenu() {
        return adminButtonMenu;
    }

    public WebElement getCitiesButton() {
        return citiesButton;
    }

    public WebElement getLanguageButtonMenu() {
        return languageButtonMenu;
    }

    public WebElement getLanguageES() {
        return languageES;
    }

    public void openSignupPage() {
        signUpButtonMenu.click();
    }

    public WebElement getLanguageMessage() {
        return languageMessage;
    }

    public WebElement getLanguageEN() {
        return languageEN;
    }

    public WebElement getLanguageFR() {
        return languageFR;
    }
}
