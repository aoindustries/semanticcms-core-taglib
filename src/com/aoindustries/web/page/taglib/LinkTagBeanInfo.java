/*
 * ao-web-page-taglib - Java API for modeling web page content and relationships in a JSP environment.
 * Copyright (C) 2015, 2016  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-web-page-taglib.
 *
 * ao-web-page-taglib is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-web-page-taglib is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-web-page-taglib.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoindustries.web.page.taglib;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class LinkTagBeanInfo extends SimpleBeanInfo {

	private static final Object propertiesLock = new Object();
    private static PropertyDescriptor[] properties;

    @Override
    public PropertyDescriptor[] getPropertyDescriptors () {
        try {
			synchronized(propertiesLock) {
				PropertyDescriptor[] props = properties;
				if(props==null) {
					props = new PropertyDescriptor[] {
						new PropertyDescriptor("params", LinkTag.class, "getParams", null),
						new PropertyDescriptor("class", LinkTag.class, "getClazz", "setClazz"),
						new PropertyDescriptor("book", LinkTag.class, null, "setBook"),
						new PropertyDescriptor("page", LinkTag.class, null, "setPage"),
						new PropertyDescriptor("element", LinkTag.class, null, "setElement"),
						new PropertyDescriptor("view", LinkTag.class, null, "setView")
					};
					properties = props;
				}
				return props;
			}
        } catch(IntrospectionException err) {
			throw new AssertionError(err);
        }
    }

	/**
	 * Include base class.
	 */
	@Override
	public BeanInfo[] getAdditionalBeanInfo() {
		try {
			return new BeanInfo[] {
				Introspector.getBeanInfo(LinkTag.class.getSuperclass())
			};
        } catch(IntrospectionException err) {
			throw new AssertionError(err);
        }
	}
}
