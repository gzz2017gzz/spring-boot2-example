package com.gzz.controller;

import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.gzz.config.WebSocketServer;

@RestController
public class DemoController {

	@GetMapping("index")
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("请求成功");
	}

	@GetMapping("page")
	public ModelAndView page() {
		return new ModelAndView("websocket");
	}

	@RequestMapping("/push/{toUserId}")
	public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
		WebSocketServer.sendInfo(message, toUserId);
		return ResponseEntity.ok("MSG SEND SUCCESS");
	}
}
