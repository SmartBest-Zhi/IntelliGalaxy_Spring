package cn.yczbest.galaxy.common;

import lombok.Data;

@Data
public class BaseResponse {
    private int code;
    private String message;
    private Object data;

    public BaseResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResponse Success(Object data) {
        return new BaseResponse(200, "SUCCESS", data);
    }

    public static <T> BaseResponse Error(String message) {
        return new BaseResponse(200, message, null);
    }

}
