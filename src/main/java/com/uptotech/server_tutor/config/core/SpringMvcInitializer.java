package com.uptotech.server_tutor.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.uptotech.server_tutor.config.Config;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected final Class<?>[] getRootConfigClasses() {
		return new Class[] { Config.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return null/*new Class<?>[] { Config.class }*/;
	}

	@Override
	protected final String[] getServletMappings() {
		return new String[] { "/" };
	}

}
