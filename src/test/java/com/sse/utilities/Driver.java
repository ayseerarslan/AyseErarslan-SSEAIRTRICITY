package com.sse.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    static String browser;

    private Driver() {
    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            if (System.getProperty("BROWSER") == null) {
                browser = ConfigurationReader.getProperty("browser");
            } else {
                browser = System.getProperty("BROWSER");
            }
            System.out.println("Browser: " + browser);

            switch (browser) {
                case "remote-chrome":
                    try {
                        String gridAddress = "";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities)); ;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;

            }
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }

        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}



