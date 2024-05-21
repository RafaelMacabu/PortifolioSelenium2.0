package br.com.oticasdiniz.stepdef;

import br.com.oticasdiniz.pages.CartPage;
import br.com.oticasdiniz.pages.HomePage;
import br.com.oticasdiniz.pages.ProductPage;
import br.com.oticasdiniz.pages.SearchPage;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.testng.Assert;

import static br.com.oticasdiniz.utils.reports.screenshot.ScenarioRepository.screenShot;

public class CartStepDef {
    String productName = "";

    @E("inserir no campo de busca {string}")
    public void inserirNoCampoDeBusca(String busca) {
        HomePage.action().search(busca);
    }

    @E("clicar no primeiro resultado da busca")
    public void clicarNoPrimeiroResultadoDaBusca() {
        SearchPage.action().clickFirstResult();
    }

    @E("inserir o CEP {string}")
    public void inserirOCEP(String cep) {
        ProductPage.action().writePostalCode(cep).clickConfirmPostalCode();
    }

    @Quando("clicar no botão comprar")
    public void clicarNoBotãoComprar() {
        productName = ProductPage.action().getProductName();
        ProductPage.action().clickAddToBag();
    }

    @E("selecionar o a opção de sem grau e confirmar")
    public void selecionarOAOpçãoDeSemGrauEConfirmar() {
        ProductPage.action().clickNoDegree();
    }

    @Entao("o produto será adicionado ao carrinho")
    public void oProdutoSeráAdicionadoAoCarrinho() {
        CartPage.action().goToCartIfEmailIsAsked();
        Assert.assertEquals(CartPage.action().getProductNameInCart(),productName);
        screenShot();
    }
}
