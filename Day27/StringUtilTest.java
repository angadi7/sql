package com.Day27;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilTest {

    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtil.isPalindrome("madam"));
        assertTrue(StringUtil.isPalindrome("A man a plan a canal Panama"));
        assertFalse(StringUtil.isPalindrome("hello"));
        assertFalse(StringUtil.isPalindrome(null));
    }

    @Test
    public void testToTitleCase() {
        assertEquals("Hello World", StringUtil.toTitleCase("hello world"));
        assertEquals("Hello", StringUtil.toTitleCase("HELLO"));
        assertEquals("Java Programming", StringUtil.toTitleCase("java programming"));
        assertEquals("", StringUtil.toTitleCase(""));
        assertNull(StringUtil.toTitleCase(null));
    }

    @Test
    public void testReverse() {
        assertEquals("dlrow olleh", StringUtil.reverse("hello world"));
        assertEquals("avaJ", StringUtil.reverse("Java"));
        assertEquals("", StringUtil.reverse(""));
        assertNull(StringUtil.reverse(null));
    }
}

