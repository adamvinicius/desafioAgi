package br.com.chronosAcademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PesquisaBlogAgiMap {
    @FindBy(css = "#search-open")
    public WebElement btnLupa;
    @FindBy(xpath = "//*[@id='masthead']/div[1]//label/input")
    public WebElement inpPesquisar;
    @FindBy(xpath = "//*[@id='masthead']/div[1]//form/input")
    public WebElement btnPesquisar;
    @FindBy(css = ".entry-content > p")
    public WebElement textErro;
    @FindBy(css = ".entry-title > a")
    public List<WebElement> listLinksMaterias;

}
