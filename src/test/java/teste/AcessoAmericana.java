package teste;


import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class AcessoAmericana {

	
	// Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver.
    private static WebDriver driver;
 
    // Método que inicia tudo que for necessário para o teste
    // Cria uma instância do navegador e abre a página.
    @BeforeClass
    public static void setUpTest(){
    	System.setProperty("webdriver.chrome.driver","C:\\Desafio\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.americanas.com.br/");
        driver.manage().window().maximize(); //Maximizar a tela
    }
 
    // Método que finaliza o teste, fechando a instância do WebDriver.    
    @AfterClass
    public static void tearDownTest() throws IOException{
    		driver.quit();
    }
 
    // 1- Entre em um grande portal de comércio online (Validação através do getTitle)
    @Test
    public void ateste1(){
        assertEquals("Americanas - Tudo. A toda hora. Em qualquer lugar.", driver.getTitle());
    }
    
    // 2- Faça uma busca por um produto
    @Test
    public void bteste2(){
    	WebElement busca = driver.findElement(By.name("conteudo"));
        busca.sendKeys("notebook");        
        driver.findElement(By.id("h_search-btn")).click();        
        }
    
    //3- Valide o retorno da busca
    @Test
    public void cteste3(){
    	// assertEquals valida se o titulo da pagina é o mesmo  
    	assertEquals("Notebook em Promoção nas Lojas Americanas.com", driver.getTitle());
    }
    
    //4 - Escolha um produto na lista
    @Test
    public void dteste4(){   //cssSelector compara se o produto escolhido é o mesmo selecionado  
    	WebElement produto = driver.findElement(By.cssSelector(".product-grid-item:nth-child(6) .Placeholder-kse9g2-2"));
    	produto.click();        
        }
    
    //5- Adicione o carrinho
   
    
    //6- Valide o produto no carrinho
    
 
}

/*fiz o projeto com Bibliotecas externas 
 * junit, selenium e commons
 *  
 depois tentei colocar as dependencias no maven */
