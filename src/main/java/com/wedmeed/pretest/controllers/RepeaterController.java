package com.wedmeed.pretest.controllers;

import com.wedmeed.pretest.model.dto.RepeatDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RepeaterController {


    @GetMapping("/repeat")
    @ResponseBody
    public RepeatDTO repeat(
            @RequestParam(name = "input", required = false, defaultValue = "Hello")
            String input) {
        return new RepeatDTO(input);
    }
}
