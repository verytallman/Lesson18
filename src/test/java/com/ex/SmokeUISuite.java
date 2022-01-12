package com.ex;

import org.testng.annotations.Test;

public class SmokeUISuite extends BaseTest {
    @Test
    public void firstTest(){
    webDriver.get("http://automationpractice.com/");
    }
}
