package cn.lingsmc.spigottemplate.utils;

import cn.lingsmc.spigottemplate.constants.CommandConstants;
import cn.lingsmc.spigottemplate.constants.MessageConstants;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * 权限工具类：统一管理命令权限校验。
 *
 * @author Crsuh2er0
 * @since 2023/1/18
 */
public final class PermissionUtils {
    private PermissionUtils() {
    }

    /**
     * 判断发送者是否具备管理权限（OP 或拥有管理权限节点）。
     *
     * @param sender 命令发送者
     * @return 有权限返回 true
     */
    public static boolean hasAdminAuth(@NotNull CommandSender sender) {
        return sender.isOp() || sender.hasPermission(CommandConstants.PERMISSION_ADMIN);
    }

    /**
     * 校验管理权限，无权限时发送统一提示。
     *
     * @param sender 命令发送者
     * @return 有权限返回 true；无权限返回 false
     */
    public static boolean checkAdminAuth(@NotNull CommandSender sender) {
        if (hasAdminAuth(sender)) {
            return true;
        }
        sender.sendMessage(MessageConstants.NO_PERMISSION);
        return false;
    }
}