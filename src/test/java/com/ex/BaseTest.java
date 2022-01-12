package com.ex;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static WebDriver webDriver;

    @BeforeClass
    public void initWebDriver() {
        String browser = System.getProperty("browser");
        switch (browser) {
            case "chrome":
                webDriver = DriverInit.getWebDriver(DriverInit.Browser.CHROME);
                break;
            case "firefox":
                webDriver = DriverInit.getWebDriver(DriverInit.Browser.FF);
            default:
                System.err.println("You have 2 choose from chrome or ff");
        }

    }

    @AfterClass
    public void closeWebDriver() {
        webDriver.close();
    }
}
