package com.nopcommerce.demo.computer;

import com.nopcommerce.demo.pages.BuildYourOwnComputer;
import com.nopcommerce.demo.pages.Computers;
import com.nopcommerce.demo.pages.Desktop;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.TestBase;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends TestBase {

    // Object created for Homepage globally
    HomePage homepage = new HomePage();
    // Object created for Computers globally
    Computers computer = new Computers();
    // Object created for Desktop globally
    Desktop desktop = new Desktop();
    // Object created for BuildYourOwnComputer globally
    BuildYourOwnComputer buildyourowncomputer = new BuildYourOwnComputer();


    @Test
    public void verifyProductArrangeInReverseAlphabeticalOrder ()  {

        homepage.clickOnComputerMenu();
        computer.clickOnDesktop();
        desktop.selectSortByPositionNameZToA();
        desktop.verifyProductArrangeInDescendingOrder();
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully () throws InterruptedException {

        homepage.clickOnComputerMenu();
        Thread.sleep(1000);
        computer.clickOnDesktop();
        desktop.selectSortByPositionNameAToZ();
        Thread.sleep(1000);
        desktop.clickOnAddToCart();
        String expectedMsg = "Build your own computer";
        String actualMsg = buildyourowncomputer.getTextBuildYourOwnComputer();
        Assert.assertEquals(actualMsg,expectedMsg);
        buildyourowncomputer.selectProcessorAttribute("1");  // Select value 1 or 2 here
        buildyourowncomputer.selectRamAttribute("5");  // Select value 3,4 or 5 here
        waitUntilVisibilityOfElement(By.xpath("//input[@id='product_attribute_3_7']"),20);
        buildyourowncomputer.selectHDDAttribute("7");
        buildyourowncomputer.selectOSAttribute("9");
        buildyourowncomputer.selectSoftwareAttribute();
        Thread.sleep(1000);
        //waitUntilVisibilityOfElement(By.xpath("//span[@id='price-value-1']"),50);
        String expectedPrice = "$1,475.00";
        String actualPrice = buildyourowncomputer.getTextForPrice$1475();
        Assert.assertEquals(actualPrice,expectedPrice);
        buildyourowncomputer.clickOnAddToCartButton();
        String expectedMsg1 = "The product has been added to your shopping cart";
        String actualMsg1 = buildyourowncomputer.getTextProductAddedToCart();
        Assert.assertEquals(actualMsg1,expectedMsg1);
        buildyourowncomputer.setCloseTheBarCrossButton();

    }

















}
