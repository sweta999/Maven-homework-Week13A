package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {

    By computerLink = By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a");


    public void selectMenu(String menu) {
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='header-menu']/ul[1]/li/a"));
        for (WebElement element : elementList) {
            if (element.getText().equalsIgnoreCase(menu)) {
                element.click();
                break;
            }
        }
    }

    public void clickOnComputerMenu() {
        mouseHoverToElementAndClick(computerLink);
    }



}