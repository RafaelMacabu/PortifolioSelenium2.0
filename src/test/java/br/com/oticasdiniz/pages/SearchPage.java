package br.com.oticasdiniz.pages;

import br.com.oticasdiniz.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static br.com.oticasdiniz.base.BaseTest.getDriver;

public class SearchPage extends BasePage {
    @FindBy(xpath = "(//a[@class='btn-add-buy-button-asynchronous'])[1]")
    private WebElement firstResult;

    public SearchPage() {
        super(getDriver());
    }

    public static SearchPage action(){
        return new SearchPage();
    }

    public SearchPage load(){
        load("/");
        return this;
    }

    public SearchPage loadSearch(String search){
        load("/" + search.trim());
        return this;
    }

    public ProductPage clickFirstResult(){
        super.clickElement(firstResult);
        return new ProductPage();
    }


}
