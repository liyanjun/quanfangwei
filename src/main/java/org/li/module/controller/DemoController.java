package org.li.module.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.li.module.bean.User;
import org.li.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/7.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("index")
    @ApiOperation(value = "index", httpMethod = "POST", response = org.li.module.bean.User.class, notes = "根据用户名,密码登录，获取用户对象")
    public User index(@ApiParam(required = true, name = "userName", value = "一个愉快的测试参数") @RequestParam String userName,
                        @ApiParam(required = true, name = "password", value = "另外一个愉快的测试参数")  @RequestParam String password) {
        User user = userService.findByUserName(userName);
        return user;
    }
}
