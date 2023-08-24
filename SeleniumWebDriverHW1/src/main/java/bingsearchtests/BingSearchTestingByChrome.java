package bingsearchtests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;



public class BingSearchTestingByChrome {

    private static WebDriver driver;


    @BeforeAll
    public static void classSetup() {
        // Setup browser
        driver = new ChromeDriver();
    }

    @Test
    public void resultFound_when_searchTermProvided() {

        // Navigate to Bing.com

        driver.get("https://www.bing.com");

        // Find the search input element and enter the search query

        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("Telerik Academy Alpha");
        searchBox.submit();

        // Wait for the first result's title to be visible

        WebElement firstResultTitle = driver.findElement(By.xpath("(//h2/a)[1]"));

        // Get the actual title text
        String actualTitle = firstResultTitle.getText();

        // Expected title
        String expectedTitle = "IT Career Start in 6 Months - Telerik Academy Alpha";

        // Assertion: Validate the title
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");

    }

    @AfterAll

    public static void classTearDown () {
        // Close the browser
        driver.quit();

    }
}
