package com.beta.replyservice.Services;

import com.beta.replyservice.RuleEngine;
import com.beta.replyservice.dto.ReplyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.beta.replyservice.Constants.RuleEnum.getRule;
import static com.beta.replyservice.Validations.PreValidation.validationV2;

@Service
public class ReplyMessageService {

    @Autowired
    private RuleEngine ruleEngine;

    public ResponseEntity<ReplyMessage> getReplyMessageV2(String message) {
        // validated the request.
         validationV2(message);
        //get the first rule.
        Integer rule_1 = Integer.parseInt(String.valueOf(message.charAt(0)));
        // apply the first rule
        String output_1 = ruleEngine.getRule(getRule(rule_1)).applyRule(message.substring(3));
        // get the second rule
        Integer rule_2 = Integer.parseInt(String.valueOf(message.charAt(1)));
        // apply the second rule.
        String output_2 = ruleEngine.getRule(getRule(rule_2)).applyRule(output_1);
       return ResponseEntity.ok(new ReplyMessage(output_2));
    }
}
