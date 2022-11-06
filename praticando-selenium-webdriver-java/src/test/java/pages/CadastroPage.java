package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import support.Utils;

public class CadastroPage extends Utils {

        WebDriver driver;

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

        public CadastroPage(WebDriver driver) {
            this.driver = driver;
        }

        public void selectTitle(Integer type) {
            waitElementBePresent(titleM, 20);
            waitElementBePresent(titleF, 20);

            if(type == 1) {
                driver.findElement(titleM).click();
            }else if(type ==2) {
                driver.findElement(titleF).click();
            }
        }

        public void preencheNome(String name) {
            driver.findElement(first_name_field).sendKeys(name);
        }

        public void preencheSobrenome(String sobremenome) {
            driver.findElement(last_name_field).sendKeys(sobremenome);
        }

        public void preenchePassword(String password) {
            driver.findElement(password_field).sendKeys(password);
        }

        public void selecionaNascimento(Integer day, Integer months, String years) {
            Select select_day = new Select(driver.findElement(select_day_field));
            select_day.selectByIndex(day);

            Select select_months = new Select(driver.findElement(select_months_field));
            select_months.selectByIndex(months);

            Select select_years = new Select(driver.findElement(select_years_field));
            select_years.selectByValue(years);
        }

        public void preencheAddress(String address) {
            driver.findElement(address_field).sendKeys(address);
        }

        public void preencheCity(String city) {
            driver.findElement(city_field).sendKeys(city);
        };

        public void selecionaEstado(String state) {
            Select select_state = new Select(driver.findElement(select_state_field));
            select_state.selectByVisibleText(state);
        }

        public void preenchePostcode(String postcode) {
            driver.findElement(postcode_field).sendKeys(postcode);
        }

        public void selecionaCountry(Integer country) {
            Select select_county = new Select(driver.findElement(select_country_field));
            select_county.selectByIndex(country);
        }

        public void preencheTelefone(String mobile) {
            driver.findElement(mobile_field).sendKeys(mobile);
        }

        public void preencheReferencia(String alias) {
            driver.findElement(alias_field).sendKeys(alias);
        }

        public void clicaRegistro() {
            driver.findElement(submit_button).click();
        }

        public void validaCadastro() {
            waitElementBePresent(By.className("button-search"), 20);
            String resultado_atual = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span")).getText();
            Assert.assertEquals("Thiago Lyon Nascimento", resultado_atual);
        }

}
