package steps;

import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.CadastroPage;
import runner.RunCucumberTest;

public class CadastroSteps extends RunCucumberTest {

    CadastroPage cadastroPage = new CadastroPage();

    @Quando("^eu preencho o formulário de cadastro$")
    public void eu_preencho_o_formulário_de_cadastro() {
        cadastroPage.selectTitle(1);
        cadastroPage.preencheNome("Thiago Lyon");
        cadastroPage.preencheSobrenome("Nascimento");
        cadastroPage.preenchePassword("ABc@123");
        cadastroPage.selecionaNascimento(01, 04, "1989");
        cadastroPage.preencheAddress("QNL 17 Bloco D");
        cadastroPage.preencheCity("Taguatinga Norte");
        cadastroPage.selecionaEstado("Colorado");
        cadastroPage.preenchePostcode("72151");
        cadastroPage.selecionaCountry(1);
        cadastroPage.preencheTelefone("981860936");
        cadastroPage.preencheReferencia("Portao Amarelo");

    }

    @Quando("^clico em registrar$")
    public void clico_em_registrar() {
        cadastroPage.clicaRegistro();
    }

    @Então("^vejo cadastro realizado com sucesso$")
    public void vejo_cadastro_realizado_com_sucesso() {
        cadastroPage.validaCadastro();
    }
}
