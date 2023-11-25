package com.beta.replyservice.Controller;

import com.beta.replyservice.Services.ReplyMessageService;
import com.beta.replyservice.dto.ReplyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {

	@Autowired
	private ReplyMessageService replyMessageService;

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return new ReplyMessage(message);
	}

	@GetMapping("/v2/reply/{message}")
	public ResponseEntity<ReplyMessage> replyingV2(@PathVariable String message) {
		return replyMessageService.getReplyMessageV2(message);
	}

}