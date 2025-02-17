package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Configuration.TwilioConfiguration;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioServiceSMS {
	
	
	private TwilioConfiguration configuration;
	
	public TwilioServiceSMS(TwilioConfiguration configuration) {
		// TODO Auto-generated constructor stub
		this.configuration = configuration;
		
		Twilio.init(configuration.getAccountSid(), configuration.getAuthToken());
	}
	
	public String sendSms (String toPhonenumber, String messageBody) {
		Message message = Message.creator(
							new PhoneNumber(toPhonenumber),
							new PhoneNumber(configuration.getPhoneNumber()),
							messageBody).create();
		
		return "Message Sent Successfully " + message.getSid();
	}
	
}
