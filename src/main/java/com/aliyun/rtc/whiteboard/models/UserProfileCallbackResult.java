package com.aliyun.rtc.whiteboard.models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 回调用户信息出参
 */
@Data
public class UserProfileCallbackResult implements Serializable {

    /**
     * 用户信息列表
     */
    private List<UserProfile> userProfileList;
}
