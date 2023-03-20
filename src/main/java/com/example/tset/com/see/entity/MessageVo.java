package com.example.tset.com.see.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * 消息体
 *
 * @author Lenovo
 * @date 2022/5/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageVo {
    public MessageVo(@NotNull String clientId, @NotNull String data) {
        this.clientId = clientId;
        this.data = data;
    }

    /**
     * 客户端id
     */
    @NotNull
    private String clientId;
    /**
     * 传输数据体(json)
     */
    @NotNull
    private String data;
    /**
     * 系统发送信息的时间
     */
    private Long time = System.currentTimeMillis();
    /**
     * 来自谁的消息
     */
    @NotNull
    private String fromId;
}
