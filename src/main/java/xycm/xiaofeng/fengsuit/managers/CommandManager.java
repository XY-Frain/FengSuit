package xycm.xiaofeng.fengsuit.managers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import xycm.xiaofeng.fengsuit.FengSuit;
import xycm.xiaofeng.fengsuit.commands.Help;
import xycm.xiaofeng.fengsuit.commands.Reload;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Frain
 */
public class CommandManager implements CommandExecutor, TabCompleter {
    public static void register() {
        FengSuit.getInstance().getCommand("FengSuit").setExecutor(new CommandManager());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        // 玩家不可执行
        if (commandSender instanceof Player && !commandSender.isOp()) {
            return true;
        }
        // 如果没参数则直接发送插件信息和帮助
        if (strings.length == 0) {
            commandSender.sendMessage("§aFengSuit v1.0.0");
            return true;
        }
        String[] arg = Arrays.copyOfRange(strings, 1, strings.length);
        // 有参数则开始执行
        switch (strings[0]) {
            case "reload":
                Reload.run(arg);
                return true;
            case "help":
                Help.run(arg);
                return true;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return Collections.emptyList();
    }
}
