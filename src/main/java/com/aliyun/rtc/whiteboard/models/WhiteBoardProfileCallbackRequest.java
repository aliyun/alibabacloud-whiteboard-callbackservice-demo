package com.aliyun.rtc.whiteboard.models;

import lombok.Data;

/**
 * 回调白板信息入参
 */
@Data
public class WhiteBoardProfileCallbackRequest extends CallbackCommonArgs {

    /**
     * 白板标识符
     */
    private String docKey;
}
