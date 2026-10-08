package cn.lingsmc.spigottemplate.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * 字符串工具类，提供纯函数式的字符串处理。
 *
 * @author Crsuh2er0
 * @since 2024/1/1
 */
public final class StringUtils {
    private StringUtils() {
    }

    /**
     * 返回逐元素转小写后的新数组，不修改入参数组。
     *
     * @param strings 原始字符串数组
     * @return 转小写后的新数组
     */
    @NotNull
    @Contract(pure = true)
    public static String[] toLowerCase(@NotNull String[] strings) {
        String[] result = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            result[i] = strings[i].toLowerCase();
        }
        return result;
    }
}