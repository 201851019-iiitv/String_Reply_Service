package com.beta.replyservice.Constants;

public enum RuleEnum {
    RULE_1(1,"reverseString"),
    RULE_2(2,"hashMD5");

    private final Integer ruleId;
    private final String ruleValue;

    RuleEnum(Integer ruleId, String ruleValue) {
        this.ruleId = ruleId;
        this.ruleValue = ruleValue;
    }

    public static String getRule(Integer ruleId) {
          for( RuleEnum rules : values()) {
              if(rules.ruleId == ruleId) {
                  return rules.ruleValue;
              }
          }
          throw new IllegalArgumentException("Invalid rules");
    }

}
