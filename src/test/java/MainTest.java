import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.example.Main.getPad;
import static org.example.Main.getSum;
import static org.testng.Assert.assertEquals;

public class MainTest {

    @Test
    public void testGetSum() {

        Assert.assertEquals(getSum(0, 0), 0);
        Assert.assertEquals(getSum(5, 5), 10);
        Assert.assertEquals(getSum(1000000000, 1000000000), 2000000000);
        Assert.assertEquals(getSum(-5, -5), -10);
    }


    @Test
    public void testGetPad() {
        Assert.assertEquals(getPad("C", 0), "");
        Assert.assertEquals(getPad("", 3), "");
        Assert.assertEquals(getPad("A", 3), "AAA");
    }

    @Test
    public void testCapitalize() {
        Assert.assertEquals(StringUtils.capitalize("history"), "History");
        Assert.assertNotEquals(StringUtils.capitalize("history"), "HISTORY");
    }

    @Test
    public void testSomething() {
        Assert.assertEquals(StringUtils.compareIgnoreCase("HISTORY", "HiStoRy"), 0);
        Assert.assertNotEquals(StringUtils.compareIgnoreCase("HISTORY", "HiStoR"), 0);
    }

    @Test
    public void testTest(){

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    driver.get("https://www.selenium.dev/selenium/web/web-form.html");

    WebElement textBox = driver.findElement(By.name("my-text"));
    textBox.sendKeys("Selenium");

    WebElement textArea = driver.findElement(By.name("my-textarea"));
    textArea.sendKeys("Julia");

    WebElement submitButton = driver.findElement(By.cssSelector("button"));
    submitButton.click();

    WebElement message = driver.findElement(By.id("message"));
    String value = message.getText();
    Assert.assertEquals("Received!", value);

    driver.quit();
    }

    @Test
    public void testGoogle() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement text = driver.findElement(By.id("APjFqb"));
        text.sendKeys("Selenium");

        Thread.sleep(1000);

        WebElement button = driver.findElement(By.className("gNO89b"));
        button.click();

        WebElement link = driver.findElement(By.xpath("//a[@href = 'https://www.selenium.dev/']/h3"));
        String resultText = link.getText();

        Assert.assertEquals(resultText, "Selenium");

        driver.quit();

    }

    @Test
    public void testAuthSaucedemo() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("https://www.saucedemo.com/");

        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        usernameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        driver.quit();
    }
}
