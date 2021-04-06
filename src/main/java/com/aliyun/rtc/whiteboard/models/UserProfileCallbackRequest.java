package com.aliyun.rtc.whiteboard.models;

import lombok.Data;

/**
 * 回调用户信息入参
 */
@Data
public class UserProfileCallbackRequest extends CallbackCommonArgs {

    /**
     * 需要获取信息的用户ID列表，可以传多个，逗号(,)分隔
     */
    private String userIds;

    /**
     * 白板标识符
     */
    private String docKey;
}
