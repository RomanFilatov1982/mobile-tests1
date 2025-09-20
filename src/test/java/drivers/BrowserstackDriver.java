package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileConfig;
import config.UserConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    private final UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());
    private final MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", UserConfig.user);
        caps.setCapability("browserstack.key", UserConfig.key);

        // Set URL of the application under test
        caps.setCapability("app", UserConfig.appName);

        // Specify device and os_version for testing
        caps.setCapability("device", MobileConfig.device);
        caps.setCapability("os_version", MobileConfig.osVersion);

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(userConfig.remoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
