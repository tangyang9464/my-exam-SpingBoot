package com.myexam.json.handler;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.myexam.json.Question;
import com.myexam.json.StudentAnswer;

public class StudentAnswerTypeHandler extends JacksonTypeHandler {
    public StudentAnswerTypeHandler(Class<?> type) {
        super(type);
    }

    @Override
    protected Object parse(String json) {
        return JSON.parseArray(json, StudentAnswer.class);
    }
}
