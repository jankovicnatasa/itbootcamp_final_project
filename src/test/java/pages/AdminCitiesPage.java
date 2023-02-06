package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminCitiesPage extends BasePage{

    Faker faker = new Faker();
    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")
    private WebElement newItemButton;
    @FindBy (id = "name")
    private WebElement newItemField;
    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement savedSuccessfullyMessage;

    @FindBy(id = "edit")
    private WebElement editButton;

    @FindBy(id="name")
    private WebElement editCityNameField;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")
    private WebElement nameSearchField;

    @FindBy(id = "delete")
    private WebElement deleteButton;

    @FindBy (css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
    private WebElement deleteConfirmButton;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[2]/div/div/div/div/div[1]")
    private WebElement deleteMessage;

    public WebElement getNewItemButton() {
        return newItemButton;
    }

    public WebElement getSavedSuccessfullyMessage() {
        return savedSuccessfullyMessage;
    }

    public WebElement getNameSearchField() {
        return nameSearchField;
    }

    public WebElement getDeleteMessage() {
        return deleteMessage;
    }

    public void newCityAdd (){
        getNewItemButton().click();
        this.newItemField.sendKeys("Madrid");
        this.saveButton.click();
    }

    public void cityEdit(){
        this.editButton.click();
        editCityNameField.clear();

        this.editCityNameField.sendKeys(" - edited");

        this.saveButton.click();
    }

    public void searchCity(){
        this.searchField.click();
        this.searchField.sendKeys("Madrid");

    }
    public void deleteCity(){
        this.deleteButton.click();
        this.deleteConfirmButton.click();

    }
}
