package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
    @FindBy(id = "name")
    private WebElement inputNameField;
    @FindBy(id = "phone")
    private WebElement inputPhoneField;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[3]/span/div/div/div[1]/div[2]/div/button")
    private WebElement deletePhone;
    @FindBy(id = "city")
    private WebElement inputCityField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button")
    private WebElement deleteCity;

    @FindBy(id = "country")
    private WebElement inputCountryField;

    @FindBy(id = "urlTwitter")
    private WebElement inputTwitterField;

    @FindBy(id = "urlGitHub")
    private WebElement inputGitHubField;

    @FindBy(className = "btnSave")
    private WebElement btnSave;

    @FindBy(css = "#app > div.v-application--wrap > main > div > div.container.container--fluid > div > div > div:nth-child(4) > div > div > div > div > div.v-snack__content")
    private WebElement message;

    @FindBy(css = "#app > div.v-application--wrap > main > div > div.container.container--fluid > div > div > div:nth-child(4) > div > div > div > div > div.v-snack__content > button > span")
    private WebElement closeMessage;

    public ProfilePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void clearFields() {
        inputNameField.click();
        inputNameField.sendKeys(Keys.CONTROL + "a");
        inputNameField.sendKeys(Keys.DELETE);

        deletePhone.click();

        deleteCity.click();

        inputCountryField.sendKeys(Keys.CONTROL + "a");
        inputCountryField.sendKeys(Keys.DELETE);
        inputTwitterField.sendKeys(Keys.CONTROL + "a");
        inputTwitterField.sendKeys(Keys.DELETE);
        inputGitHubField.sendKeys(Keys.CONTROL + "a");
        inputGitHubField.sendKeys(Keys.DELETE);
    }

    public WebElement getMessageElement() {
        return message;
    }

    public String getMessage() {
        return message.getText();
    }

    public String getName() {
        return inputNameField.getAttribute("value");
    }

    public String getPhone() {
        return inputPhoneField.getAttribute("value");
    }

    public String getCity() {
        return inputCityField.getAttribute("value");
    }

    public String getCountry() {
        return inputCountryField.getAttribute("value");
    }

    public String getTwitter() {
        return inputTwitterField.getAttribute("value");
    }

    public String getGitHub() {
        return inputGitHubField.getAttribute("value");
    }

    public void pickCity(String city) {
        inputCityField.click();
        inputCityField.sendKeys(Keys.ENTER, city, Keys.ENTER);
    }

    public void editProfile(String name, String phone, String city, String country, String twitter, String gitHub) {
        clearFields();
        inputNameField.sendKeys(name);
        inputPhoneField.sendKeys(phone);
        pickCity(city);
        inputCountryField.sendKeys(country);
        inputTwitterField.sendKeys(twitter);
        inputGitHubField.sendKeys(gitHub);
        btnSave.click();
    }

    public void closeMessage() {
        closeMessage.click();
    }
}
