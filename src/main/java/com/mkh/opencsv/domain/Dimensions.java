package com.mkh.opencsv.domain;

import com.opencsv.bean.CsvBindByPosition;

public class Dimensions {

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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }
}
