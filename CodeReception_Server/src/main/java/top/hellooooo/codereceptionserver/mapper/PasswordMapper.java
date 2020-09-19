package top.hellooooo.codereceptionserver.mapper;

import org.apache.ibatis.annotations.Param;
import top.hellooooo.codereceptionserver.pojo.MessageEntity;

/**
 * @Author Q
 * @Date 19/09/2020 22:09
 * @Description
 */
public interface PasswordMapper {

    MessageEntity getMessageByPersonId(@Param("id") Integer id);

    MessageEntity getMessageByPhoneNum(@Param("phoneNum") String phoneNum);
}
