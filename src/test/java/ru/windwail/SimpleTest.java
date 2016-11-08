package ru.windwail;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by icetusk on 08.11.16.
 */
public class SimpleTest {

    private WebDriver driver = null;

    @Test
    public void setup() throws Exception {
        SelendroidConfiguration config = new SelendroidConfiguration();
        // Add the selendroid-test-app to the standalone server
        config.addSupportedApp("src/main/resources/com.tinder_6.4.1-1935.apk");
        SelendroidLauncher selendroidServer = new SelendroidLauncher(config);
        selendroidServer.launchSelendroid();

        SelendroidCapabilities caps = new SelendroidCapabilities("com.tinder:6.4.1");
        driver = new SelendroidDriver(caps);

        driver.findElement(By.id("real_facebook_login_button")).click();

        while(true) {
            Thread.sleep(10000);
        }


    }

}


