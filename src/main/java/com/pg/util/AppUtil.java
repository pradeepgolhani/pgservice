package com.pg.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

public class AppUtil {
	private static final String SCOPES[] = { "https://www.googleapis.com/auth/firebase.messaging" };// ,
																									// "https://www.googleapis.com/auth/cloud-platform"

	public static String getAccessToken() throws IOException {
		GoogleCredential googleCredential = null;
		try {
			InputStream inputStream = AppUtil.class
					.getResourceAsStream("abc.json");
			String result = IOUtils.toString(inputStream, "UTF-8");
			System.out.println(result);
			googleCredential = GoogleCredential.fromStream(inputStream)
					.createScoped(Arrays.asList(SCOPES));
			googleCredential.refreshToken();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return googleCredential.getAccessToken();
	}

}
