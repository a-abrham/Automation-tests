import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Yordanos A. Kora\\Desktop\\real-projects\\chapa-automation-tests\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://executeautomation.com/");

        driver.manage().window().maximize();

        // SignUpTest.signUp(driver);
        // LogoutTest.logout(driver);
        LoginTest.login(driver);
        EnrollTest.enroll(driver);
    }
}