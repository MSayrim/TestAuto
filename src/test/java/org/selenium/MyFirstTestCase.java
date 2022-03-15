package org.selenium;
import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://www.askomdch.com");
        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.clickStoreMenuLink();
        storePage.
                enterTextInSearchFld("Blue").
                clickSearchBtn();
        Thread.sleep(5000);
        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(3000);
        CartPage cartPage =storePage.clickViewChart();
        Thread.sleep(3000);

//
//        driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
//        driver.findElement(By.cssSelector("button[value='Search']")).click();
//        Thread.sleep(3000);
//        Assert.assertEquals(
//                driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),
//                "Search results: “Blue”"
//        );
//        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        Assert.assertEquals(
                cartPage.getProductName(),
                "Blue Shoes"
        );
        driver.findElement(By.cssSelector(".checkout-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_email")).sendKeys("askomdch@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(
                By.cssSelector(".woocommerce-notice")).getText(),
                "Thank you. Your order has been received."
        );

    }
}
