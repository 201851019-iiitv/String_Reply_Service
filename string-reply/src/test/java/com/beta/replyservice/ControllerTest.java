package com.beta.replyservice;

import com.beta.replyservice.Controller.ReplyController;
import com.beta.replyservice.Services.ReplyMessageService;
import com.beta.replyservice.dto.ReplyMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Mock
    ReplyMessageService replyMessageService;

    @InjectMocks
    ReplyController replyController;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;



    @Test
    public void testReplyMessageV2_Rule1() throws Exception {
         //Request input
         String message = "11-kbzw9ru";

         //Expected output
         ReplyMessage replyMessage = new ReplyMessage("kbzw9ru");

        when(replyMessageService.getReplyMessageV2(message)).thenReturn(ResponseEntity.ok(replyMessage));

         mockMvc.perform(MockMvcRequestBuilders.get("/v2/reply/{message}",message))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(replyMessage)));

    }

    @Test
    public void testReplyMessageV2_Rule2() throws Exception {
        //Request input
        String message = "12-kbzw9ru";

        //Expected output
        ReplyMessage replyMessage = new ReplyMessage("5a8973b3b1fafaeaadf10e195c6e1dd4");


        when(replyMessageService.getReplyMessageV2(message)).thenReturn(ResponseEntity.ok(replyMessage));

        mockMvc.perform(MockMvcRequestBuilders.get("/v2/reply/{message}",message))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(replyMessage)));

    }
    @Test
    public void testReplyMessageV2_InvalidCase() throws Exception {
        //Request input
        String message = "13-kbzw9ru";

        //Expected output
        ReplyMessage replyMessage = new ReplyMessage("Invalid input");


        when(replyMessageService.getReplyMessageV2(message)).thenReturn(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(replyMessage));

        mockMvc.perform(MockMvcRequestBuilders.get("/v2/reply/{message}",message))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(replyMessage)));

    }

}
