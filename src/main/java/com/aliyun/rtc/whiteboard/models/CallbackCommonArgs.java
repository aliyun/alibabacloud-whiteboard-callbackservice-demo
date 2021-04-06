package com.aliyun.rtc.whiteboard.models;
import lombok.Data;

/**
 * 回调公共入参
 */
@Data
public class CallbackCommonArgs {

    /**
     * 请求ID
     */
    private String requestId;

    /**
     * 回调类型
     */
    private String eventType;
}
