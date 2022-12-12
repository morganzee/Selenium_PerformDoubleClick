package DoubleClock;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class PerformDoubleClick {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        String browser = "CHROME";

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Documents\\Selenium Webdriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Documents\\Selenium Webdriver\\chromedriver.exe");
            driver = new EdgeDriver();
        }
        //This url is used for a prompt
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        //get browser title
        String getTitle = driver.getTitle();
        System.out.println("Page Title :" + getTitle);

        WebElement btn = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        //Actions class is a built-in feature that assist keyboard and mouse events
        Actions builder = new Actions(driver);

        //What this does is to make sure the right web element is clicked, it does the double click
        builder.doubleClick(btn).build().perform();

        Thread.sleep(3000);

        //This is to capture the alert when the copy is click on after the right click
        Alert alert = driver.switchTo().alert();
        //Actual value
        String alertText = alert.getText();
        //Expected value
        if(alertText.equals("You double clicked me.. Thank You..")){
            System.out.println("Double click was successful");
        }else{
            System.out.println("Double click was unsuccessful");
        }

        //This would click on the Ok button
        alert.accept();
        //Close browser
        driver.quit();
    }
}
