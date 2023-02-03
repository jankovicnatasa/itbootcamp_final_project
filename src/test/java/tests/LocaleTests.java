package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest {
    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
    }

    @Test
    public void setLocaleToES() {
        homePage.getLanguageButtonMenu().click();
        homePage.getLanguageES().click();

        String expectedMessage = "Página de aterrizaje";
        String actualMessage = homePage.getLanguageMessage().getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void setLocaleToEN() {
        homePage.getLanguageButtonMenu().click();
        homePage.getLanguageEN().click();

        String expectedMessage = "Landing";
        String actualMessage = homePage.getLanguageMessage().getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void setLocaleToFR() {
        homePage.getLanguageButtonMenu().click();
        homePage.getLanguageFR().click();

        String expectedMessage = "Page d'atterrissage";
        String actualMessage = homePage.getLanguageMessage().getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
