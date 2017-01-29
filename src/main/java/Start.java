import model.Browser;
import model.DriverFactory;
import org.openqa.selenium.WebDriver;
import pageobject.PlanTripPage;

public class Start {
    public static void main (String[] args) {
        new Start().start();
    }

    private void start() {
        System.out.println("Starting..");
        WebDriver driver = DriverFactory.getDriver(Browser.CHROME);
        try {
            planTrip(driver);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private void planTrip(WebDriver driver) {
        PlanTripPage planTripPage = new PlanTripPage(driver);
        planTripPage.addTrip("Futó utca 47.", "Dorottya utca 2.");

    }


}
