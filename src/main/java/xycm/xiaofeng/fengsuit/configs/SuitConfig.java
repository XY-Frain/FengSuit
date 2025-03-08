package xycm.xiaofeng.fengsuit.configs;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

/**
 * @author Frain
 */
public class SuitConfig {

    private final String name;
    private final List<String> detection;

    public SuitConfig(YamlConfiguration config) {
        this.name = config.getString("Name");
        this.detection = config.getStringList("Detection");
    }

    public String getName() {
        return name;
    }

    public List<String> getDetection() {
        return detection;
    }
}
