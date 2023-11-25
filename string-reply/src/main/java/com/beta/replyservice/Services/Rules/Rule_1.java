package com.beta.replyservice.Services.Rules;

import com.beta.replyservice.RuleService;
import org.springframework.stereotype.Service;

@Service("reverseString")
public class Rule_1 implements RuleService {

    @Override
    public String applyRule(String message) {
        return new StringBuilder(message).reverse().toString();
    }
}
