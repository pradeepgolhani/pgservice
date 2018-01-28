package com.pg.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

public class AppUtil {
	
	public static String getAccessToken() throws IOException {
		InputStream inputStream = AppUtil.class.getResourceAsStream("abc.json");
		GoogleCredential googleCredential = GoogleCredential.fromStream(
				inputStream
				).createScoped(
						Arrays.asList(SCOPES));
		googleCredential.refreshToken();
		return googleCredential.getAccessToken();
	}
	private static final String SCOPES[] = {"https://www.googleapis.com/auth/firebase.messaging"};//, "https://www.googleapis.com/auth/cloud-platform"
}
