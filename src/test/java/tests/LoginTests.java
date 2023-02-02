package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    Faker faker = new Faker();

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.openLoginPage();
    }

    @AfterMethod
    public void logoutIfLogged() {
        String actualUrl = driver.getCurrentUrl();
        if ((actualUrl.contains("/home"))) {
            loginPage.getLogoutButton().click();
        }

    }

    @Test
    public void visitTheLoginPage() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("/login"));
    }

    @Test
    public void checkInputTypes() {
        String emailType = loginPage.getEmailField().getAttribute("type");
        Assert.assertEquals(emailType, "email");

        String passwordType = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(passwordType, "password");
    }

    @Test
    public void userDoesntExistsError() {
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        String expectedMessage = "User does not exists";
        String actualMessage = loginPage.getErrorMessage().getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        visitTheLoginPage();

    }

    @Test
    public void wrongPasswordError() {

        loginPage.login("admin@admin.com", faker.internet().emailAddress());

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        String expectedMessage = "Wrong password";
        String actualMessage = loginPage.getErrorMessage().getText();

        Assert.assertEquals(actualMessage, expectedMessage);
        visitTheLoginPage();
    }

    @Test
    public void login() {
        loginPage.login("admin@admin.com", "12345");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("/home"));
    }

    @Test

    //•	Verifikovati da je dugme logout vidljivo na stranici
    //•	Verifikovati da se nakon pokušaja otvaranja /home rute, u url-u stranice javlja
    // /login ruta (otvoriti sa driver.get home page i proveriti da li vas redirektuje na login)
    public void logout() {

        loginPage.login("admin@admin.com", "12345");

        loginPage.getLogoutButton().isDisplayed();
        loginPage.getLogoutButton().click();

        driver.get("https://vue-demo.daniel-avellaneda.com/home");

        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("/login"));


    }


}
