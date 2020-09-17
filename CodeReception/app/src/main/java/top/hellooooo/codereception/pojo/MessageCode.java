package top.hellooooo.codereception.pojo;

import java.util.Date;

/**
 * @Author Q
 * @Date 17/09/2020 14:45
 * @Description
 */
public class MessageCode {
    private Integer id;
    private String message;
    private Date expireTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
