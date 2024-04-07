import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Yordanos A. Kora\\Desktop\\real-projects\\chapa-automation-tests\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        driver.manage().window().maximize();

        WebElement joinNowButton = driver.findElement(
                By.xpath("//a[contains(@data-tracking-control-name,'guest_homepage-basic_nav-header-join')]"));
        joinNowButton.click();

    }
}
