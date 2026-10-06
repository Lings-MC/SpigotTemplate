package cn.lingsmc.spigottemplate.constants;

/**
 * 命令相关常量。
 *
 * @author Crsuh2er0
 * @since 2023/1/18
 */
public final class CommandConstants {
    /** 主命令别名，需与 plugin.yml 的 commands 键一致 */
    public static final String ALIAS = "st";
    /** 帮助子命令名 */
    public static final String HELP = "help";
    /** 重载子命令名 */
    public static final String RELOAD = "reload";
    /** 管理权限节点，需与 plugin.yml 的 permissions 键一致 */
    public static final String PERMISSION_ADMIN = "spigottemplate.admin";

    private CommandConstants() {
    }
}