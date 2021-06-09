package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BuildYourOwnComputer extends Utility {

        By verifyTextBuildOwnComputer = By.xpath("//h1[contains(text(),'Build your own computer')]");
        By processorAttribute = By.xpath("//select[@id='product_attribute_1']");
        By ramAttribute = By.xpath("//select[@id='product_attribute_2']");
        By hddAttribute = By.xpath("//input[@id='product_attribute_3_7']");
        By osAttribute = By.xpath("//input[@id='product_attribute_4_9']");
        By twoCommanderCheckBox = By.xpath("//input[@id='product_attribute_5_12']");
        By verifyPrice$1475 = By.xpath("//span[@id='price-value-1']");
        By AddToCartButton = By.xpath("//button[@id='add-to-cart-button-1']");
        By verifyProductAddedMsg = By.xpath("//div[@class='bar-notification success']/p");//div[@id='bar-notification']
        By closeTheBarCrossButton = By.xpath("//span[@class='close']");


        public String getTextBuildYourOwnComputer () {
            return getTextFromElement(verifyTextBuildOwnComputer);
        }

        public void selectProcessorAttribute (String value) {
            selectByValueFromDropDown(processorAttribute,
                    value);
        }

        public void selectRamAttribute (String value) {
            selectByValueFromDropDown(ramAttribute,
                    value);
        }

        public void selectHDDAttribute (String value) {
            clickOnElement(hddAttribute, value);
        }

        public void selectOSAttribute (String value) {
            clickOnElement(osAttribute, value);
        }

        public void selectSoftwareAttribute() {
            mouseHoverToElementAndClick(twoCommanderCheckBox);
        }

        public String getTextForPrice$1475 () {
            return getTextFromElement(verifyPrice$1475);
        }

        public void clickOnAddToCartButton () {
            mouseHoverToElementAndClick(AddToCartButton);
        }

        public String getTextProductAddedToCart () {
            return getTextFromElement(verifyProductAddedMsg);
        }

        public void setCloseTheBarCrossButton () {
            mouseHoverToElementAndClick(closeTheBarCrossButton);
        }

}
