/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.deploy.hot.extender.internal.activator;

import com.liferay.portal.deploy.hot.extender.internal.tracker.ServletContextTracker;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Miguel Pastor
 */
public class HotDeployActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		_servletContextTracker = new ServletContextTracker(bundleContext);

		_servletContextTracker.open();
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		_servletContextTracker.close();

		_servletContextTracker = null;
	}

	private ServletContextTracker _servletContextTracker;

}