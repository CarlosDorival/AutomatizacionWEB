package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusquedaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public BusquedaPage(WebDriver browser) {
        driver = browser;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(css = "input[name='search_query']")
    private WebElement txtBusqueda;

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement btnBusqueda;

    //Methods
    public void escribirTexo(String termino) {
        wait.until(ExpectedConditions.visibilityOf(txtBusqueda));
        txtBusqueda.sendKeys(termino);
    }

    public void clickBusqueda() {
        wait.until(ExpectedConditions.visibilityOf(btnBusqueda));
        btnBusqueda.click();
    }
}
