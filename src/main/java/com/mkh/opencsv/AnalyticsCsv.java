package com.mkh.opencsv;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import java.util.Date;

public class AnalyticsCsv {

    @CsvBindByPosition(position = 0, required = true)
    private String organization;
    @CsvBindByPosition(position = 1, required = true)
    private String environment;
    @CsvBindByPosition(position = 2, required = true)
    private String product;
    @CsvBindByPosition(position = 3, required = true)
    private String consumer;
    @CsvBindByPosition(position = 4, required = true)
    private String proxy;
    @CsvBindByPosition(position = 5, required = true)
    @CsvDate("yyyy-MM-dd HH:mm:ss")
    private Date from;
    @CsvBindByPosition(position = 6, required = true)
    @CsvDate("yyyy-MM-dd HH:mm:ss") //2023-10-8 14:00:00
    private Date to;
    @CsvBindByPosition(position = 7, required = true)
    private String report;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public Date getFrom() {
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
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
