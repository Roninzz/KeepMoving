package com.keepmoving.fitness.dto;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 接受页面传输的每天的计划信息
 */
public class PlanOfDayDTO {
    private Integer pid;
    private String did;
    private String dayTitle;

    public PlanOfDayDTO(){}

    public PlanOfDayDTO(Integer pid, String did, String dayTitle) {
        this.pid = pid;
        this.did = did;
        this.dayTitle = dayTitle;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDayTitle() {
        return dayTitle;
    }

    public void setDayTitle(String dayTitle) {
        this.dayTitle = dayTitle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanOfDayDTO{");
        sb.append("pid=").append(pid);
        sb.append(", did='").append(did).append('\'');
        sb.append(", dayTitle='").append(dayTitle).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
