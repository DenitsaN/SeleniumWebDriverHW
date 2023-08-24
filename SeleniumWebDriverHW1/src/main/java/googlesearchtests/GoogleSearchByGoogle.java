package googlesearchtests;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class GoogleSearchByGoogle {

    private static WebDriver driver;

    @BeforeEach
    public static void classSetup() {
        // Setup browser
        driver = new ChromeDriver();
    }


    @Test
    public void resultFound_when_searchTermProvided_telerikAcademy() {
        // Navigate to Google
        driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // Agree to consent

        WebElement agreeButton = driver.findElement(By.xpath("//button[@id='L2AGLb']"));
        agreeButton.click();

        // Find the search input element and search for 'Telerik Academy Alpha'
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@type='search']"));
        searchBox.sendKeys("Telerik Academy Alpha");
        searchBox.sendKeys(Keys.RETURN);

        // Wait for the search
        int waitTimeSeconds = 10;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeSeconds)); // 10 seconds timeout
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a/h3)[1]"))));

        // Validate the title of the first result
        WebElement firstResult = driver.findElement(By.xpath("(//a/h3)[1]"));
        String expectedResultFirst = "IT Career Start in 6 Months - Telerik Academy Alpha";
        String expectedResultSecond = "Telerik Academy Alpha - IT Career Start in 6 Months";
        String actualResult = firstResult.getText();

        Assertions.assertTrue((actualResult.equals(expectedResultFirst)) || (actualResult.equals(expectedResultSecond)),
                "The result is not found");

        // Close the browser
        driver.quit();

    }
}
