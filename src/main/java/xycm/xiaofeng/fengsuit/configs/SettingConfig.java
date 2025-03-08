package xycm.xiaofeng.fengsuit.configs;


import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

/**
 * @author Frain
 */
public class SettingConfig {

    private final List<String> slots;

    public SettingConfig(YamlConfiguration config) {
        slots = config.getStringList("Slots");
    }

    public List<String> getSlots() {
        return slots;
    }
}
