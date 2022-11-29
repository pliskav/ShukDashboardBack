package utils;





import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import com.twilio.Twilio;
import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber;

import dashboard.dao.Language;
import dashboard.service.TranslateReposutorySql;
import dashboard.service.UserRepositorySql;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.Charsets;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.tomcat.util.buf.Utf8Decoder;
import org.apache.tomcat.util.buf.Utf8Encoder;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal; 
public class WhatsappMessage {
	
	 public static final String ACCOUNT_SID = "AC76228e82c81cba6cf92bbf1b0d2d0e12"; 
	    public static final String AUTH_TOKEN = "95bc8f17e0902778f044795fa2db8a05"; 
	    public static WhatsappMessage instance = null;
	    
	    public static WhatsappMessage getInstance() {
	    	if(instance==null) {
	    		instance = new WhatsappMessage();
	    	}
	    	return instance;
	    }
	    
	    private WhatsappMessage() {
	    	 Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
	    } 
	    
	    public  void sendWhatsappMessage(String customerPhone, String messageText) { 
		  Message message = Message.creator( new
			  com.twilio.type.PhoneNumber("whatsapp:+972524083392"), new
			  com.twilio.type.PhoneNumber("whatsapp:+972524083393"), messageText) .create();
			  
			  
			  System.out.println("from: "+message.getFrom()+" to:"+message.getTo()+": "
			  +message);
			 
	    } 
	    
	    
	    public void sendSms(String customerPhone, String messageText)  {
	    	
	    	try {
	    	String       postUrl       = "https://graph.facebook.com/v13.0/103229759290909/messages";// put in your url
	    	Gson         gson          = new Gson();
	    	HttpClient   httpClient    = HttpClientBuilder.create().build();
	    	HttpPost     post          = new HttpPost(postUrl);
	    	StringEntity postingString = new StringEntity("{\r\n" + 
    	    		"      \"messaging_product\": \"whatsapp\"," + 
    	    		"     \"recipient_type\": \"individual\"," + 
    	    		"      \"to\": \""+customerPhone+"\"," + 
    	    		"      \"type\": \"text\"," + 
    	    		"      \"text\": { " + 
    	    		"        \"body\": \""+"Привет Медвед".toCharArray()+"\"" + 
    	    		"        }" + 
    	    		"    }");//gson.tojson() converts your pojo to json
	    	post.setEntity(postingString);
	    	//post.setHeader("charset", "UTF-8");
	    	post.setHeader("Content-type", "application/json; charset=UTF-8");
	    	post.setHeader("Authorization",  "Bearer EAAVaCAQssh0BAI15OZBJALYOWVNexUTwt6BYFSCGSLw63r9Whkn6ZBaXd3VNcYpazTRUa3i04AmCKOTIxafb0Bdj7xUvxRvDIWbI3ZBgdkAPAsIWWJHYY4Tgv1nudaur83zh0nmW2gHh4mvfmUAJLVM0R2UmrXQ1FN0dJ0GldNlXC65rYZAEEFbpwcdJO0Nj7bnvZBKHR6W6UuOcIoVIhywutdDFLkZBwZD");

	    	
				HttpResponse  response = httpClient.execute(post);
				System.out.println(response);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    	
	    
	    	
	    	
	    	
	    	
	    	
	    	
			/*
			 * HttpURLConnection connection = null; String targetURL =
			 * "https://graph.facebook.com/v13.0/103229759290909/messages"; try { String
			 * text = new String(messageText.getBytes(StandardCharsets.UTF_8),
			 * StandardCharsets.UTF_8); System.out.println(text); //Create connection URL
			 * url = new URL(targetURL); connection = (HttpURLConnection)
			 * url.openConnection(); connection.setRequestMethod("POST");
			 * connection.setRequestProperty("Content-Type", "application/json");
			 * connection.setRequestProperty("Authorization",
			 * "Bearer EAAVaCAQssh0BAI15OZBJALYOWVNexUTwt6BYFSCGSLw63r9Whkn6ZBaXd3VNcYpazTRUa3i04AmCKOTIxafb0Bdj7xUvxRvDIWbI3ZBgdkAPAsIWWJHYY4Tgv1nudaur83zh0nmW2gHh4mvfmUAJLVM0R2UmrXQ1FN0dJ0GldNlXC65rYZAEEFbpwcdJO0Nj7bnvZBKHR6W6UuOcIoVIhywutdDFLkZBwZD"
			 * );
			 * 
			 * connection.setUseCaches(false); connection.setDoOutput(true);
			 * 
			 * //Send request DataOutputStream wr = new DataOutputStream (
			 * connection.getOutputStream());
			 * 
			 * 
			 * wr.writeBytes("{\r\n" + "      \"messaging_product\": \"whatsapp\"," +
			 * "     \"recipient_type\": \"individual\"," +
			 * "      \"to\": \""+customerPhone+"\"," + "      \"type\": \"text\"," +
			 * "      \"text\": { " + "        \"body\": \""+URLEncoder.encode(new
			 * String(messageText.getBytes("windows-1251"), "UTF-8"), "UTF-8")+"\"" +
			 * "        }" + "    }");
			 * 
			 * 
			 * wr.close();
			 * 
			 * //Get Response InputStream is = connection.getInputStream(); BufferedReader
			 * rd = new BufferedReader(new InputStreamReader(is)); StringBuilder response =
			 * new StringBuilder(); // or StringBuffer if Java version 5+ String line; while
			 * ((line = rd.readLine()) != null) { response.append(line);
			 * response.append('\r'); } rd.close(); System.out.println(
			 * response.toString()); } catch (Exception e) { e.printStackTrace();
			 * 
			 * } finally { if (connection != null) { connection.disconnect(); } }
			 */
	    }
}
