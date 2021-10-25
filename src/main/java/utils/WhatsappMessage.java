package utils;

import com.twilio.Twilio;
import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber; 
 
import java.net.URI; 
import java.math.BigDecimal; 
public class WhatsappMessage {
	 public static final String ACCOUNT_SID = "AC76228e82c81cba6cf92bbf1b0d2d0e12"; 
	    public static final String AUTH_TOKEN = "0eaa8b411028e49511c6e581ffee4634"; 
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
	    
	    public  void main(String customerPhone, String messageText) { 
	       
	        Message message = Message.creator( 
	                new com.twilio.type.PhoneNumber("whatsapp:"+customerPhone), 
	                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
	                messageText)      
	            .create(); 
	 
	        System.out.println("from: "+message.getFrom()+" to:"+message.getTo()+": "+message); 
	    } 
}
