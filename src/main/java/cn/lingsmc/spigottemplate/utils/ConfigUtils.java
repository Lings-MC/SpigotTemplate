package cn.lingsmc.spigottemplate.utils;

import cn.lingsmc.spigottemplate.SpigotTemplate;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * @author Crsuh2er0
 * @apiNote
 * @since 2023/1/16
 */
public class ConfigUtils {
    static SpigotTemplate plugin = SpigotTemplate.getInstance();

    private ConfigUtils() {
    }

    public static void initialize() {
        // 初始化配置文件
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        plugin.getConfig().options().copyDefaults(true);
        FileConfiguration config = plugin.getConfig();
    }
}
