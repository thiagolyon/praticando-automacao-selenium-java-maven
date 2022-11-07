package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import runner.RunCucumberTest;
import support.Utils;

public class MessagePage extends RunCucumberTest {

    private By select_heading = By.id("id_contact");
    private By email_field = By.id("email");
    private By order_field = By.id("id_order");
    private By upload_field = By.id("fileUpload");
    private By message_field = By.id("message");
    private By submit_message = By.id("submitMessage");
    private By validated_message = By.cssSelector("#center_column > ul > li > a");

    public void acessarMessagePage() {
        getDriver().get("http://automationpractice.com/index.php?controller=contact");
        Utils.waitElementBePresent(email_field, 20);
    }


    public void select_heading(String assunto) {
        Select seleciona_assunto = new Select(getDriver().findElement(select_heading));
        seleciona_assunto.selectByVisibleText(assunto);
    }

    public void fill_email(String email) {
        getDriver().findElement(email_field).sendKeys(email);
    }

    public void fill_order(String pedido) {
        getDriver().findElement(order_field).sendKeys(pedido);
    }

    public void fill_message(String mensagem) {
        getDriver().findElement(message_field).sendKeys(mensagem);
    }

    public void uploadFile(String pathFile) {
        getDriver().findElement(upload_field).sendKeys(pathFile);
    }

    public void submitMessage() {
        getDriver().findElement(submit_message).click();
    }

    public void validatedSubmitMessage() {
        Utils.waitElementBePresent(validated_message, 20);
        String result = getDriver().findElement(By.className("alert-success")).getText();
        Assert.assertEquals("Your message has been successfully sent to our team.", result);
    }

}


