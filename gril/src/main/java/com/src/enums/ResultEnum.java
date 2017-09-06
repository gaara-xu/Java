package com.src.enums;



/**
 * Created by Gaara_Xu
 * on 2017/9/6.
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    HAVENOGRILFRIEND(203,"找不到对象!"),
    TRUEERREY_1(200,"这个小于10"),
    TRUEERREY_2(201,"between 10 and 16 "),
    TRUEERREY_3(202,"this is more than 16"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
