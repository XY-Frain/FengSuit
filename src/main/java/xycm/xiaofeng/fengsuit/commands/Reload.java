package xycm.xiaofeng.fengsuit.commands;

import xycm.xiaofeng.fengsuit.managers.ConfigManager;

/**
 * @author Frain
 */
public class Reload {
    public static void run(String[] strings){
        ConfigManager.saveLoadReadAllConfig();
    }
}
