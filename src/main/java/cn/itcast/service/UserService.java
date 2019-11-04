package cn.itcast.service;

import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void save(User user){
        System.out.println("save...");
        //选择性新增,如果属性为空则该属性不会出现在insert语句上
        userMapper.insertSelective(user);
    }
}
