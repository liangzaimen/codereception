package top.hellooooo.codereceptionserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.hellooooo.codereceptionserver.pojo.CommonResponse;

/**
 * @Author Q
 * @Date 2020/9/19 8:41 PM
 * @Description
 */
@RestController
@RequestMapping("/netkeeper/password")
public class PasswordController {

    @GetMapping("/id/{personId}")
    public CommonResponse getById(@PathVariable("personId") Integer id) {
        CommonResponse<String> response = new CommonResponse<>();

        return response;
    }
}
