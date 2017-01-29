package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlanTripPage {
    private final WebDriver driver;
    private final By fromTextBoxSelection = By.xpath("//*[@id=\"panel-context-view\"]/div/form/div[1]/table/tbody/tr[1]/td[2]/input");
    private final By toTextBoxSelection = By.xpath("//*[@id=\"panel-context-view\"]/div/form/div[1]/table/tbody/tr[2]/td[2]/input");
    private final By searchButtonSelection = By.xpath("//*[@id=\"panel-context-view\"]/div/form/div[4]/input");

    public PlanTripPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://futar.bkk.hu");
    }

    public void addTrip(String from, String to) {
        addSource(from);
        addDestination(to);
    }

    private void addSource(String from) {
        WebElement sourceBox = this.driver.findElement(this.fromTextBoxSelection);
        sourceBox.clear();
        sourceBox.sendKeys(from);
    }

    private void addDestination(String to) {
        WebElement destinationBox = this.driver.findElement(this.toTextBoxSelection);
        destinationBox.clear();
        destinationBox.sendKeys(to);
        destinationBox.sendKeys(Keys.RETURN);
    }

    public void search() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement serachButton = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement serachButton = driver.findElement(searchButtonSelection);
                if (serachButton.getText().length() != 0) {
                    return serachButton;
                } else {
                    return null;
                }
            }
        });
        serachButton.click();
    }
}
