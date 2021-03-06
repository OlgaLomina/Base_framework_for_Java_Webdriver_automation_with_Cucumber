package utils;


import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;
import static utils.TestContext.*;

public class Hooks {

    @Before(order = 0)
    public void scenarioStart() {
        TestContext.initialize();
        TestContext.setTimestamp();
        getDriver().manage().timeouts().pageLoadTimeout(getConfig().pageLoadTimeout, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(getConfig().implicitTimeout, TimeUnit.SECONDS);
        getDriver().manage().deleteAllCookies();
    }

//    @After(order = 0)
//    public void scenarioEnd(Scenario scenario) {
//        if (scenario.isFailed()) {
//            TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
//            byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", "Screenshot");
//        }
//        TestContext.teardown();
//    }
}
