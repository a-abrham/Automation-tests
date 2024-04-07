import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnrollTest {
    public static void enroll(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(
                        "//*[@id=\"root\"]/div/div[1]/div/div/div/div[2]/div/ul/li[3]/div/div/div[1]/div/button")));

        // WebElement button =
        // driver.findElement(By.xpath("//*[@id=\"ct-path-main\"]/div[1]/div[2]/button"));
        // button.click();
        // Thread.sleep(1000);

        // button =
        // driver.findElement(By.xpath("//*[@id=\"ct-path-main\"]/div[1]/div[4]/button"));
        // button.click();
        // Thread.sleep(1000);

        // button =
        // driver.findElement(By.xpath("//*[@id=\"ct-path-main\"]/div[1]/div[1]/button"));
        // button.click();
        // Thread.sleep(1000);

        // js.executeScript("window.scrollBy(0, 150)");

        // Thread.sleep(5000);

        WebElement learningpath = driver
                .findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div[2]/div/ul/li[1]/a"));
        learningpath.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(
                        "//*[@id='ct-path-area']/div/div[2]/a/div/div[2]/div[1]")));

        // WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
        // wait2.until(ExpectedConditions
        // .presenceOfElementLocated(By.xpath(
        // "//*[@id=\"ct-path-area\"]/div/div[4]/a/div/div[2]/div[1]")));

        // JavascriptExecutor js = (JavascriptExecutor) driver;

        // for (int i = 0; i < 2; i++) {
        // js.executeScript("window.scrollBy(0, 50)");
        // try {
        // Thread.sleep(500);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // }

        WebElement course = driver.findElement(By.xpath("//*[@id='ct-path-area']/div/div[2]/a/div/div[2]/div[1]"));
        course.click();

        WebElement element = driver
                .findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div[1]/div[2]/button"));

        String buttonText = element.getText();

        if (buttonText.contains("Resume")) {
            System.out.println("Test Passed: user is able to resume.");
        } else {
            element = driver
                    .findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div[1]/div[2]/button"));

            element.click();

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath(
                            "/html/body/div[3]/div/div[2]")));

            element = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]"));
            String elementText = element.getText();
            if (elementText.contains("Enrolled")) {
                System.out.println("passed");

                element = driver.findElement(By.xpath("/html/body/div[3]/div/div[4]/div/button"));
                element.click();
            }

        }

        // WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(60));
        // wait3.until(ExpectedConditions
        // .presenceOfElementLocated(By.xpath(
        // "//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div[1]/div[2]/button")));

        // WebElement enrollbtn = driver
        // .findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div[1]/div[2]/button"));
        // enrollbtn.click();

        // WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(60));
        // wait4.until(ExpectedConditions
        // .presenceOfElementLocated(By.xpath(
        // "/html/body/div[3]/div/div[4]/div/button")));

        // WebElement okbtn =
        // driver.findElement(By.xpath("/html/body/div[3]/div/div[4]/div/button"));
        // okbtn.click();

    }
}
