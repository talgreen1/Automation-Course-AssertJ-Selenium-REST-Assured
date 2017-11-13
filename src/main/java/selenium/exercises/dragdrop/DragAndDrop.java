package selenium.exercises.dragdrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DragAndDrop {

    private static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException {

        createRemoteWebDriver();

        driver.get("http://demoqa.com/droppable/");

        //Locate element which you wants to drag.
        WebElement dragElementFrom = driver.findElement(By.id("draggableview"));
        //Locate element where you wants to drop.
        WebElement dropElementTo = driver.findElement(By.id("droppableview"));

        //Use Actions class and Its members of WebDriver API to perform drag and drop operation.
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(dragElementFrom)
                .moveToElement(dropElementTo)
                .release(dropElementTo)
                .build();
        dragAndDrop.perform();


    }


    private static void createRemoteWebDriver() throws MalformedURLException {
        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());


    }
}
