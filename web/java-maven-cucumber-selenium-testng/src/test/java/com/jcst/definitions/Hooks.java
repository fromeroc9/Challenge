package com.jcst.definitions;

import com.jcst.utils.HelperClass;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public static void setUp() {
        HelperClass.setUpDriver();
    }

    @After
    public static void tearDownAll() {
        HelperClass.tearDown();
    }
}
