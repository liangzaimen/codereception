package top.hellooooo.codereceptionserver.pojo;

import java.util.Date;

/**
 * @Author Q
 * @Date 2020/9/19 9:00 PM
 * @Description
 */
public class PersonMobile {
    private Integer id;
    private String phoneNum;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
