package top.hellooooo.codereceptionserver.pojo;

/**
 * @Author Q
 * @Date 17/09/2020 14:48
 * @Description
 */
public class CommonResponse<T> {
    private Boolean success;
    private T data;
    private String message;

    public CommonResponse() {
    }

    public CommonResponse(Boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
