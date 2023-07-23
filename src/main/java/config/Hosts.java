package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:env",
        "system:properties",
        "file:src/test/resources/config.properties"
})
public interface Hosts extends Config {
    @Key("url.mainHost")
    String mainUrl();
}
