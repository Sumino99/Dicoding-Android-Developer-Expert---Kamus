/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;

/**
 * Created by yudisetiawan on 9/30/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
