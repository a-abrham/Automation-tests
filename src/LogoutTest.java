import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutTest {

    public static void logout(WebDriver driver) throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath(
                            "//*[@id=\"root\"]/div/div[1]/div/div/div/div[2]/div/ul/li[3]/div/div/div[1]/div/button")));

            WebElement dropdown = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div[2]/div/ul/li[3]/div/div/div[1]/div/button"));
            dropdown.click();

            Thread.sleep(1000);

            WebElement logout = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div[2]/div/ul/li[3]/div/div/div[2]/button"));
            logout.click();
            System.out.println("Logout Test Passed ✅");
        } catch (Exception e) {
            System.out.println("Logout Test Failed ❌: " + e.getMessage());
        }
    }
}
