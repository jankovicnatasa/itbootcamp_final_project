package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SignupTests extends BaseTest {

    Faker faker = new Faker();

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.openSignupPage();
    }

    @AfterMethod
    public void afterMethod() {
        List<WebElement> logoutButton = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[1]"));
        if (!logoutButton.isEmpty()) {
            logoutButton.get(0).click();
        }
    }

    @Test
    public void visitSignupPage() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("/signup"));
    }

    @Test
    public void checkInputTypes() {
        String emailType = signUpPage.getEmailField().getAttribute("type");
        Assert.assertEquals(emailType, "email");

        String passwordType = signUpPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(passwordType, "password");

        String confirmPasswordType = signUpPage.getConfirmPasswordField().getAttribute("type");
        Assert.assertEquals(confirmPasswordType, "password");
    }

    @Test
    public void userAlreadyExistsErrors() {
        signUpPage.signUp("Test Test", "admin@admin.com", "123654", "123654");

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        String expectedMessage = "E-mail already exists";
        String actualMessage = signUpPage.getErrorMessage().getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        visitSignupPage();
    }

    @Test
    public void signup() {
        signUpPage.signUp("Natasa Jankovic", faker.internet().emailAddress(), "12345", "12345");
        String expectedMessage = "IMPORTANT: Verify your account";

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualMessage = signUpPage.getImportantMessage().getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        signUpPage.getCloseMessageButton().click();
    }
}
