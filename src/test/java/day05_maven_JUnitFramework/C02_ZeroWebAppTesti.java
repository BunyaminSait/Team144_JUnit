package day05_maven_JUnitFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_ZeroWebAppTesti {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']"))
                .click();
        //3. Login alanine  “username” yazdirin
        WebElement login=driver.findElement(By.xpath("//input[@name='user_login']"));
        login.sendKeys("username");
        //4. Password alanina “password” yazdirin
        WebElement password=driver.findElement(By.xpath("//input[@name='user_password']"));
        password.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']"))
                .click();
        //6. Back tusu ile sayfaya donun
        driver.navigate().back();
        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id=\"onlineBankingMenu\"]/div/strong"))
                .click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']"))
                .click();
        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount=driver.findElement(By.xpath("//input[@name='amount']"));
        amount.sendKeys("500");
        //9. tarih kismina “2023-09-10” yazdirin
        WebElement date=driver.findElement(By.xpath("//input[@id='sp_date']"));
        date.sendKeys("2023-09-10");
        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees"))
                .click();
        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement mesaj=driver.findElement(By.id("alert_content"));
        String expectedMesaj = "The payment was successfully submitted.";
        String actualMesaj = mesaj.getText();

        if (expectedMesaj.equals(actualMesaj)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        driver.quit();

    }
}
