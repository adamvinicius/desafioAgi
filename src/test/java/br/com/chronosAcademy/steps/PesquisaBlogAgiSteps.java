package br.com.chronosAcademy.steps;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.enums.Browser;
import br.com.chronosAcademy.pages.PesquisaBlogAgiPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;

public class PesquisaBlogAgiSteps {
    PesquisaBlogAgiPage pesquisaBlogAgiPage;

    @Before
    public void iniciaNavegador(Scenario cenario){
        new Driver(Browser.CHROME);
        Driver.setNomeCenario(cenario.getName());
        Driver.criaDiretorio();
    }

    @After
    public void fechaNavegador(Scenario cenario) throws IOException {
        if(cenario.isFailed()){
            Driver.printScreen("erro no cenario");
        }
        Driver.getDriver().quit();
    }

    @Dado("que esteja na pagina inicial do blog Agi")
    public void queEstejaNaPaginaInicialDoBlogAgi() {
        pesquisaBlogAgiPage = new PesquisaBlogAgiPage();
        Driver.getDriver().get("https://blogdoagi.com.br/");
    }
    @Quando("clico na lupa da pagina inicial")
    public void clicoNaLupaDaPaginaInicial() {
        pesquisaBlogAgiPage.clickLupa();
    }
    @Entao("valido que o campo de pesquisa e botao estao sendo exibidos")
    public void validoQueOCampoDePesquisaEBotaoEstaoSendoExibidos() {
        Assert.assertTrue("Elemento pesquisar nao foi exibido",pesquisaBlogAgiPage.isInpPesquisar());
        Assert.assertTrue("Botao pesquisar nao foi exibido", pesquisaBlogAgiPage.isBtnPesquisa());
    }

    @Quando("pesquiso por {string}")
    public void pesquisoPor(String valor) {
        pesquisaBlogAgiPage.setPesquisar(valor);
        pesquisaBlogAgiPage.clickPesquisar();
    }
    @Entao("exibe a mensagem {string}")
    public void exibeAMensagem(String texto) {
        Assert.assertEquals(texto, pesquisaBlogAgiPage.getTextErro());
    }

    @Entao("exibe somente um item")
    public void exibeSomenteUmItem() {
        Assert.assertEquals(1, pesquisaBlogAgiPage.qtdMaterias());
    }

    @Entao("exibe somente mais de um item")
    public void exibeSomenteMaisDeUmItem() throws Exception {
        if (pesquisaBlogAgiPage.qtdMaterias() < 2){
            throw new Exception("Nao foi encontrado mais de uma materia!");
        }
    }

    @Entao("valido que o campo de pesquisa e botao nao estao sendo exibidos")
    public void validoQueOCampoDePesquisaEBotaoNaoEstaoSendoExibidos() {
        Assert.assertTrue(pesquisaBlogAgiPage.isInvisibilityInpPesquisar());
        Assert.assertTrue(pesquisaBlogAgiPage.isInvibilityBtnPesquisa());
    }
}
