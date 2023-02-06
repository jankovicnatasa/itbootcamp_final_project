package tests;

import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class AdminCitiesTests extends BaseTest {
    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.openLoginPage();
        loginPage.login("admin@admin.com", "12345");
//        homePage.getAdminButtonMenu().click();
//        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        homePage.getCitiesButton().click();
    }
    @Test
    public void visitAdminCitiesPage() {
        homePage.getAdminButtonMenu().click();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage.getCitiesButton().click();

        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("/admin/cities"));
        loginPage.getLogoutButton().isDisplayed();
    }

    @Test
    public void createNewCity() {
        homePage.getAdminButtonMenu().click();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage.getCitiesButton().click();

        adminCitiesPage.newCityAdd();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String actualMessage = adminCitiesPage.getSavedSuccessfullyMessage().getText();
        actualMessage.contains("Saved successfully");
    }

    @Test
    public void editCity() {
        homePage.getAdminButtonMenu().click();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage.getCitiesButton().click();

        adminCitiesPage.cityEdit();
        String actualMessage = adminCitiesPage.getSavedSuccessfullyMessage().getText();
        actualMessage.contains("Saved successfully");
    }

    @Test
    public void searchCity() {
        homePage.getAdminButtonMenu().click();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage.getCitiesButton().click();

        adminCitiesPage.searchCity();
        String actualMessage = adminCitiesPage.getNameSearchField().getText();
        actualMessage.contains("Madrid");
    }

    @Test
    public void deleteCity() {
        homePage.getAdminButtonMenu().click();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage.getCitiesButton().click();

        adminCitiesPage.searchCity();
        String actualMessage = adminCitiesPage.getNameSearchField().getText();
        actualMessage.contains("Madrid");
        adminCitiesPage.deleteCity();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String actualMessage1 = adminCitiesPage.getDeleteMessage().getText();
        actualMessage1.contains("Deleted successfully");
    }
}
