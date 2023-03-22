package com.example.tset.com.see.service;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author Lenovo
 * @date 2022/5/6
 */
public interface SseService {
    /**
     * 创建连接
     *
     * @param clientId 客户端ID
     */
    SseEmitter createConnect(String clientId);

    /**
     * 根据客户端id获取SseEmitter对象
     *
     * @param clientId 客户端ID
     */
    SseEmitter getSseEmitterByClientId(String clientId);

    /**
     * 发送消息给所有客户端
     *
     * @param msg 消息内容
     */
    void sendMessageToAllClient(String msg);

    /**
     * 给指定客户端发送消息
     *
     * @param clientId 客户端ID
     * @param msg      消息内容
     */
    void sendMessageToOneClient(String clientId, String msg, String fromId);

    /**
     * 关闭连接
     *
     * @param clientId 客户端ID
     */
    void closeConnect(String clientId);
}

