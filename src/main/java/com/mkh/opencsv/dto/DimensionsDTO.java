package com.mkh.opencsv.dto;

public class DimensionsDTO {

    private String organization;
    private String environment;
    private String api_product;
    private String developer_app;
    private String apiproxy;

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
