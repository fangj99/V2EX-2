package cn.denua.v2ex.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void timestampToStr() {
    }

    @Test
    public void strToTimestamp() {

        System.out.println(StringUtil.strToTimestamp("2019-01-06 15:46:34 +08:00", "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void getDateNow() {
    }
}