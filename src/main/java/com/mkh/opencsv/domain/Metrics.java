package com.mkh.opencsv.domain;

import com.opencsv.bean.*;

import java.util.Date;

public class Metrics {

    /*@CsvBindByPosition(position = 5, required = true)
    @CsvDate("yyyy-MM-dd HH:mm:ss")
    private Date from;
    @CsvBindByPosition(position = 6, required = true)
    @CsvDate("yyyy-MM-dd HH:mm:ss") //2023-10-8 14:00:00
    private Date to;*/

    @CsvBindByPosition(position = 5, required = true)
    @CsvDate("yyyy-MM-dd'T'HH:mm'Z'")
    private Date time;
    /*@CsvBindByPosition(position = 6, required = true)
    private String to;*/
    @CsvBindByPosition(position = 6, required = true, capture = "([^\\.]+)")
    //@CsvBindAndSplitByName(elementType = Integer.class, splitOn = ".")
    //@CsvNumber()
    private String count;

    private String type;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    /*public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }*/
}
