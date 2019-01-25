import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class GiphyTest {

    public WebDriver webDriver;

    public String giphyURL = "https://giphy.com/";

    public String email = "ferit.dra2018@gmail.com";
    public String password = "TEST2018";


    @BeforeMethod
    public void setupTest() {

        System.setProperty("webdriver.chrome.driver", "C:\\Testiranje\\chromedriver.exe");

        webDriver = new ChromeDriver();

        webDriver.navigate().to(giphyURL);
    }

    @Test
    public void loginFail() throws  InterruptedException {
        WebElement loginBox = webDriver.findElement(By.xpath("//a[@id='login-button']/span[@class='nav-text']"));
        loginBox.click();
        Thread.sleep(2000);
        WebElement emailBox = webDriver.findElement(By.xpath("/html//div[@id='react-target']/div[@class='container__Container-cn7xfa-0 cwPCpD']//form[@action='/login']//input[@name='email']"));
        emailBox.sendKeys("email@email.email");
        Thread.sleep(1000);
        WebElement passwordBox = webDriver.findElement(By.xpath("/html//div[@id='react-target']/div[@class='container__Container-cn7xfa-0 cwPCpD']//form[@action='/login']//input[@name='password']"));
        passwordBox.sendKeys("neMoiRaditi");
        Thread.sleep(1000);
        WebElement loginButton = webDriver.findElement(By.xpath("/html//div[@id='react-target']//form[@action='/login']//button[.='Log in']"));
        loginButton.click();
    }

    @Test
    public void loginSuccess() throws  InterruptedException {
        WebElement loginBox = webDriver.findElement(By.xpath("//a[@id='login-button']/span[@class='nav-text']"));
        loginBox.click();
        Thread.sleep(2000);
        WebElement emailBox = webDriver.findElement(By.xpath("/html//div[@id='react-target']/div[@class='container__Container-cn7xfa-0 cwPCpD']//form[@action='/login']//input[@name='email']"));
        emailBox.sendKeys(email);
        Thread.sleep(1000);
        WebElement passwordBox = webDriver.findElement(By.xpath("/html//div[@id='react-target']/div[@class='container__Container-cn7xfa-0 cwPCpD']//form[@action='/login']//input[@name='password']"));
        passwordBox.sendKeys(password);
        Thread.sleep(1000);
        WebElement loginButton = webDriver.findElement(By.xpath("/html//div[@id='react-target']//form[@action='/login']//button[.='Log in']"));
        loginButton.click();
        webDriver.navigate().to(giphyURL);
        Thread.sleep(2000);
    }

    @Test void search() throws InterruptedException {
        loginSuccess();
        WebElement searchBar = webDriver.findElement(By.xpath("/html//input[@id='search-box']"));
        searchBar.sendKeys("Wood");
        searchBar.sendKeys("\n");
        Thread.sleep(2000);
        WebElement gifClick = webDriver.findElement(By.xpath("/html//div[@id='gif-results']//div[@class='_container_1pgnh_4']/div[2]/div[1]"));
        gifClick.click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html//div[@id='gif-results']//div[@class='_2vK2p_vlHej9PMLWlG644r']//div[@class='_14glt1AeSjnOdEg6jPXf4y']/div[1]/div")).click();
        Thread.sleep(2000);
    }

    @Test void slideRight() throws InterruptedException {
        loginSuccess();
        WebElement slideRightBar = webDriver.findElement(By.xpath("//*[@id=\"react-target\"]/div[4]/div[1]/div/div[2]"));
        slideRightBar.click();
        Thread.sleep(2132);
        slideRightBar.click();
        Thread.sleep(645);
        slideRightBar.click();
        Thread.sleep(1123);
    }

    @Test void slideLeft() throws InterruptedException {
        slideRight();
        WebElement slideLeftBar = webDriver.findElement(By.xpath("//*[@id=\"react-target\"]/div[4]/div[1]/div/div[1]"));
        slideLeftBar.click();
        Thread.sleep(645);
        slideLeftBar.click();
        Thread.sleep(1123);

    }

    @Test void logout() throws InterruptedException {
        loginSuccess();
        Thread.sleep(2452);
        WebElement userSettings = webDriver.findElement(By.xpath("//div[@id='header']/div//a[@href='/channel/testiranje2018']/span[@class='_17hY_dW7917mzr2S9Ree']"));
        Actions action = new Actions(webDriver);
        WebElement logout = webDriver.findElement(By.xpath("/html//div[@id='header']/div//ul[@class='KxT1j7Er2gLsZ6krubVjf']//a[@href='/logout']"));
        action.moveToElement(userSettings).build().perform();
        Thread.sleep(2500);
        action.moveToElement(logout).click().build().perform();
    }
}