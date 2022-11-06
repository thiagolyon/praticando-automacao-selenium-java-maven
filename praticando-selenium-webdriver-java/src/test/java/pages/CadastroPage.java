package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;
import runner.RunCucumberTest;
import support.Utils;

import javax.rmi.CORBA.Util;

public class CadastroPage extends RunCucumberTest {


        private By titleM = By.id("id_gender1");
        private By titleF = By.id("id_gender2");
        private By first_name_field = By.id("customer_firstname");
        private By last_name_field = By.id("customer_lastname");
        private By password_field = By.id("passwd");

        private By select_day_field = By.id("days");
        private By select_months_field = By.id("months");
        private By select_years_field = By.id("years");

        private By address_field = By.id("address1");
        private By city_field = By.id("city");
        private By select_state_field = By.id("id_state");
        private By postcode_field = By.id("postcode");
        private By select_country_field = By.id("id_country");
        private By mobile_field = By.id("phone_mobile");
        private By alias_field = By.id("alias");

        private By submit_button = By.id("submitAccount");

        public void selectTitle(Integer type) {
            Utils.waitElementBePresent(titleM, 20);
            Utils.waitElementBePresent(titleF, 20);

            if(type == 1) {
                getDriver().findElement(titleM).click();
            }else if(type ==2) {
                getDriver().findElement(titleF).click();
            }
        }

        public void preencheNome(String name) {
            getDriver().findElement(first_name_field).sendKeys(name);
        }

        public void preencheSobrenome(String sobremenome) {
            getDriver().findElement(last_name_field).sendKeys(sobremenome);
        }

        public void preenchePassword(String password) {
            getDriver().findElement(password_field).sendKeys(password);
        }

        public void selecionaNascimento(Integer day, Integer months, String years) {
            Select select_day = new Select(getDriver().findElement(select_day_field));
            select_day.selectByIndex(day);

            Select select_months = new Select(getDriver().findElement(select_months_field));
            select_months.selectByIndex(months);

            Select select_years = new Select(getDriver().findElement(select_years_field));
            select_years.selectByValue(years);
        }

        public void preencheAddress(String address) {
            getDriver().findElement(address_field).sendKeys(address);
        }

        public void preencheCity(String city) {
            getDriver().findElement(city_field).sendKeys(city);
        };

        public void selecionaEstado(String state) {
            Select select_state = new Select(getDriver().findElement(select_state_field));
            select_state.selectByVisibleText(state);
        }

        public void preenchePostcode(String postcode) {
            getDriver().findElement(postcode_field).sendKeys(postcode);
        }

        public void selecionaCountry(Integer country) {
            Select select_county = new Select(getDriver().findElement(select_country_field));
            select_county.selectByIndex(country);
        }

        public void preencheTelefone(String mobile) {
            getDriver().findElement(mobile_field).sendKeys(mobile);
        }

        public void preencheReferencia(String alias) {
            getDriver().findElement(alias_field).sendKeys(alias);
        }

        public void clicaRegistro() {
            getDriver().findElement(submit_button).click();
        }

        public void validaCadastro() {
            Utils.waitElementBePresent(By.className("button-search"), 20);
            String resultado_atual = getDriver().findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span")).getText();
            Assert.assertEquals("Thiago Lyon Nascimento", resultado_atual);
        }

}
