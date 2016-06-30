package com.sprint.instagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;

public class InstagramDataCollection {
	 private final String USER_AGENT = "Mozilla/5.0";
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		
		 InstagramDataCollection idc = new InstagramDataCollection();

	        System.out.println("Testing 1 - Send Http GET request");
	        idc.sendGet();
	}

	public void sendGet() throws ClientProtocolException, IOException {
		String url = "https://api.instagram.com/v1/tags/sprint/media/recent?access_token=3485160201.7cd38b4.6d0c6ffe3a3441eab0dbf94c9e598577";
		HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        
        /*
         * refer to the link to get the access token
         * http://jelled.com/instagram/access-token
         */
        String access_Token="3485160201.7cd38b4.6d0c6ffe3a3441eab0dbf94c9e598577";
        // add request header
        request.addHeader("User-Agent", USER_AGENT);

        HttpResponse response = client.execute(request);

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());

  
	}
}
