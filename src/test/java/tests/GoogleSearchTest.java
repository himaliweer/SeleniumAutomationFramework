package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

@Listeners(listeners.TestNGListeners.class)

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchTest() throws InterruptedException {
        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("ABCD");
        Thread.sleep(2000); // just for demo
        driver.findElement(By.name("q")).submit();

        // PASS condition
        String title = driver.getTitle();
        if (!title.contains("ABCD")) {
            throw new RuntimeException("Title does not contain ABCD");
        }
    }

    @Test
    public void failingTest() {
        driver.get("https://www.google.com");

        // Force failure
        throw new RuntimeException("Intentional Failure");
    }

    @Test
    public void skippedTest() {
    	driver.get("https://www.yahoo.com");
        throw new org.testng.SkipException("Skipping this test intentionally");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}