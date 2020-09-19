package top.hellooooo.codereceptionserver.pojo;

import java.util.Date;

/**
 * @Author Q
 * @Date 2020/9/19 8:58 PM
 * @Description
 */
public class MessageEntity {
    private Integer id;
//    直接保存短信内容
    private String message;
    private Date createTime;
    private String phoneNum;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
