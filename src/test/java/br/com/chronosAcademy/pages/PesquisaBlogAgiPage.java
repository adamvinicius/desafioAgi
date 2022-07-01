package br.com.chronosAcademy.pages;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.maps.PesquisaBlogAgiMap;
import org.openqa.selenium.support.PageFactory;

public class PesquisaBlogAgiPage {
    PesquisaBlogAgiMap pesquisaBlogAgiMap;
    public PesquisaBlogAgiPage(){
        pesquisaBlogAgiMap = new PesquisaBlogAgiMap();
        PageFactory.initElements(Driver.getDriver(), pesquisaBlogAgiMap);
    }

    public PesquisaBlogAgiPage clickLupa(){
        pesquisaBlogAgiMap.btnLupa.click();
        return this;
    }

    public boolean isInpPesquisar(){
        try {
            Driver.visibilityOf(pesquisaBlogAgiMap.inpPesquisar);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean isBtnPesquisa(){
        try {
            Driver.visibilityOf(pesquisaBlogAgiMap.btnPesquisar);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean isInvisibilityInpPesquisar(){
        try {
            Driver.invisibilityOf(pesquisaBlogAgiMap.inpPesquisar);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean isInvibilityBtnPesquisa(){
        try {
            Driver.invisibilityOf(pesquisaBlogAgiMap.btnPesquisar);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public PesquisaBlogAgiPage setPesquisar(String pesquisar){
        Driver.visibilityOf(pesquisaBlogAgiMap.inpPesquisar);
        pesquisaBlogAgiMap.inpPesquisar.sendKeys(pesquisar);
        return this;
    }
    public PesquisaBlogAgiPage clickPesquisar(){
        pesquisaBlogAgiMap.btnPesquisar.click();
        return this;
    }

    public String getTextErro(){
        return pesquisaBlogAgiMap.textErro.getText();
    }

    public int qtdMaterias(){
        return pesquisaBlogAgiMap.listLinksMaterias.size();
    }
}
