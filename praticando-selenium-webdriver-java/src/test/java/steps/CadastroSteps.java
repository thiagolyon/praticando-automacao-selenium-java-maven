package steps;

import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.CadastroPage;
import runner.RunCucumberTest;

public class CadastroSteps extends RunCucumberTest {

    CadastroPage cadastroPage = new CadastroPage(driver);

    @Quando("^eu preencho o formulário de cadastro$")
    public void eu_preencho_o_formulário_de_cadastro() {
        cadastroPage.selectTitle(1);
        cadastroPage.preencheNome("Thiago Lyon");
        cadastroPage.preencheSobrenome("Nascimento");
        cadastroPage.preenchePassword("ABc@123");
        cadastroPage.selecionaNascimento(01, 04, "1989");
    }

    @Quando("^clico em registrar$")
    public void clico_em_registrar() {

    }

    @Então("^vejo a mensagem de cadastro realizado com sucesso$")
    public void vejo_a_mensagem_de_cadastro_realizado_com_sucesso() {

    }
}
