package com.mkh.opencsv.domain;

import com.opencsv.bean.CsvBindByPosition;

public class Dimensions {

    @CsvBindByPosition(position = 0, required = true)
    private String organization;
    @CsvBindByPosition(position = 1, required = true)
    private String environment;
    @CsvBindByPosition(position = 2, required = true)
    private String apiproxy;
    @CsvBindByPosition(position = 3, required = true)
    private String api_product;
    @CsvBindByPosition(position = 4, required = true)
    private String developer_app;


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

    public String getApi_product() {
        return api_product;
    }

    public void setApi_product(String api_product) {
        this.api_product = api_product;
    }

    public String getDeveloper_app() {
        return developer_app;
    }

    public void setDeveloper_app(String developer_app) {
        this.developer_app = developer_app;
    }

    public String getApiproxy() {
        return apiproxy;
    }

    public void setApiproxy(String apiproxy) {
        this.apiproxy = apiproxy;
    }
}
