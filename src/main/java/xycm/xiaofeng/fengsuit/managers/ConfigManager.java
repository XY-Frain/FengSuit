package xycm.xiaofeng.fengsuit.managers;

import org.bukkit.configuration.file.YamlConfiguration;
import xycm.xiaofeng.fengsuit.FengSuit;
import xycm.xiaofeng.fengsuit.configs.SettingConfig;
import xycm.xiaofeng.fengsuit.configs.SuitConfig;
import xycm.xiaofeng.fengsuit.utils.Yaml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Frain
 */
public class ConfigManager {
    private static File settingFile;
    private static YamlConfiguration settingConfig;
    private static SettingConfig settingConfigContent;

    private static List<File> suitFiles;
    private static List<YamlConfiguration> suitConfigs;
    private static List<SuitConfig> suitConfigContents;

    /**
     * 保存所有配置文件到插件文件夹中
     */
    public static void saveConfig() {
        // 保存setting文件(主配置)
        Yaml.saveYamlConfig(FengSuit.getInstance(), "setting");
        // 保存Suits/example文件
        File suits = new File(FengSuit.getInstance().getDataFolder(), "Suits");
        if (!suits.exists() || Objects.requireNonNull(suits.list()).length == 0) {
            Yaml.saveYamlConfig(FengSuit.getInstance(), "Suits/example");
        }
    }

    /**
     * 加载所有配置文件成file类
     */
    public static void loadConfig() {
        // 加载setting文件(主配置)
        settingFile = Yaml.loadYamlConfig(FengSuit.getInstance(), "setting");
        // 加载Suits文件夹下的所有文件
        suitFiles = Yaml.loadMoreYamlConfig(FengSuit.getInstance(), "Suits");
    }

    /**
     * 读取所有配置文件成YamlConfiguration类
     */
    public static void readConfig() {
        // 读取setting文件(主配置)
        settingConfig = Yaml.readYamlConfig(FengSuit.getInstance(), settingFile);
        // 读取suits文件
        suitConfigs = Yaml.readMoreYamlConfig(FengSuit.getInstance(), suitFiles);
    }


    /**
     * 将所有配置文件进行保存/加载/读取
     */
    public static void saveLoadReadAllConfig() {
        saveConfig(); // 保存所有配置文件到插件文件夹
        loadConfig(); // 加载所有配置文件到游戏
        readConfig(); // 读取所有配置信息文件到游戏

        // 读取setting文件的内容(主配置)
        settingConfigContent = new SettingConfig(settingConfig);
        // 读取所有Suits文件夹下所有文件的内容
        suitConfigContents = new ArrayList<>();
        for (YamlConfiguration suitConfig : suitConfigs) {
            suitConfigContents.add(new SuitConfig(suitConfig));
        }
    }

    public static SettingConfig getSettingConfigContent() {
        return settingConfigContent;
    }

    public static List<SuitConfig> getSuitConfigContents() {
        return suitConfigContents;
    }
}
