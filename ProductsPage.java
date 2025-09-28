package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    WebDriver driver;

    // Locators
    private By addToCartBtn = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Add item to cart
    public void addItemToCart() {
        driver.findElement(addToCartBtn).click();
    }

    // Check if cart is not empty
    public boolean isCartNotEmpty() {
        return driver.findElement(cartIcon).getText().length() > 0;
    }

    // Click on the cart icon to go to cart page
    public void clickCart() {
        driver.findElement(cartIcon).click();
    }

    // Getter for cart icon element (for explicit waits)
    public WebElement getCartButton() {
        return driver.findElement(cartIcon);
    }
}
