import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPage {
    // Declare and assign the barriable that you are going to reuse
    // As we want to keep our code clean, and not overload it, in addition to reuse it - it is better. You can put it within the class and outside the test.
    // You use encapsulation
    String mainUrl = "https://romanceabroad.com/";
    //we want driver to be used by other methods as well, so we put it outside the method into the class
    WebDriver driver;
    String currentUrlSearch;
    //We are going to use this locator adn we don't want it to be hardcoded in the test cases, so we put it ouside in the classs.
    //We give to locators capital letter
    By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    By LINK_MEDIA= By.cssSelector("a[href='https://romanceabroad.com/media/index']");
    By LINK_SIGN_IN = By.xpath("//a[@href='https://romanceabroad.com/users/login_form']");
    By BUTTON_REGISTRATION= By.xpath("//button[@id='show-registration-block']");

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(mainUrl);
    }


//TestNg annotation. Marking the method as a test. Imported from the pom.xml. It will be run as a test.
    /* @Test
    public void testMainPage (){
        // Selenium library. To interact with the browser
        WebDriver driver;
        //we need to add driver for any possible browser. If don't have driver, we cannot connect to the browser.
        // Download from Selenium dev the driver version that is compatible with the browser version you have now.
        //Place driver inside the project folder so you don't have to give the path to the driver and mess up with the project if you send it to someone
        //Set up the system properties. Name of the dirver and the path to it.
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        //to make sure the browser is opened in full screen
        driver.manage().window().maximize();
        //opens your mainURL
        driver.get(mainUrl);
        //driver.quit();

    }
    The most popular variables we create in our class
    String name = "Al" - outside
    By BUTTON_SUBMIT ="By.xpath("//a"); - outside
    int number =3; - outside (for loop or marketing webelements as you have counting, indexes)
    WebElement element = driver.findElement(BUTTON_SUBMIT) - inside test case, as outside it is failed.

    */

    @Test
    //public void does not return any data after the metho
    public void testSearchPage (){
        //chrome extension Selenium IDE can help you to record your actions (for new users)
        driver.findElement(LINK_SEARCH).click();
        //String currentUrlSearch = driver.getCurrentUrl(); - declare outside the test case as I want to use outside it as well
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        String expectedUrl = "https://romanceabroad.com/users/search";
        Assert.assertEquals(currentUrlSearch,expectedUrl);
    }
    @Test
    //public void does not return any data after the metho
    public void testMainPage () {
        //chrome extension Selenium IDE can help you to record your actions (for new users)
        driver.findElement(LINK_MEDIA).click();
        //String currentUrlSearch = driver.getCurrentUrl(); - declare outside the test case as I want to use outside it as well
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        String expectedUrl = "romanceabroad.com/media/index";
        Assert.assertEquals(currentUrlSearch, expectedUrl);
    }

        @Test
    public void singnIN (){
        driver.findElements(LINK_SIGN_IN).get(0).click();

    }

    @Test
    public void buttonRegistration (){
        driver.findElement(BUTTON_REGISTRATION).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("qaturbostudent@gmail.com");
        driver.findElement(By.cssSelector("input#password")).sendKeys("QAturbo1234");
        driver.findElement(By.xpath("//button[@data-action='next-page'][text()='Next']")).click();



    }

    @AfterMethod
    public void windowCLose (){
        driver.quit();
    }




}
