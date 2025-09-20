package config;

import io.appium.java_client.internal.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:user.properties"
})
public class UserConfig extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("appName")
    String appName();
}
