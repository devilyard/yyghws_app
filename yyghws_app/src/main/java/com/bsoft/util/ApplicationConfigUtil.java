/*
 * @(#)WeixinSettingService.java Created on 2013年9月10日下午9:26:54
 * 
 * 版权：版权所有 chinnsii 保留所有权力。
 */
package com.bsoft.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author <a href="mailto:rishyonn@gmail.com">zhengshi</a>
 */
public class ApplicationConfigUtil {
	private static ApplicationConfigUtil apputil;
	private long lastModifyTime = 0;
	private Map<String, String> setting;
	
	public static ApplicationConfigUtil instance(){
		if(apputil ==null){
			apputil = new ApplicationConfigUtil();
		}
		return apputil;
	}
	
	public String getSecret(String appId) throws IOException{
		setting = getSetting();
		return setting.get(appId);
	}
	
	/**
	 * @return
	 * @throws IOException
	 */
	public Map<String, String> getSetting() throws IOException {
		URL configLocation = this.getClass().getClassLoader()
				.getResource("/");
		String path = configLocation.getPath().replace("/classes", "");
		File file = new File(path + "conf/applicationConfig");
		if (file.lastModified() <= lastModifyTime) {
			return setting;
		}
		InputStream in = new FileInputStream(file);
		if (in == null) {
			return null;
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					in, "UTF-8"));
			String line = null;
			Map<String, String> setting = new HashMap<String, String>();
			while ((line = reader.readLine()) != null && line.length()>0) {
				int inx = line.indexOf("=");
				String name = line.substring(0, inx);
				String value = line.substring(inx + 1);
				setting.put(name, value);
			}
			return setting;
		} finally {
			in.close();
		}
	}
	
	
}
