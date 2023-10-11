package com.mkh.opencsv.dto;

import java.util.Date;

public class MetricsDTO {

    private String time;
    //private Date to;
    private String count;

    private String type;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /*public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }*/

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
