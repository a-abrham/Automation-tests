import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    private static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder username = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            username.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
        }
        return username.toString() + "@example.com";
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Yordanos A. Kora\\Desktop\\real-projects\\chapa-automation-tests\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://executeautomation.com/");

        driver.manage().window().maximize();

        WebElement startLearningLink = driver
                .findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div[2]/div/ul/li[4]/a"));
        startLearningLink.click();

        WebElement profileImage = driver.findElement(By.cssSelector("img.profile-image.dialog-closed-mobile"));
        profileImage.click();

        WebElement avatarContainer = driver.findElement(By.cssSelector(".avatar-selector"));

        List<WebElement> avatarImages = avatarContainer.findElements(By.cssSelector("img.avatar"));

        int size = avatarImages.size();

        Random random = new Random();
        int randomIndex = random.nextInt(size);

        avatarImages.get(randomIndex).click();

        WebElement firstNameInput = driver.findElement(By.id("first_name"));
        firstNameInput.sendKeys("Abebe");

        WebElement lastNameInput = driver.findElement(By.id("last_name"));
        lastNameInput.sendKeys("Kebede");

        WebElement countryInput = driver.findElement(By.id("react-select-2-input"));

        countryInput.sendKeys("Ethiopia");
        countryInput.sendKeys(Keys.ENTER);

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("example@example.com");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("password123");

        WebElement passwordConfirmationInput = driver.findElement(By.id("password_confirmation"));
        passwordConfirmationInput.sendKeys("password123");

        WebElement designationInput = driver.findElement(By.id("designation"));
        designationInput.sendKeys("Software Engineer");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(@class, 'ct-btn-submit')]"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div[3]/div/button")));

        while (true) {
            WebElement okButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/button"));
            if (okButton.isDisplayed()) {
                okButton.click();
                String randomEmail = generateRandomEmail();

                emailInput = driver.findElement(By.id("email"));
                emailInput.clear();
                emailInput.sendKeys(randomEmail);
                submitButton.click();
                break;
            }
        }

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='profileData']/div[4]/button")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0, 100)");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
