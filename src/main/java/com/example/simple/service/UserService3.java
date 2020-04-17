package com.example.simple.service;

import com.example.simple.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserService3 {
    @Autowired
    private UserMapper userMapper;
    /**
     * ru隔离级别的事务，可能出现脏读，不可避免不可重复读，幻读
     *
     * @param id
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED, rollbackFor = Exception.class)
    public void updateId(int id) throws InterruptedException {
        userMapper.updateUserPassword(id);
        Thread.sleep(100000);
        throw new RuntimeException("开始进行回滚");
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED, rollbackFor = Exception.class)
    public void selectId() throws InterruptedException {
        int id = userMapper.returnId();
        log.info("此时读取的 id 为 {}",id);
    }
}
