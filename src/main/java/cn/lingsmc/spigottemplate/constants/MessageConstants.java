package cn.lingsmc.spigottemplate.constants;

import cn.lingsmc.spigottemplate.SpigotTemplate;

/**
 * 玩家可见文案常量，统一在此维护（颜色码遵循品牌色板：§3 框架 / §b 强调 / §a 成功 / §c 错误）。
 *
 * @author Crsuh2er0
 * @since 2023/1/18
 */
public final class MessageConstants {
    /** 作者署名（彩色） */
    public static final String AUTHOR = "§aC§br§cs§du§eh§a2§be§cr§d0";

    public static final String RELOAD_SUCCESS = "§a重载成功.";
    public static final String WELCOME_MESSAGE = "§a欢迎 §b%s §a来到服务器!";
    public static final String UNKNOWN_COMMAND = "§c未知命令.";
    public static final String NO_PERMISSION = "§c你没有执行该命令的权限.";
    public static final String CONSOLE = "§c该命令必须由玩家执行.";
    public static final String PLAYER_NOT_EXIST = "§c玩家不存在!";
    public static final String NON_INT = "§c你输入的不是一个合法的数字!";

    private MessageConstants() {
    }

    /**
     * 无参数执行主命令时的运行横幅。
     *
     * @return 逐行发送的横幅文本
     */
    public static String[] getRootMessage() {
        SpigotTemplate plugin = SpigotTemplate.getInstance();
        return new String[]{
                String.format("§3此服务器正在运行 §b%s %s§3 by %s", plugin.getName(),
                        plugin.getPluginMeta().getVersion(), AUTHOR),
                String.format("§3命令列表: §b/%s %s", CommandConstants.ALIAS, CommandConstants.HELP),
        };
    }

    /**
     * help 子命令的输出。
     *
     * @return 逐行发送的帮助文本
     */
    public static String[] getHelpMessage() {
        SpigotTemplate plugin = SpigotTemplate.getInstance();
        return new String[]{
                String.format("§3§l----- %s指令 -----", plugin.getName()),
                String.format("§b/%s %s §3- §a重载本插件", CommandConstants.ALIAS, CommandConstants.RELOAD),
        };
    }
}