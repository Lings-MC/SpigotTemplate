package cn.lingsmc.spigottemplate;

import cn.lingsmc.spigottemplate.commands.Commands;
import cn.lingsmc.spigottemplate.constants.CommandConstants;
import cn.lingsmc.spigottemplate.listener.AnyListener;
import cn.lingsmc.spigottemplate.utils.ConfigUtils;
import lombok.Getter;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 插件主类：持有插件实例，并在生命周期中装配配置、命令与监听器。
 *
 * @author Crsuh2er0
 * @since 2023/1/16
 */
public final class SpigotTemplate extends JavaPlugin {
    @Getter
    private static SpigotTemplate instance;

    @Override
    public void onLoad() {
        instance = this;
        ConfigUtils.initialize();
    }

    @Override
    public void onEnable() {
        registerCommands();
        AnyListener.initialize();
    }

    @Override
    public void onDisable() {
        // 插件卸载逻辑
    }

    /**
     * 注册主命令的执行器与补全器。
     */
    private void registerCommands() {
        PluginCommand command = getCommand(CommandConstants.ALIAS);
        if (command == null) {
            getLogger().severe("无法获取主命令 " + CommandConstants.ALIAS + "，请检查 plugin.yml 的 commands 配置！");
            return;
        }
        Commands commands = new Commands();
        command.setExecutor(commands);
        command.setTabCompleter(commands);
    }
}