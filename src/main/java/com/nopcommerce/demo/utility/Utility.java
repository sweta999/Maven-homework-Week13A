package com.nopcommerce.demo.utility;

import com.nopcommerce.demo.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility extends BasePage {

    /**
     * This method will click on element
     */
    // click on element method. By=class, by=variable
    public void clickOnElement(By by, String value) {
        driver.findElement(by).click();
    }

    /**
     * This method will click on element
     */
    // click on element method. By=class, by=variable
    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will get text from element
     *
     * @return
     */
    public String getTextFromElement(By by) {
        /*String text = driver.findElement(by).click();
        text =*/
        //OR
        return driver.findElement(by).getText();
    }

    /**
     * This method will send Text to/on  Element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will select by value from dropdown by value
     */
    public void selectByValueFromDropDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }


    /**
     * This method will select by visibleText from dropdown by visibleText
     */
    public void selectByValueVisibleText(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(value);
    }

    /**
     * This method will select by Index from dropdown by Index
     */
    public void selectByIndex(By by, int value) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(value);
    }

    /**
     * This method will used to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method will used to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    /**
     * This method will used to wait until element located
     */
    public WebElement waitUntilVisibilityOfElement(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
        //OR
        // 1 Line for 2 & 3 line(need to make it)
    }

    /**
     * This method will used to wait until element located
     */
    public void verifyMessage(By by, int timeout, String expected, String unexpected) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String expectedMessage = expected;
        String actualMessage = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals( expectedMessage, actualMessage);
    }

}