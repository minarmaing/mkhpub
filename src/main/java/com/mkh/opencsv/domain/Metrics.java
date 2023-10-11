package com.mkh.opencsv.domain;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import java.util.Date;

public class Metrics {

    /*@CsvBindByPosition(position = 5, required = true)
    @CsvDate("yyyy-MM-dd HH:mm:ss")
    private Date from;
    @CsvBindByPosition(position = 6, required = true)
    @CsvDate("yyyy-MM-dd HH:mm:ss") //2023-10-8 14:00:00
    private Date to;*/

    @CsvBindByPosition(position = 5, required = true)
    private String from;
    @CsvBindByPosition(position = 6, required = true)
    private String to;
    private String type;
    @CsvBindByPosition(position = 7, required = true)
    private String count;

    /*public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
