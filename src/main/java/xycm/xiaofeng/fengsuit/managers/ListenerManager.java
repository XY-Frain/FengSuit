package xycm.xiaofeng.fengsuit.managers;

import xycm.xiaofeng.fengsuit.FengSuit;
import xycm.xiaofeng.fengsuit.listeners.SlotUpdate;

/**
 * @author Frain
 */
public class ListenerManager {
    public static void register() {
        FengSuit.getInstance().getServer().getPluginManager().registerEvents(new SlotUpdate(), FengSuit.getInstance());
    }
}
