package com.beta.replyservice.Validations;


public class PreValidation {

   private final static char DASH = '-';

    public static void validationV2(String message) {

        /* Invalid case of message :
        * message is null
        * message length < 4.
        * message's first or second character is not number
        * message's third character is not dash.
         */
        if( message == null ||message.length() < 4 || !Character.isDigit(message.charAt(0)) || !Character.isDigit(message.charAt(1)) || DASH != message.charAt(2)) {
            throw new IllegalArgumentException("invalid message");
        }
    }

}
