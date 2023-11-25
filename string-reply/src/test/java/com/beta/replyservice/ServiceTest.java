package com.beta.replyservice;


import com.beta.replyservice.Services.ReplyMessageService;
import com.beta.replyservice.dto.ReplyMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertThrows;

@SpringBootTest
public class ServiceTest {

    @Autowired
    ReplyMessageService replyMessageService;

    @Test
    public void testReplyMessageV2_Rule1() throws Exception {
        // Request input
        String message = "11-kbzw9ru";

        //Expected output
        ReplyMessage replyMessage = new ReplyMessage("kbzw9ru");

        ResponseEntity<ReplyMessage> response = replyMessageService.getReplyMessageV2(message);

        assert(response.getStatusCode()).equals(HttpStatus.OK);
        assert(response.getBody().getMessage()).equals(replyMessage.getMessage());

    }

    @Test
    public void testReplyMessageV2_Rule2() throws Exception {
        //Request input
        String message = "12-kbzw9ru";

        //Expected output
        ReplyMessage replyMessage = new ReplyMessage("5a8973b3b1fafaeaadf10e195c6e1dd4");

        ResponseEntity<ReplyMessage> response = replyMessageService.getReplyMessageV2(message);

        assert(response.getBody().getMessage()).equals(replyMessage.getMessage());
        assert(response.getStatusCode()).equals(HttpStatus.OK);
    }

    @Test
    public void testReplyMessageV2_InvalidCase() throws Exception {
        //Request input
        String message = "13-kbzw9ru";

        IllegalArgumentException exception = assertThrows(
               IllegalArgumentException.class,
                () -> replyMessageService.getReplyMessageV2(message));

        assert(exception.getMessage()).equals("Invalid rules");
    }

}
