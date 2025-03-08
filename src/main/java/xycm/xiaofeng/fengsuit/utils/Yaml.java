package xycm.xiaofeng.fengsuit.utils;

import com.google.common.base.Charsets;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Frain
 */
public class Yaml {
    /**
     * 保存单个Yaml格式配置文件
     */
    public static void saveYamlConfig(Plugin plugin, String fileName) {
        if (!new File(plugin.getDataFolder(), fileName + ".yml").exists()) {
            plugin.saveResource(fileName + ".yml", false);
        }
    }

    /**
     * 保存多个Yaml格式配置文件
     * (保存文件，文件名是确定的，使用文件名列表)
     */
    public static void saveMoreYamlConfig(Plugin plugin, List<String> filesName) {
        for (String fileName : filesName) {
            saveYamlConfig(plugin, fileName);
        }
    }

    /**
     * 加载单个Yaml格式配置文件
     */
    public static File loadYamlConfig(Plugin plugin, String fileName) {
        File file = new File(plugin.getDataFolder(), fileName + ".yml");
        if (!file.exists()) {
            saveYamlConfig(plugin, fileName);
        }
        return file;
    }

    /**
     * 加载多个Yaml格式配置文件
     * (加载文件，文件的多少位置是不确定了，使用文件夹名)
     */
    public static List<File> loadMoreYamlConfig(Plugin plugin, String folderName) {
        List<File> files = new ArrayList<>();
        for (File file : Objects.requireNonNull(plugin.getDataFolder().listFiles())) {
            if (file.getName().startsWith(folderName)) {
                files.add(file);
            }
        }
        return files;
    }

    /**
     * 读取单个Yaml格式配置文件
     */
    public static YamlConfiguration readYamlConfig(Plugin plugin, File file) {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        InputStream defConfigStream = plugin.getResource(file.getName());
        if (defConfigStream != null) {
            config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
        }
        return config;
    }

    /**
     * 读取多个Yaml格式配置文件
     * (读取文件，文件已经被加载进来是确定的，使用文件名列表)
     */
    public static List<YamlConfiguration> readMoreYamlConfig(Plugin plugin, List<File> files) {
        List<YamlConfiguration> configs = new ArrayList<>();
        for (File file : files) {
            configs.add(readYamlConfig(plugin, file));
        }
        return configs;
    }
}
