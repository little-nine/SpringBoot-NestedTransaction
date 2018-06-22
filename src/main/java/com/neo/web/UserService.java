package com.neo.web;

import com.neo.entity.UserEntity;
import com.neo.enums.UserSexEnum;
import com.neo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("useService")
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService2 userService2;
    @Transactional
    public void test1(){
        userMapper.insert(new UserEntity("aa1", "a123456", UserSexEnum.MAN));
        userMapper.insert(new UserEntity("bb1", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new UserEntity("cc1", "b123456", UserSexEnum.WOMAN));
        userService2.testException();
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            System.out.println("异常处理掉了");
        }
        System.out.println("1出异常后正常执行");
    }
}
