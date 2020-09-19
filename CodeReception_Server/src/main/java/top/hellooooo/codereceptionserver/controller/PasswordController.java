package top.hellooooo.codereceptionserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.hellooooo.codereceptionserver.pojo.CommonResponse;
import top.hellooooo.codereceptionserver.pojo.MessageEntity;
import top.hellooooo.codereceptionserver.service.PasswordService;
import top.hellooooo.codereceptionserver.util.MessagePhaser;
import top.hellooooo.codereceptionserver.util.StringUtil;

/**
 * @Author Q
 * @Date 2020/9/19 8:41 PM
 * @Description
 */
@RestController
@RequestMapping("/netkeeper/password")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/id/{personId}")
    public CommonResponse getById(@PathVariable("personId") Integer id) {
        CommonResponse<String> response = new CommonResponse<>();
        MessageEntity messageByPersonId = passwordService.getMessageByPersonId(id);
        response.setMessage(messageByPersonId.getMessage());
        response.setData(MessagePhaser.parsePassword(messageByPersonId.getMessage(), 6));
        response.setSuccess(true);
        return response;
    }

    @GetMapping("/phone/{phoneNum}")
    public CommonResponse getByPhone(@PathVariable("phoneNum") String phoneNum) {
        CommonResponse<String> response = new CommonResponse<>();
        MessageEntity messageByPersonId = passwordService.getMessageByPhoneNum(phoneNum);
        response.setMessage(messageByPersonId.getMessage());
        response.setData(MessagePhaser.parsePassword(messageByPersonId.getMessage(), 6));
        response.setSuccess(true);
        return response;
    }
}
