package com.hyeok.back.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PingController {

    @GetMapping("/api/ping")
    public String pingTest(@RequestParam String a123)
    {
      log.info("ping!");
      log.info(a123);
      return "연결 성공!";
    }
}
