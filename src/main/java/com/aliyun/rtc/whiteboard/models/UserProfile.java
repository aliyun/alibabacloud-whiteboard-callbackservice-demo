package com.aliyun.rtc.whiteboard.models;

import lombok.Data;
import java.io.Serializable;

/**
 * 用户信息数据模型
 */
@Data
public class UserProfile implements Serializable {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 头像图片地址
     */
    private String avatarUrl;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 昵称拼音
     */
    private String nickPinyin;
}
