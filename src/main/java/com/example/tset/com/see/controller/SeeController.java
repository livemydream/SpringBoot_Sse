package com.example.tset.com.see.controller;

import com.example.tset.com.see.entity.MessageVo;
import com.example.tset.com.see.service.SseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.annotation.Resource;

    /**
     * SSE长链接
     */
    @CrossOrigin("*")
    @RestController
    @RequestMapping("/sse")
    public class SeeController {

        @Resource
        private SseService sseService;


        @CrossOrigin
        @GetMapping("/createConnect")
        public SseEmitter createConnect(String clientId) {
            return sseService.createConnect(clientId);
        }

        @CrossOrigin
        @PostMapping("/broadcast")
        public void sendMessageToAllClient(@RequestBody(required = false) String msg) {
            sseService.sendMessageToAllClient(msg);
        }

        @CrossOrigin
        @PostMapping("/sendMessage")
        public void sendMessageToOneClient(@Validated @RequestBody(required = false) MessageVo messageVo) {
            if (messageVo.getClientId().isEmpty()) {
                return;
            }
            sseService.sendMessageToOneClient(messageVo.getClientId(), messageVo.getData());
        }

        @CrossOrigin
        @GetMapping("/closeConnect")
        public void closeConnect(@RequestParam(required = true) String clientId) {
            sseService.closeConnect(clientId);
        }

    }

