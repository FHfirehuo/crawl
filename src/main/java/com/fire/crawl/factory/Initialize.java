package com.fire.crawl.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Initialize{
	
	private static final Map<String, String> setting = new HashMap<String, String>();
	public static final String FIRST_URL = "FIRSTURL";
	public static final String SITE = "FIRSTURL";
	
	@Value("${first.url}")
	private String url;
	
	@Value("${site}")
	private String site;
	
	public void init(){
		setting.put(FIRST_URL, url);
		setting.put(SITE, site);
	}
	
	
	public static String get(final String key){
		return setting.get(key);
	}
	
}
