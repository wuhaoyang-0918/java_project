package com.example.Result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author why
 * @date 2021/10/22 13:48
 * @PackageName com.example.Result
 * @description
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
//　  前端的同事要求说尽量不要有null，可有为空串“” 或者 0 或者 []， 但尽量不要null。
//　　所以@JsonInclude(Include.NON_NULL) 这个注解放在类头上就可以解决。 实体类与json互转的时候 属性值为null的不参与序列化
public class ResponseResult<T> {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息，如果有错误时，前端可以获取该字段进行提示
     */
    private String msg;
    /**
     * 查询到的结果数据，
     */
    private T data;

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }
    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
