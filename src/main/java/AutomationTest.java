import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AutomationTest {

    public static void main(String[] args){
        try{

            WebDriver driver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver","/Users/shverma/Documents/Java-Workspace/VinSolDemoTest/chromedriver");
            JavascriptExecutor js = (JavascriptExecutor) driver;

            //Action 1
            driver.get("https://prep4-frontend.snackmagic.com/");

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //Action 2
            driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();

            //Action 3
            driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test1@vinsol.com");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
            driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
            String loginName = driver.findElement(By.xpath("//header/div[2]/div[3]/div[1]/div[1]/div[1]")).getText();
            Assert.assertEquals(loginName,"test");

            String startOrder = driver.findElement(By.xpath("//p[contains(text(),'Start an Order')]")).getText();
            Assert.assertEquals(startOrder,"START AN ORDER");

            //Action 4
            driver.findElement(By.xpath("//p[contains(text(),'Start an Order')]")).click();
            String treatFor = driver.findElement(By.xpath("//div[contains(text(),\"Who's the treat for?\")]")).getText();
            Assert.assertEquals(treatFor,"Who's the treat for?");
            boolean nextButtonDisabled = driver.findElement(By.xpath("//a[@class='button  btn btn-block button-program-green text-uppercase fs-1 font-weight-bold p-0 disabled']")).isDisplayed();
            Assert.assertTrue(nextButtonDisabled);

            //Action 5
            driver.findElement(By.xpath("//label[@for=\"giftOrderType-team\"]")).click();
            boolean nextButton = driver.findElement(By.xpath("//a[@class='button  btn btn-block button-program-green text-uppercase fs-1 font-weight-bold p-0 ']")).isDisplayed();
            Assert.assertTrue(nextButton);

            //Action 6
            driver.findElement(By.xpath("//span[@class=\"text\" and contains(text(),\"Next\")]")).click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://prep4-frontend.snackmagic.com/orders/create?giftType=team");
            boolean buildButton = driver.findElement(By.xpath("//div[contains(text(),'Build-their-own')]")).isDisplayed();
            Assert.assertTrue(buildButton);
            boolean curatedButton = driver.findElement(By.xpath("//div[contains(text(),'Curated Box')]")).isDisplayed();
            Assert.assertTrue(curatedButton);
            boolean nextButtonDisabled2 = driver.findElement(By.xpath("//a[@class='button text-uppercase p-0 ls-3 font-weight-bold ml-auto button-program-green disabled']")).isDisplayed();
            Assert.assertTrue(nextButtonDisabled2);

            //Action 7
            driver.findElement(By.xpath("//label[@for='curation-recipient']")).click();
            boolean nextButton2 = driver.findElement(By.xpath("//a[@class='button text-uppercase p-0 ls-3 font-weight-bold ml-auto button-program-green btn-success']")).isDisplayed();
            Assert.assertTrue(nextButton2);
            driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

            //Action 8
            driver.findElement(By.xpath("//a[@class='button text-uppercase p-0 ls-3 font-weight-bold ml-auto button-program-green btn-success']")).click();
            boolean budgetText = driver.findElement(By.xpath("//div[contains(text(),\"What's the snack budget per person?\")]")).isDisplayed();
            Assert.assertTrue(budgetText);
            boolean budget45 = driver.findElement(By.xpath("//label[@for='budget-item-45']")).isDisplayed();
            Assert.assertTrue(budget45);
            boolean budget60 = driver.findElement(By.xpath("//label[@for='budget-item-60']")).isDisplayed();
            Assert.assertTrue(budget60);
            boolean budget99 = driver.findElement(By.xpath("//label[@for='budget-item-99']")).isDisplayed();
            Assert.assertTrue(budget99);
            boolean budgetCustom = driver.findElement(By.xpath("//label[@for='budget-item-custom']")).isDisplayed();
            Assert.assertTrue(budgetCustom);

            //Action 9
            driver.findElement(By.xpath("//label[@for='budget-item-45']")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
            boolean recipientSection = driver.findElement(By.xpath("//span[contains(text(),'Recipients')]")).isDisplayed();
            Assert.assertTrue(recipientSection);

            //Action 10
            WebElement button1 = driver.findElement(By.xpath("//div[contains(text(),'I will approve')]"));
            js.executeScript("arguments[0].scrollIntoView();", button1);
            button1.click();
            boolean estimatedRecipients = driver.findElement(By.xpath("//input[@name='expectedCount']")).isDisplayed();
            Assert.assertTrue(estimatedRecipients);

            //Action 11
            driver.findElement(By.xpath("//input[@name='expectedCount']")).sendKeys("10");
            driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
            boolean internationalRecipient = driver.findElement(By.xpath("//span[contains(text(),'International')]")).isDisplayed();
            Assert.assertTrue(internationalRecipient);

            //Action 12
            driver.findElement(By.xpath("//label[@for='hasNonUsRecipients-no']")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
            boolean messageSection = driver.findElement(By.xpath("//span[@class='link-text mr-2' and contains(text(),'Message')]")).isDisplayed();
            Assert.assertTrue(messageSection);

            //Action 13
            driver.findElement(By.xpath("//input[@id='senderName']")).sendKeys("Test");
            driver.findElement(By.xpath("//textarea[@name='inviteMessage']")).sendKeys("Test");
            WebElement button2 = driver.findElement(By.xpath("//div[contains(text(),'Immediately')]"));
            js.executeScript("arguments[0].scrollIntoView();", button2);
            button2.click();
            driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
            boolean boxArrivalDate = driver.findElement(By.xpath("//span[contains(text(),'Box Arrival Date')]")).isDisplayed();
            Assert.assertTrue(boxArrivalDate);

            //Action 14
            driver.findElement(By.xpath("//div[contains(text(),'ASAP')]")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
            boolean boxCustom = driver.findElement(By.xpath("//span[contains(text(),'Box Customization')]")).isDisplayed();
            Assert.assertTrue(boxCustom);

            //Action 15
            driver.findElement(By.xpath("//img[@alt='standard']")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
            boolean brandedDigiEdi = driver.findElement(By.xpath("//span[contains(text(),'Branded Digital Experience')]")).isDisplayed();
            Assert.assertTrue(brandedDigiEdi);

            //Action 16
            driver.findElement(By.xpath("//div[contains(text(),'No, thank you')]")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
            boolean addSwag = driver.findElement(By.xpath("//span[contains(text(),'Add Swag')]")).isDisplayed();
            Assert.assertTrue(addSwag);

            //Action 17
            driver.findElement(By.xpath("//div[contains(text(),'ll pass')]")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
            boolean payment = driver.findElement(By.xpath("//span[contains(text(),'Payment')]")).isDisplayed();
            Assert.assertTrue(payment);

            //Action 18
            driver.findElement(By.xpath("//div[contains(text(),'qwe')]")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
            boolean expiration = driver.findElement(By.xpath("//span[contains(text(),'Expiration')]")).isDisplayed();
            Assert.assertTrue(expiration);
            boolean snackWallet = driver.findElement(By.xpath("//div[contains(text(),'Snack Wallet')]")).isEnabled();
            Assert.assertTrue(snackWallet);

            //Action 19
            driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
            boolean reviewOrder = driver.findElement(By.xpath("//div[contains(text(),'Review your order')]")).isDisplayed();
            Assert.assertTrue(reviewOrder);

            //Action 20
            driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            boolean hooray = driver.findElement(By.xpath("//div[contains(text(),'Hooray!')]")).isDisplayed();
            boolean orderPlaced = driver.findElement(By.xpath("//div[contains(text(),'Your order')]")).isDisplayed();
            Assert.assertTrue(hooray);
            Assert.assertTrue(orderPlaced);
            System.out.println("Automation of order placing is successful!");

            driver.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
