package Test;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Constants.Constants.*;
import static org.junit.Assert.assertEquals;

public class StepImplementation extends BaseTest {

    WebDriverWait wait = new WebDriverWait(appiumDriver, 60);

    @Step("Giriş Yap butonuna Tıklandı")
    public void loginClick() {

        wait.until(ExpectedConditions.elementToBeClickable(By.id(ALLOW_BTN))).click();
    }

    @Step("Cookie kapatıldı")
    public void notifAccept() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(NOTIFY))).click();
    }


    @Step("Üye No kutusuna <key> yazıldı")
    public void accountNoWrite(String key) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(UYE_NO))).sendKeys(key);
    }

    @Step("Şifre kutusuna basma")
    public void passwordFieldClick() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PASSWORD_FIELD))).click();
    }

    @Step("Şifre Kutusuna <key> yazıldı")
    public void passwordWrite(String key) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(TYPE_PASSWORD))).sendKeys(key);
    }

    @Step("Giriş yap Butonuna Tıkla")
    public void signInClick() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGIN))).click();
    }
    @Step("Parmak İzi İzin")
    public void footPrint() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(PARMAKIZI_IZIN))).click();
    }

   @Step("Check User")
   public void userlogin() throws InterruptedException {
       Thread.sleep(4000);
       wait.until(ExpectedConditions.elementToBeClickable(By.id(USERNAME_FIELD)));
       String username =appiumDriver.findElement(By.id(USERNAME_FIELD)).getText();
       if(!username.equals("Satuk Buğra"))
       {
           System.out.println("User Giris Yapmadi");
       }
       else {
           System.out.println("User Giris yapti");
       }
    }

    @Step("Tüm sporlar Butonuna tıklandı")
    public void allSports(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id(ALLSPORTS))).click();
    }
    @Step("Voleybol Seçildi")
    public void volleyball(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VOOLEYBALL))).click();
    }

    @Step("Bahis Eventi Seçildi")
    public void betEvent(){

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BET_EVENT))).click();
        String betSlipContainer = appiumDriver.findElement(By.xpath(BET_SLIP_CONTAINER)).getText();
        if(betSlipContainer.equals("0 Maç")){
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BET_EVENT_2))).click();
            System.out.println("Ilk Secenek oynanabilir Degil. MS1 Secildi");
        }else {
            System.out.println("MS2 Secildi");
        }
    }
    @Step("Bet Kontrol")
    public void ecoFligt(){
        //wait.until(ExpectedConditions.elementToBeClickable(By.id(BET_EVENT)));
        String betName =appiumDriver.findElement(By.xpath(BET_NAME)).getText();
        System.out.println("Secilen Macin Ev Sahibi " + betName);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BETSLIP))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_BUTTON)));

        String betTitle = appiumDriver.findElement(By.xpath(BETTITLE)).getText();

        if(!betTitle.contains(betName))
        {
            System.out.println("Bet Secilmedi");
        }
        else {
            System.out.println("Bet Secildi " + betTitle);
        }

    }
    @Step("Tamama bas")
    public void done() throws InterruptedException {
    wait.until(ExpectedConditions.elementToBeClickable(By.id(BETSLIP))).click();
    Thread.sleep(2000);
    }
}