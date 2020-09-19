package top.hellooooo.codereceptionserver.service;

import top.hellooooo.codereceptionserver.pojo.MessageEntity;

/**
 * @Author Q
 * @Date 2020/9/19 8:52 PM
 * @Description
 */
public interface PasswordService {
    MessageEntity getMessageByPersonId(Integer id);
    MessageEntity getMessageByPhoneNum(String phoneNum);
}
