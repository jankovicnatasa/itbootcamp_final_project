package tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;


public class AuthRoutesTests extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        if (driver.getCurrentUrl().equals("https://vue-demo.daniel-avellaneda.com/home")) {
            driver.findElement(By.linkText("Logout")).click();
        }
    }

    @Test
    public void forbidsHomeUrl() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("/login");
    }

    @Test
    public void forbidsProfileUrl() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("/login");
    }

    @Test
    public void forbidsAdminCitiesUrl() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("/login");
    }

    @Test
    public void forbidsAdminUsersUrl() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("/login");
    }
}
