package com.pkharat.smsapp.service;

import com.pkharat.smsapp.dto.SmsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SMSService {
    //private final String ACCOUNT_SID ="enter your SID Number from Twilio";
    private final String ACCOUNT_SID ="AC2a87a06645cee4604a45f7a5fc386a7c";

    //private final String AUTH_TOKEN = "enter your Auth token from Twilio Account";
    private final String AUTH_TOKEN = "4404ee29b0006ede5d378d3c2a1fc77b";

    //https://www.twilio.com/docs/api/errors/21606
    private final String FROM_NUMBER = "+15005550001";

    public void send(SmsDTO sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }
}
