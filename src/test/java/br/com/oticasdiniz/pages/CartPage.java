package br.com.oticasdiniz.pages;

import br.com.oticasdiniz.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static br.com.oticasdiniz.base.BaseTest.getDriver;

public class CartPage extends BasePage {
    @FindBy(xpath = "//p//a[@id='orderform-to-cart']")
    private WebElement goToCartAfterEmailCheckButton;
    @FindBy(xpath = "(//td[@class='product-name'])[1]")
    private WebElement productNameInCart;

    public CartPage() {
        super(getDriver());
    }

    public static CartPage action(){
        return new CartPage();
    }

    public CartPage load(){
        load("/checkout/#/cart");
        return this;
    }

    public CartPage goToCartIfEmailIsAsked(){
        super.clickElement(goToCartAfterEmailCheckButton);
        return this;
    }

    public String getProductNameInCart(){
       return super.getText(productNameInCart);
    }
}
