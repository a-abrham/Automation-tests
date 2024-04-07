import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
    public static void login(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id='root']/div/div[1]/div/div/div/div[2]/div/ul/li[3]/a")));

        WebElement loginbutton = driver
                .findElement(By.xpath("//*[@id='root']/div/div[1]/div/div/div/div[2]/div/ul/li[3]/a"));
        loginbutton.click();

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.clear();
        emailInput.sendKeys("example@example.com");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys("wrongpassword");

        WebElement loginSubmit = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/button"));
        loginSubmit.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait2.until(ExpectedConditions
                .presenceOfElementLocated(By.className("swal-title")));

        WebElement divElement = driver.findElement(By.className("swal-title"));
        String divtxt = divElement.getText();

        if (divtxt.contains("Failed"))
            System.out.println("Wrong password test Passed");
        else
            System.out.println("Wrong password test Failed");

        WebElement okbut = driver.findElement(By.xpath("/html/body/div[3]/div/div[4]/div/button"));
        okbut.click();

        emailInput.clear();
        emailInput.sendKeys("ab@example.com");

        passwordInput.clear();
        passwordInput.sendKeys("password123"); // right password

        loginSubmit.click();

        try {
            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait3.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[@id='root']/div/div[1]/div/div/div/div[2]/div/ul/li[3]/div/div/div[1]")));
            System.out.println("Right Password Test Passed");
        } catch (Exception e) {
            System.out.println("Right Password Test Failed");
        }

    }
}
