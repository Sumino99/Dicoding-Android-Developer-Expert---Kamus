/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.ysn.dicodingandroiddeveloperexpert_kamus", appContext.getPackageName());
    }
}
