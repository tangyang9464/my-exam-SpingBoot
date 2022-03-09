package com.myexam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntity<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> ResponseEntity<T> success(){
        return new ResponseEntity<>(200,"",null);
    }
    public static <T> ResponseEntity<T> success(T data){
        return new ResponseEntity<>(200,"",data);
    }
    public static <T> ResponseEntity<T> fail(String msg){
        return new ResponseEntity<> (400,msg,null);
    }
}
