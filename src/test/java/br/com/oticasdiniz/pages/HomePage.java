package br.com.oticasdiniz.pages;

import br.com.oticasdiniz.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static br.com.oticasdiniz.base.BaseTest.getDriver;

public class HomePage extends BasePage {
    @FindBy(xpath = "(//input[@class='fulltext-search-box'])[1]")
    private WebElement searchBarInput;
    @FindBy(xpath = "//li[@data-item='oculos-de-grau']")
    private WebElement hoverDegreeGlasses;
    @FindBy(xpath = "(//a[text()='Masculino'])[1]")
    private WebElement hoverOptionManGlasses;
    @FindBy(xpath = "(//a[text()='Infantil'])[1]")
    private WebElement hoverOptionChildrenGlasses;
    @FindBy(xpath = "(//a[text()='Emporio Armani'])[1]")
    private WebElement hoverOptionArmaniGlasses;
    @FindBy(xpath = "//div[@class='encontreLoja']")
    private WebElement findStoreButton;
    @FindBy(xpath = "//input[@id='storelocator-search_address']")
    private WebElement storeLocatorInputAddress;
    @FindBy(xpath = "(//li[@class='ui-menu-item'])[1]")
    private WebElement storeLocatorNearestStore;
    @FindBy(xpath = "//p[@class='storelocator-storename']")
    private WebElement storeLocatorNearestStoreName;
    @FindBy(xpath = "(//div[@class='shelf prateleira n10colunas'])[1]")
    private WebElement elementUniqueToHomepage;

    public HomePage() {
        super(getDriver());
    }

    public static HomePage action(){
        return new HomePage();
    }

    public HomePage load(){
        load("/");
        return this;
    }

    public boolean verifyIfIsOnHomePage(){
        return super.verifyIfElementIsPresent(elementUniqueToHomepage);
    }

    public SearchPage search(String text){
        super.writeText(searchBarInput,text + Keys.ENTER);
        return new SearchPage();
    }

    public HomePage clickFindStore(){
        super.clickElement(findStoreButton);
        return this;
    }

    public HomePage findAddress(String text){
        super.writeText(storeLocatorInputAddress,text);
        return this;
    }

    public HomePage clickNearestStore(){
        super.clickElement(storeLocatorNearestStore);
        return this;
    }

    public String getNearestName(){
        return super.getText(storeLocatorNearestStoreName) ;
    }

    public HomePage hoverOverDegreeGlasses(){
        super.hoverOverElement(hoverDegreeGlasses);
        return this;
    }

    public SearchPage clickManAfterHover(){
        super.clickElement(hoverOptionManGlasses);
        return new SearchPage();
    }

    public SearchPage clickChildAfterHover(){
        super.clickElement(hoverOptionChildrenGlasses);
        return new SearchPage();
    }

    public SearchPage clickArmaniAfterHover(){
        super.clickElement(hoverOptionArmaniGlasses);
        return new SearchPage();
    }

}
