package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BusquedaPage;
import pageobjects.ResultadosPage;

public class Principal {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        //Configuramos la ruta del driver
        //Chrome:
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\ChromeDriver.88\\chromedriver.exe");
        //Firefox:
        //System.setProperty("webdriver.firefox.driver", "fullpath");

        //Instanciamos el driver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);

        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void primeraPrueba() {
        BusquedaPage busqueda = new BusquedaPage(driver);
        busqueda.escribirTexo("blouse");
        busqueda.clickBusqueda();

        ResultadosPage resultados = new ResultadosPage(driver);
        resultados.clickLista();

        Assert.assertEquals(resultados.obtenerPrecio(), "$27.00");
    }

    @Test
    public void segundaPrueba() {
        BusquedaPage busqueda = new BusquedaPage(driver);
        busqueda.escribirTexo("skirt");
        busqueda.clickBusqueda();

        ResultadosPage resultados = new ResultadosPage(driver);
        resultados.clickLista();

        Assert.assertEquals(resultados.obtenerPrecio(), "$26.00");
    }

    @AfterMethod
    public void tearDown() {
        //Finalizamos el driver
        driver.quit();
    }
}
