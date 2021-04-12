package com.aliyun.rtc.whiteboard.models;

import lombok.Data;

/**
 * 合法域名校验失败通知-回调入参
 */
@Data
public class HostCheckCallbackRequest extends CallbackCommonArgs{

    /**
     * 白板文档标识符
     */
    private String docKey;

    /**
     * 客户端访问白板时的域名
     */
    private String originHost;

    /**
     * 域名校验失败信息
     */
    private String hostErrorMsg;
}
