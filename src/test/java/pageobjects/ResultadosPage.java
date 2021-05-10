package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultadosPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public ResultadosPage(WebDriver browser) {
        driver = browser;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(css = "a[title='List']")
    private WebElement btnLista;

    @FindBy(css = "div[class='right-block col-xs-4 col-xs-12 col-md-4'] span[itemprop='price']")
    private WebElement lblPrecio;

    //Methods
    public void clickLista() {
        wait.until(ExpectedConditions.visibilityOf(btnLista));
        btnLista.click();
    }

    public String obtenerPrecio() {
        wait.until(ExpectedConditions.visibilityOf(lblPrecio));
        return lblPrecio.getText();
    }
}
