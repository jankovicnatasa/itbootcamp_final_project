package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTests extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.openLoginPage();
        loginPage.login("admin@admin.com", "12345");
        homePage.getMyProfileButtonMenu().click();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    Faker faker = new Faker();

    @Test
    public void editProfile() {
        String randomName = faker.name().firstName();
        String randomPhone = faker.phoneNumber().cellPhone();
        String city = "Cali";
        String randomCountry = faker.country().name();
        String randomGitHub = "https://github.com/" + randomName.toLowerCase();
        String randomTwitter = "https://twitter.com/" + randomName.toLowerCase();
        profilePage.editProfile(randomName, randomPhone, city, randomCountry, randomTwitter, randomGitHub);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(profilePage.getMessage().contains("Profile saved successfuly"));
        profilePage.closeMessage();
        Assert.assertEquals(profilePage.getName(), randomName);
        Assert.assertEquals(profilePage.getPhone(), randomPhone);
        Assert.assertEquals(profilePage.getCity(), city);
        Assert.assertEquals(profilePage.getCountry(), randomCountry);
        Assert.assertEquals(profilePage.getTwitter(), randomTwitter);
        Assert.assertEquals(profilePage.getGitHub(), randomGitHub);
    }


}

