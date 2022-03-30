package com.gavura.ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonWebDriver {
    private static WebDriver webDriver;

    private SingletonWebDriver() {
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            WebDriverManager.chromedriver()
                    .browserVersion("latest")
                    .setup();
            webDriver = new ChromeDriver();
            webDriver.manage()
                    .window()
                    .maximize();
        }

        return webDriver;
    }

    public static void closeWebDriver() {
        webDriver.close();
        webDriver.quit();
        webDriver = null;
    }
}
