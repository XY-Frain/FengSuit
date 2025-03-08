package xycm.xiaofeng.fengsuit;

import org.bukkit.plugin.java.JavaPlugin;
import xycm.xiaofeng.fengsuit.managers.CommandManager;
import xycm.xiaofeng.fengsuit.managers.ConfigManager;
import xycm.xiaofeng.fengsuit.managers.ListenerManager;

/**
 * @author Frain
 */
public final class FengSuit extends JavaPlugin {

    private static FengSuit instance;

    public static FengSuit getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
        ConfigManager.saveLoadReadAllConfig();
    }

    @Override
    public void onEnable() {
        // 注册指令
        CommandManager.register();
        // 注册事件
        ListenerManager.register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
