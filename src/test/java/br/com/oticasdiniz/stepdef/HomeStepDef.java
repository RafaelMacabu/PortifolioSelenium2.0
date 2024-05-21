package br.com.oticasdiniz.stepdef;

import br.com.oticasdiniz.pages.HomePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.testng.Assert;

import static br.com.oticasdiniz.utils.reports.screenshot.ScenarioRepository.screenShot;

public class HomeStepDef {
    String enderecoAssert = "";

    @Dado("que estou na página inicial")
    public void queEstouNaPáginaInicial() {
        Assert.assertTrue(HomePage.action().load().verifyIfIsOnHomePage());
    }

    @E("clicar no botão encontre uma diniz")
    public void clicarNoBotãoEncontreUmaDiniz() {
        HomePage.action().clickFindStore();
    }

    @E("e inserir {string} no campo informe seu endereço")
    public void eInserirNoCampoInformeSeuIndereço(String endereco) {
        enderecoAssert = endereco;
        HomePage.action().findAddress(endereco);
    }

    @Quando("selecionar o primeiro resultado da lista")
    public void selecionarOPrimeiroResultadoDaLista() {
        HomePage.action().clickNearestStore();

    }

    @Entao("encontrará uma loja no local informado")
    public void encontraráUmaLojaNoLocalInformado() {
        System.out.println(HomePage.action().getNearestName());
        System.out.println(enderecoAssert);
        System.out.println("FIM DO TESTE");
        Assert.assertTrue(HomePage.action().getNearestName().toLowerCase().contains(enderecoAssert.toLowerCase()));
        screenShot();
    }

    @E("^passo o mouse por cima de (Óculos de Grau|Óculos de Sol)$")
    public void passoOMousePorCimaDe(String tipoDeOculosHover) {
        switch (tipoDeOculosHover){
            case "Óculos de Grau":
                HomePage.action().hoverOverDegreeGlasses();
                break;
        }
    }

    @E("^clicar na opção (Emporio Armani|Masculino|Infantil)$")
    public void clicarNaOpção(String categoriaSubHover) {
        switch (categoriaSubHover){
            case "Emporio Armani":
                HomePage.action().clickArmaniAfterHover();
                break;
        }
    }
}
