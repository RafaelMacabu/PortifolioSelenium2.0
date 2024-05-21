package br.com.oticasdiniz.tests;

import br.com.oticasdiniz.base.BaseTest;
import br.com.oticasdiniz.pages.CartPage;
import br.com.oticasdiniz.pages.HomePage;
import org.testng.annotations.Test;

public class TempTest extends BaseTest {
    @Test
    public void openHomeTest() throws InterruptedException {
        HomePage.action()
                .load()
                .search("lacoste")
                .clickFirstResult()
                .addToBag()
                .goToCartIfEmailIsAsked();
        System.out.println(CartPage.action().getProductNameInCart());
        Thread.sleep(1000000000);
    }

    @Test
    public void HoverHomeTest() throws InterruptedException {
        HomePage.action()
                .load()
                .hoverOverDegreeGlasses()
                .clickArmaniAfterHover()
                .clickFirstResult()
                .addToBag()
                .goToCartIfEmailIsAsked();
        System.out.println("FIM DO TESTE");
        Thread.sleep(10000000);
    }

    @Test
    public void StoreLocatorTest() throws InterruptedException {
        HomePage.action()
                .load()
                .clickFindStore()
                .findAddress("campos dos goytacazes")
                .clickNearestStore()
                .getNearestName();
        System.out.println("FIM DO TESTE");
        Thread.sleep(10000);
    }
}
