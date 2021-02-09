/*
 * Copyright 2016-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junitpioneer.playwright;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ExtendWith(PlaywrightParameterResolver.class)
@ExtendWith(BrowserTypeParameterResolver.class)
@ExtendWith(BrowserParameterResolver.class)
@ExtendWith(BrowserContextParameterResolver.class)
@Test
public @interface PlaywrightTest {

	// BROWSER TYPE

	/**
	 * Configures a {@link Playwright#chromium() Chromium},
	 * {@link Playwright#firefox() Firefox}, or {@link Playwright#webkit() Webkit}
	 * {@link com.microsoft.playwright.BrowserType BrowserType}.
	 */
	BrowserName browserType() default BrowserName.FIREFOX;

	// BROWSER

	/**
	 * Configures {@link com.microsoft.playwright.BrowserType.LaunchOptions#headless headless mode}.
	 */
	boolean headless() default true;

	/**
	 * Configures {@link com.microsoft.playwright.BrowserType.LaunchOptions#timeout timeout}.
	 */
	double timeout() default 30_000d;

	enum BrowserName {
		CHROMIUM, FIREFOX, WEBKIT
	}

}
