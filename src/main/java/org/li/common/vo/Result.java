package org.li.common.vo;

/**
 * Created by 衍君 on 2017/3/18.
 */
public class Result {

    private static final int STATUS_SUCCESS = 1;
    private static final int STATUS_FAIL = -1;

    private Integer status;
    private String msg;
    private Object data;

    public Result(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private static Result getDefaultSuccess(String msg){
        return new Result(STATUS_SUCCESS,msg,null);
    }

    public static Result success(String msg){
        return getDefaultSuccess(msg);
    }

    public static Result fail(String msg){
        return new Result(STATUS_FAIL,msg,null);
    }

    public static Result success(String msg, Object data){
        return getDefaultSuccess(msg).setData(data);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }
}
