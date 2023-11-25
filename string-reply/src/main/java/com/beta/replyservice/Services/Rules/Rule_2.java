package com.beta.replyservice.Services.Rules;

import com.beta.replyservice.RuleService;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service("hashMD5")
public class Rule_2 implements RuleService {
    @Override
    public String applyRule(String message) {
        try {
            if(message == null || message.length() <= 0)
            {
                throw new IllegalArgumentException("message is invalid");
            }
           return hashMessageInMD5(message);  // possible of internal server error.
        }
        catch (NoSuchAlgorithmException e) {
            throw new InternalError("Unable to run rule_2");
        }
    }

    private String hashMessageInMD5(String message) throws NoSuchAlgorithmException  {
            // Create an MD5 hash instance
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Update the message digest with the input string bytes
            md.update(message.getBytes());

            // Generate the MD5 hash as a byte array
            byte[] digest = md.digest();

            // Convert the byte array to a hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
    }
}
