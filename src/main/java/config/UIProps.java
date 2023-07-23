package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:env",
        "system:properties",
        "file:src/test/resources/config.properties"
})
public interface UIProps extends Config {
    @Key("ui.browser")
    String browserType();
}
