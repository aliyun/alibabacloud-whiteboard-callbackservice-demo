package com.aliyun.rtc.whiteboard.models;

import lombok.Data;

import java.io.Serializable;

/**
 * 回调白板信息出参
 */
@Data
public class WhiteBoardProfileCallbackResult implements Serializable {

    /**
     * 白板名称
     */
    private String name;
}
