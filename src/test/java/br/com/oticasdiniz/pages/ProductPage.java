package br.com.oticasdiniz.pages;

import br.com.oticasdiniz.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static br.com.oticasdiniz.base.BaseTest.getDriver;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productName;
    @FindBy(xpath = "(//a[@class='buy-button buy-button-ref'])[1]")
    private WebElement addToBagButton;
    @FindBy(xpath = "//div[@value='sem-grau']")
    private WebElement optionWithoutDegree;
    @FindBy(xpath = "//button[@data='receita']")
    private WebElement addToBagIfPrompted;
    @FindBy(xpath = "(//a[@href='javascript:window.xgen.closeEmbed();'])[1]")
    private WebElement closePopup;
    @FindBy(xpath = "//div[@class='product-buy custom-lens-started']")
    private WebElement checkIfGlassesHasDegree;
    @FindBy(xpath = "(//input[@maxlength='9'])[1]")
    private WebElement inputPostalCode;
    @FindBy(xpath = "//button[@data='cep']")
    private WebElement buttonConfirmPostalCode;

    public ProductPage() {
        super(getDriver());
    }

    public static ProductPage action(){
        return new ProductPage();
    }

    public ProductPage writePostalCode(String postalCode){
        super.writeText(inputPostalCode,postalCode);
        return this;
    }

    public ProductPage clickConfirmPostalCode(){
        super.clickElement(buttonConfirmPostalCode);
        return this;
    }

    public CartPage addToBag(){
        super.interactWithJavascript("javascript:window.xgen.closeEmbed();");
        if (verifyIfElementIsPresent(checkIfGlassesHasDegree)){
            System.out.println("CHEGOU NO IF");
            super.clickElement(addToBagButton);
            super.clickElement(optionWithoutDegree);
            super.clickElement(addToBagIfPrompted);
        }else {
            System.out.println("CHEGOU NO ELSE");
            super.clickElement(addToBagButton);
        }
        return new CartPage();
    }

    public ProductPage clickAddToBag(){
        super.interactWithJavascript("javascript:window.xgen.closeEmbed();");
        super.clickElement(addToBagButton);
        return this;
    }

    public CartPage clickNoDegree(){
        if (verifyIfElementIsPresent(checkIfGlassesHasDegree)){
            System.out.println("CHEGOU NO TRUE TEM GRAU");
            super.clickElement(optionWithoutDegree);
            super.clickElement(addToBagIfPrompted);
        }
        return new CartPage();
    }

    public String getProductName(){
        return super.getText(productName);
    }
}
