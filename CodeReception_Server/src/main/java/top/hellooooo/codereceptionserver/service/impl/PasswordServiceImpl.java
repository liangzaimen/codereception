package top.hellooooo.codereceptionserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hellooooo.codereceptionserver.mapper.PasswordMapper;
import top.hellooooo.codereceptionserver.pojo.MessageEntity;
import top.hellooooo.codereceptionserver.service.PasswordService;

/**
 * @Author Q
 * @Date 19/09/2020 22:24
 * @Description
 */
@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private PasswordMapper passwordMapper;

    @Override
    public MessageEntity getMessageByPersonId(Integer id) {
        return passwordMapper.getMessageByPersonId(id);
    }

    @Override
    public MessageEntity getMessageByPhoneNum(String phoneNum) {
        return passwordMapper.getMessageByPhoneNum(phoneNum);
    }

}
