package cn.lingsmc.spigottemplate.utils;

import cn.lingsmc.spigottemplate.SpigotTemplate;
import cn.lingsmc.spigottemplate.constants.ConfigConstants;

/**
 * 配置工具类：负责配置文件的加载、重载与读取。
 *
 * @author Crsuh2er0
 * @since 2023/1/16
 */
public final class ConfigUtils {
    private ConfigUtils() {
    }

    /**
     * 加载/重载配置：写出缺失的默认项并刷新内存配置。
     */
    public static void initialize() {
        SpigotTemplate plugin = SpigotTemplate.getInstance();
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }

    /**
     * @return 是否开启玩家加入欢迎提示
     */
    public static boolean isWelcomeMessageEnabled() {
        return SpigotTemplate.getInstance().getConfig().getBoolean(ConfigConstants.WELCOME_MESSAGE, true);
    }
}