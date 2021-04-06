package com.aliyun.rtc.whiteboard.controller;

import com.aliyun.rtc.whiteboard.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.rtc.whiteboard.util.SignUtil;
import com.aliyun.rtc.whiteboard.util.RandomStringUtil;
import com.aliyun.rtc.whiteboard.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 应用 Controller
 */
@Slf4j
@RestController
@RequestMapping("/app")
public class AppController {

    // 控制台配置的回调url, 假如将本工程部署在ecs xx.xx.xx.xx, 应为http://xx.xx.xx.xx:7001/app/callback
    @Value("${app.callback.url}")
    private String appCallbackUrl;

    // 控制台配置的回调鉴权码
    @Value("${app.callback.auth}")
    private String appCallbackAuth;

    /**
     * 接收互动白板服务回调请求并进行处理
     * POST https://{open_host}/app/callback
     *
     * @param request HttpServletRequest
     * @return ResponseResult
     */
    @RequestMapping(value = "/callback")
    public ResponseResult callback(HttpServletRequest request) {

        // 解析回调公共入参, 回调入参请参考官方文档，公共入参requestId, eventType, 不同的eventType代表不同回调类型，入参也不同
        CallbackCommonArgs callbackCommonArgs = new CallbackCommonArgs();
        RequestUtil.requestToParamObject(request, callbackCommonArgs);
        String requestId = callbackCommonArgs.getRequestId();
        String eventType = callbackCommonArgs.getEventType();

        // 验证签名（可选，根据控制台设置的回调鉴权码进行鉴权，保证回调安全性）
        boolean verify = false;
        try {
            verify = SignUtil.isvVerifySign(appCallbackAuth, "POST", appCallbackUrl, request);
        } catch (UnsupportedEncodingException e) {
            log.error("callbackTestController " + "UnsupportedEncoding Error", e);
        }
        // 回调鉴权失败响应
        if (!verify) {
            return ResponseResult.getErrorResult(requestId, "1000", "ISVCallBackVerifyFailure");
        }

        //根据eventType处理不同类型的回调
        switch (eventType) {

            // 用户权限回调处理
            case "userPermissionCallback":{
                // 解析入参
                UserPermissionCallbackRequest userPermissionCallbackRequest = new UserPermissionCallbackRequest();
                RequestUtil.requestToParamObject(request, userPermissionCallbackRequest);

                // 业务逻辑:用户鉴权
                // ...
                boolean permission = true; // 假设所有user都具有读写权限

                return ResponseResult.getSuccessResult(requestId, permission);
            }
            // 白板元信息回调处理
            case "whiteBoardProfileCallback": {
                // 解析入参
                WhiteBoardProfileCallbackRequest whiteBoardProfileCallbackRequest = new WhiteBoardProfileCallbackRequest();
                RequestUtil.requestToParamObject(request, whiteBoardProfileCallbackRequest);

                // 业务逻辑：获取白板名
                // ...
                WhiteBoardProfileCallbackResult whiteBoardProfileCallbackResult = new WhiteBoardProfileCallbackResult();
                whiteBoardProfileCallbackResult.setName("CallBackTestWhiteBoard");  // 返回测试白板名
                return ResponseResult.getSuccessResult(requestId, whiteBoardProfileCallbackResult);
            }
            // 用户元信息回调处理
            case "userProfileCallback": {
                // 解析入参
                UserProfileCallbackRequest userProfileCallbackRequest = new UserProfileCallbackRequest();
                RequestUtil.requestToParamObject(request, userProfileCallbackRequest);

                // 业务逻辑：获取用户信息
                // ...

                //返回测试用户信息
                String userIds = userProfileCallbackRequest.getUserIds();
                String[] userIdArray = userIds.split(",");

                List<UserProfile> userProfileList = new ArrayList<>();
                Random random = new Random(System.currentTimeMillis());
                for (String userId : userIdArray) {
                    UserProfile userProfile = new UserProfile();
                    String randomNick = RandomStringUtil.getRandomName(random);
                    userProfile.setUserId(userId);
                    userProfile.setNick(randomNick);
                    userProfile.setNickPinyin("Pinyin_" + randomNick);
                    userProfile.setAvatarUrl("http://www.avatarset/" + randomNick + ".jpg");
                    userProfileList.add(userProfile);
                }

                UserProfileCallbackResult userProfileCallbackResult = new UserProfileCallbackResult();
                userProfileCallbackResult.setUserProfileList(userProfileList);
                return ResponseResult.getSuccessResult(requestId, userProfileCallbackResult);
            }
            default:
                return ResponseResult.getErrorResult(requestId, "1001", "ISVCallBackEventTypeError");
        }
    }
}