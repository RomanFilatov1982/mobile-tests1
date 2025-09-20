package config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${platform}.properties"
})
public class MobileConfig extends Config {
    @Key("device")
    String device;

    @Key("osVersion")
    String osVersion;
}
