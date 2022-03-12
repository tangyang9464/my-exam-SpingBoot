package com.myexam.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mybatis-plus自动填充类
 * @author ty
 * @date 2021/2/2 20:33
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //插入填充
    @Override
    public void insertFill(MetaObject metaObject) {
        //这里createTime就是你需要填充字段（实体类中）
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
    }
    //更新填充
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}