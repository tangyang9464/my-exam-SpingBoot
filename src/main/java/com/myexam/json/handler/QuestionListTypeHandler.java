package com.myexam.json.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.myexam.json.Question;

import java.io.IOException;
import java.util.List;

/**
 * 自定义复杂类型处理器<br/>
 */
public class QuestionListTypeHandler extends JacksonTypeHandler {

    public QuestionListTypeHandler(Class<?> type) {
        super(type);
    }

    @Override
    protected Object parse(String json) {
        return JSON.parseArray(json, Question.class);
    }
}

