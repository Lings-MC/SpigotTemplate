package cn.lingsmc.spigottemplate.commands.subcommands;

import cn.lingsmc.spigottemplate.commands.SubCommand;
import cn.lingsmc.spigottemplate.constants.MessageConstants;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

/**
 * help 子命令：输出插件命令列表。
 *
 * @author Crsuh2er0
 * @since 2023/1/18
 */
public class HelpCommand implements SubCommand {
    @Override
    public void execute(CommandSender sender, String[] args) {
        Arrays.asList(MessageConstants.getHelpMessage()).forEach(sender::sendMessage);
    }
}