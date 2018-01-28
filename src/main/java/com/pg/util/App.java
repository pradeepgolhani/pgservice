package com.pg.util;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {

	public static String sendPost(Map<String, String> data, String id)
			throws Exception {
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse response = null;
		try {
			System.out.println(URL);
			HttpPost request = new HttpPost(URL);
			System.out.println(getJsonPayLoad(data, id));
			StringEntity params = new StringEntity(getJsonPayLoad(data, id));
			request.addHeader("Content-Type", "application/json; UTF-8");
			request.addHeader("Authorization",
					"Bearer " + AppUtil.getAccessToken());
			request.setEntity(params);
			response = httpClient.execute(request);
			System.out.println(response.toString());

			// handle response here...
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}

		return response.toString();

	}

	private static String getJsonPayLoad(Map<String, String> data, String id) {
		FCMPayload fcmPayload = new FCMPayload();
		Message message = new Message();
		message.setToken(id);

		message.setData(data);

		fcmPayload.setMessage(message);
		ObjectMapper mapperObj = new ObjectMapper();
		try {
			return mapperObj.writeValueAsString(fcmPayload);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static final String PROJECT_ID = "notificationtestapp-3eced";
	private static final String URL = "https://fcm.googleapis.com/v1/projects/"
			+ PROJECT_ID + "/messages:send";
}
