package com.aliyun.rtc.whiteboard.models;
import lombok.Data;

/**
 * 回调用户鉴权入参
 */
@Data
public class UserPermissionCallbackRequest extends CallbackCommonArgs {

    /**
     * 打开白板的用户ID
     */
    private String userId;

    /**
     * 白板文档标识符
     */
    private String docKey;

    /**
     * 权限类型，可选值：read/edit
     */
    private String permissionType;
}
