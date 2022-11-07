package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.MessagePage;
import runner.RunCucumberTest;

public class MessageSteps extends RunCucumberTest {

    MessagePage messagePage = new MessagePage();

    @Dado("^que estou na tela de contato$")
    public void que_estou_na_tela_de_contato() {
        messagePage.acessarMessagePage();
    }

    @Dado("^preencho todos os campo$")
    public void preencho_todos_os_campo() {
        messagePage.fill_message("Minha internet está oscilando bastante, dificultando meu trabalho");
        messagePage.select_heading("Customer service");
        messagePage.fill_email("thiago.lyon.passos@gmail.com");
        messagePage.fill_order("Minha internet ta lenta");
        messagePage.uploadFile("C:\\Users\\User\\Documents\\00. Cursos\\08. Automação de Testes - Praticando\\praticando-selenium-webdriver-java\\upload.jpg");
    }

    @Quando("^eu clico em enviar mensagem$")
    public void eu_clico_em_enviar_mensagem() {
        messagePage.submitMessage();
    }

    @Então("^vejo confirmação de mensagem enviada com sucesso$")
    public void vejo_confirmação_de_mensagem_enviada_com_sucesso() {
        messagePage.validatedSubmitMessage();
    }
}
