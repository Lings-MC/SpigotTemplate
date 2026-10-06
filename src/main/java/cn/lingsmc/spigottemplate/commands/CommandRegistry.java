package cn.lingsmc.spigottemplate.commands;

import cn.lingsmc.spigottemplate.SpigotTemplate;
import org.bukkit.Bukkit;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 子命令注册表：持有「子命令名 -&gt; 实现」映射，并防止重复注册。
 *
 * @author Crsuh2er0
 * @since 2026/10/7
 */
public final class CommandRegistry {
    private static final Map<String, SubCommand> COMMAND_MAP = new ConcurrentHashMap<>();

    private CommandRegistry() {
    }

    /**
     * 注册一个子命令，名称重复时记录警告并忽略。
     *
     * @param commandName 子命令名（小写）
     * @param subCommand  子命令实现
     */
    public static void register(String commandName, SubCommand subCommand) {
        if (COMMAND_MAP.containsKey(commandName)) {
            Bukkit.getLogger().warning(String.format("[%s] 子命令重复注册: %s",
                    SpigotTemplate.getInstance().getName(), commandName));
            return;
        }
        COMMAND_MAP.put(commandName, subCommand);
    }

    /**
     * 查找子命令。
     *
     * @param commandName 子命令名（小写）
     * @return 对应的子命令，不存在时返回 null
     */
    public static SubCommand get(String commandName) {
        return COMMAND_MAP.get(commandName);
    }

    /**
     * @return 全部已注册子命令名（只读视图）
     */
    public static Set<String> getCommandNames() {
        return Collections.unmodifiableSet(COMMAND_MAP.keySet());
    }
}