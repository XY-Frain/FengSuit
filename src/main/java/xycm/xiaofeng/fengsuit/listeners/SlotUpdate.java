package xycm.xiaofeng.fengsuit.listeners;

import eos.moe.dragoncore.api.event.PlayerSlotUpdateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xycm.xiaofeng.fengsuit.managers.ConfigManager;

/**
 * @author Frain
 */
public class SlotUpdate implements Listener {
    @EventHandler
    public void onSlotUpdate(PlayerSlotUpdateEvent event) {
        // 判断是否是配置文件中指定的槽位
        if (!ConfigManager.getSettingConfigContent().getSlots().contains(event.getIdentifier())) {
            return;
        }
        String slotName = event.getIdentifier();
        // 判断是拿下来还是放上去（null是物品拿下来）
    }
}
