import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class Principal {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        //Configuramos la ruta del driver
        //Chrome:
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
        //Firefox:
        //System.setProperty("webdriver.firefox.driver", "fullpath");

        //Instanciamos el driver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);

        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void primeraPrueba() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='search_query']")));
        WebElement txtBuscar = driver.findElement(By.cssSelector("input[name='search_query']"));
        txtBuscar.sendKeys("blouse");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='submit_search']")));
        WebElement btnBuscar = driver.findElement(By.xpath("//button[@name='submit_search']"));
        btnBuscar.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='List']")));
        WebElement btnLista = driver.findElement(By.cssSelector("a[title='List']"));
        btnLista.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='right-block col-xs-4 col-xs-12 col-md-4'] span[itemprop='price']")));
        WebElement lblPrecio = driver.findElement(By.cssSelector("div[class='right-block col-xs-4 col-xs-12 col-md-4'] span[itemprop='price']"));

        Assert.assertEquals(lblPrecio.getText(), "$27.00");



    }

    @AfterMethod
    public void tearDown(ITestResult resultado) {

        if (resultado.getStatus()==ITestResult.FAILURE){

            File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //fileUtil.copyFile(scrFile, new File("C:\\imagenes\\screenshot"+resultado.getName()+".png"));

        }



        //Finalizamos el driver
        driver.quit();
    }
}
