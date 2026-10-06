package cn.lingsmc.spigottemplate.commands;

import cn.lingsmc.spigottemplate.commands.subcommands.HelpCommand;
import cn.lingsmc.spigottemplate.commands.subcommands.ReloadCommand;
import cn.lingsmc.spigottemplate.constants.CommandConstants;
import cn.lingsmc.spigottemplate.constants.MessageConstants;
import cn.lingsmc.spigottemplate.utils.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 主命令执行器：负责内置子命令注册、参数分发与 Tab 补全。
 *
 * @author Zoyn, Crsuh2er0
 * @since 2023/1/18
 */
public class Commands implements CommandExecutor, TabCompleter {
    /**
     * 注册内置子命令。
     */
    public Commands() {
        CommandRegistry.register(CommandConstants.HELP, new HelpCommand());
        CommandRegistry.register(CommandConstants.RELOAD, new ReloadCommand());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            Arrays.asList(MessageConstants.getRootMessage()).forEach(sender::sendMessage);
            return false;
        }

        // 统一转小写后再分发，子命令名大小写不敏感
        String[] finalArgs = StringUtils.toLowerCase(args);
        SubCommand subCommand = CommandRegistry.get(finalArgs[0]);
        if (subCommand == null) {
            sender.sendMessage(MessageConstants.UNKNOWN_COMMAND);
            return false;
        }
        subCommand.execute(sender, finalArgs);
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        // 参数为空时不补全，避免访问 args[0] 越界
        if (args.length == 0) {
            return Collections.emptyList();
        }

        String[] finalArgs = StringUtils.toLowerCase(args);
        if (finalArgs.length == 1) {
            List<String> list = new ArrayList<>(CommandRegistry.getCommandNames());
            list.removeIf(s -> !s.startsWith(finalArgs[0]));
            return list;
        }

        SubCommand subCommand = CommandRegistry.get(finalArgs[0]);
        if (subCommand == null) {
            return Collections.emptyList();
        }
        return subCommand.tabComplete(finalArgs);
    }
}