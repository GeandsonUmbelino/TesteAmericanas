package teste;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

//O JUnit  fazer o controle dos testes, verifica se o teste passou 
public class TesteBasicoJUnit {

	
	// Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver.
    private static WebDriver driver;
 
    // Método que inicia tudo que for necessário para o teste
    // Cria uma instância do navegador e abre a página.
    @BeforeClass
    public static void setUpTest(){
    	System.setProperty("webdriver.chrome.driver","C:\\Desafio\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://minhaconta.globo.com/");
    }
 
    // Método que finaliza o teste, fechando a instância do WebDriver.    
    @AfterClass
    public static void tearDownTest(){
        driver.quit();
    }
 
    // Testa título "Login".
    @Test
    public void testaTituloDaPagina(){
        assertEquals("Login", driver.getTitle());
    }
 
    // Método que testa o login.
    @Test
    public void testaLogin() {
 
    // Instancia um novo objeto do tipo "WebElement", e passa como parâmetro
    // um elemento da tela cujo valor do atributo "name" seja igual a "login".
    WebElement element = driver.findElement(By.name("login"));
     
    // Insere dados no elemento "usuario".
    element.sendKeys("TESTE");
 
    // Atribui ao objeto “element” o elemento de atributo "name" igual a "password".
    element = driver.findElement(By.name("password"));
 
    // Insere dados no elemento "senha".
    element.sendKeys("TESTE");
 
    }
}

}
