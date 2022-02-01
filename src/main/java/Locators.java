import org.openqa.selenium.By;

public class Locators {


    //Media Page locator
    public static final By LINK_MEDIA= By.cssSelector("a[href='https://romanceabroad.com/media/index']");
    //public static means you can use anywhere in the project
    //final means that you can change the locator only in this class
    // upper case - because it is final= constanta - Java standard

    //Registration
    public static final By BUTTON_REGISTRATION= By.xpath("//button[@id='show-registration-block']");
    public static final By TEXT_FIELD_EMAIL= By.cssSelector("input#email");
    public static final By TEXT_FIELD_PASSWORD =By.cssSelector("input#password");
    public static final By NEXT_BUTTON= By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TEXT_FIELD_NICKNAME= By.cssSelector("#nickname");
    public static final By TEXT_FIELD_PHONE_NUMBER = By.cssSelector("input[name='data[phone]']");

    //Sign In
    public static final By LINK_SIGN_IN = By.xpath("//a[@href='https://romanceabroad.com/users/login_form']");


    // Search page
    public static final By LINK_SEARCH= By.xpath("//a[@href='https://romanceabroad.com/users/search']");


}
