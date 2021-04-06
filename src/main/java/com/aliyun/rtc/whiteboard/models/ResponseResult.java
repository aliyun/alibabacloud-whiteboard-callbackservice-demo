package com.aliyun.rtc.whiteboard.models;

import java.io.Serializable;

/**
 * 回调响应出参模板
 */
public class ResponseResult<T> implements Serializable {

    /**
     * 自动生成的请求ID，建议回传互动白板服务，以便日志跟踪
     */
    private String requestId;

    /**
     * 响应状态
     */
    private boolean responseSuccess;

    /**
     * 响应成功结果体
     */
    private T result;

    /**
     * 响应失败错误信息
     */
    private String errorCode;
    private String errorMsg;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isResponseSuccess() {
        return this.responseSuccess;
    }

    public void setResponseSuccess(boolean success) {
        this.responseSuccess = success;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ResponseResult() {
    }

    /**
     * 成功响应
     */
    public static <T> ResponseResult<T> getSuccessResult(String requestId, T v) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setRequestId(requestId);
        result.setResponseSuccess(true);
        result.setResult(v);
        return result;
    }

    /**
     * 错误响应
     */
    public static <T> ResponseResult<T> getErrorResult(String requestId, String errorCode, String errorMsg) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setRequestId(requestId);
        result.setResponseSuccess(false);
        result.setErrorCode(errorCode);
        result.setErrorMsg(errorMsg);
        return result;
    }

}


