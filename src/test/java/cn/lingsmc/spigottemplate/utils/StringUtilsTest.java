package cn.lingsmc.spigottemplate.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * StringUtils 纯逻辑单元测试（TDD 示范）。
 *
 * @author Crsuh2er0
 * @since 2026/10/7
 */
class StringUtilsTest {
    @Test
    void toLowerCaseShouldLowerAllElements() {
        String[] input = {"HELP", "Reload", "St"};
        String[] expected = {"help", "reload", "st"};

        assertArrayEquals(expected, StringUtils.toLowerCase(input));
    }

    @Test
    void toLowerCaseShouldReturnEmptyArrayForEmptyInput() {
        assertArrayEquals(new String[0], StringUtils.toLowerCase(new String[0]));
    }

    @Test
    void toLowerCaseShouldNotMutateInput() {
        String[] input = {"ABC"};

        StringUtils.toLowerCase(input);

        assertArrayEquals(new String[]{"ABC"}, input);
    }
}