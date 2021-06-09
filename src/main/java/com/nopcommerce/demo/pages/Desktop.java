package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Desktop extends Utility {

    By sortByZtoA = By.id("products-orderby");
    By descendingOrder = By.id("products-orderby");//div[@class='details']products-orderby
    By sortByAtoZ = By.id("products-orderby");
    By addToCart = By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]");//button[@class='button-2 product-box-add-to-cart-button']

    public void selectSortByPositionNameZToA() {
        selectByValueFromDropDown((sortByZtoA), "6");
    }

    public void verifyProductArrangeInDescendingOrder() {
        selectByValueVisibleText((descendingOrder), "Name: Z to A");

        //Getting list of web elements of product name
        List<WebElement> deskTopList = driver.findElements(By.xpath("//div[@class='item-grid']"));

        List<String> productName = new ArrayList<>();
        for (WebElement desktop : deskTopList) {
            productName.add(desktop.getText());

            List<String> templist = new ArrayList<>();  // temperary array list
            templist.addAll(productName);

            Collections.sort(templist, Collections.reverseOrder());  // Collections.sort(templist); for Asc only
            System.out.println(productName);
            System.out.println(templist);

            Assert.assertEquals(productName, templist);
        }
    }

    public void selectSortByPositionNameAToZ() {
        selectByValueFromDropDown((sortByAtoZ), "5");
    }

    public void clickOnAddToCart() {
        mouseHoverToElementAndClick(addToCart);

    }

}
