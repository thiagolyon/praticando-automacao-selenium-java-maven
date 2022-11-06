package pages;

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


}
