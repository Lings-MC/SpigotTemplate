package cn.lingsmc.spigottemplate.listener;

import cn.lingsmc.spigottemplate.SpigotTemplate;
import cn.lingsmc.spigottemplate.constants.MessageConstants;
import cn.lingsmc.spigottemplate.utils.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * 事件监听示例：演示监听器注册与配置读取。
 * 新增监听器时仿照本类实现 {@link Listener}，并在 {@link #initialize()} 中注册。
 *
 * @author Crsuh2er0
 * @since 2023/1/31
 */
public class AnyListener implements Listener {
    private AnyListener() {
    }

    /**
     * 将监听器注册到服务器。
     */
    public static void initialize() {
        Bukkit.getPluginManager().registerEvents(new AnyListener(), SpigotTemplate.getInstance());
    }

    /**
     * 玩家加入时按配置发送欢迎提示。
     *
     * @param event 玩家加入事件
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!ConfigUtils.isWelcomeMessageEnabled()) {
            return;
        }
        Player player = event.getPlayer();
        player.sendMessage(String.format(MessageConstants.WELCOME_MESSAGE, player.getName()));
    }
}