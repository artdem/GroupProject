package com.example.demo.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "******";
    public static final String AUTH_TOKEN =
            "******";

    public void sendSMS(String number, String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(number), // to
                        new PhoneNumber("******"), // from
                        msg)
                .create();
    }
}