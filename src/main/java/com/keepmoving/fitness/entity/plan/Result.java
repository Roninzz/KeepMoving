package com.keepmoving.fitness.entity.plan;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:规定了返回的数据格式
 * @date 2019/9/24 0024
 */
public class Result {
    private CodeStatus codeStatus;

    private boolean flag;//执行成功,true

    private String message;//描述一下当前正在执行的操作

    private Object data;//有可能是需要查询,查询出来的对象

    public Result() {
    }

    public Result(CodeStatus codeStatus, boolean flag, String message) {
        this.codeStatus = codeStatus;
        this.flag = flag;
        this.message = message;
    }

    public Result(CodeStatus codeStatus, boolean flag, String message, Object data) {
        this.codeStatus = codeStatus;
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public CodeStatus getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(CodeStatus codeStatus) {
        this.codeStatus = codeStatus;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("codeStatus=").append(codeStatus);
        sb.append(", flag=").append(flag);
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}