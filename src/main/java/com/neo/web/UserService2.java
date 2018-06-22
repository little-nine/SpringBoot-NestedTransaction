package com.neo.web;

import com.neo.entity.UserEntity;
import com.neo.enums.UserSexEnum;
import com.neo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("useService2")
public class UserService2 {
    @Autowired
    private UserMapper userMapper;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testException(){
        userMapper.insert(new UserEntity("aa2", "a123456", UserSexEnum.MAN));
//        try {
//        int i = 1 / 0;
//        }catch (Exception e){
//            System.out.println("2出异常后正常执行");
//        }
    }
}
