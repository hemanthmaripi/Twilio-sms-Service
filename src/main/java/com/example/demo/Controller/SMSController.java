package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.TwilioServiceSMS;

@RestController
@RequestMapping("/api")
public class SMSController {
	
	@Autowired
	private TwilioServiceSMS sms;
	
	@PostMapping("/send")
	public String sendSms(@RequestBody Map<String, String> details) {
		try {
		String phone = details.get("phoneno");
		String msg = details.get("msg");
		
		return sms.sendSms(phone, msg);
		} catch(Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}

	
}
