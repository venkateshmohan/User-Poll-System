package com.company2.socialpolling;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HTTPRequest {
	@RequestMapping("/")
    public @ResponseBody String polling() {
        return "User polling";
    }
}
