package steps;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CriaContaSteps {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private String nomeGeral;
    private String sobreNomeGeral;

    @Before
    public static void WebDriverChrome(){
        System.setProperty("webdriver.chrome.driver", "c:/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @Dado("^que um usuario está na tela de criação de conta$")
    public void queUmUsuarioEstáNaTelaDeCriaçãoDeConta() throws Throwable {
        driver.get("https://www.dell.com/");
        driver.findElement(By.className("mh-tw-sign-in-wrap")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @Quando("^preenche os campos nome (.*), sobrenome (.*), e-mail (.*), senha (.*)$")
    public void preencheOsCamposNomeSobrenomeEMailSenha(String nome, String sobNome, String email, String senha) throws Throwable {
        nomeGeral = nome;
        sobreNomeGeral = sobNome;
        
        Random random = new Random();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
        driver.findElement(By.id("FirstName")).sendKeys(nomeGeral);
        driver.findElement(By.id("LastName")).sendKeys(sobreNomeGeral);
        driver.findElement(By.id("CreateAccountEmailAddress")).sendKeys(random.nextInt(100)+email);
        driver.findElement(By.id("NewPassword")).sendKeys(senha);
    }

    @Quando("^clica em salvar$")
    public void clicaEmSalvar() throws Throwable {
        driver.findElement(By.id("NewPassword")).sendKeys(Keys.ENTER);
    }

    @Então("^a conta deve ser criada com sucesso$")
    public void aContaDeveSerCriadaComSucesso() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/header/div[1]/div[2]/div[2]/div/button")));
        String s = driver.findElement(By.className("mh-si-button")).getText();
        assertEquals(nomeGeral + " " + sobreNomeGeral, s);
    }

    @Então("^a conta deve ser notificado que a senha é invalida$")
    public void aContaDeveSerNotificadoQueASenhaÉInvalida() throws Throwable {
        assertEquals("Crie uma nova senha de acordo com os critérios para criação de senhas .", driver.findElement(By.
        xpath("/html/body/div[1]/div[3]/div[3]/div/div[2]/div[2]/div/div/form/div/div[1]/div[2]")).getText());
    }

    @After
    public void FechaNavegador(){
        //driver.quit();
    }

}
