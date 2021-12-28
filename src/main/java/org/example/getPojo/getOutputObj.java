package org.example.getPojo;


import com.fasterxml.jackson.databind.ObjectMapper;

public class getOutputObj {

    private String page;
    private String per_page;
    private String total;
    private String total_pages;
    private getDataObj[] data;
    private getSupportObj support;
    private ObjectMapper mapper;

    public getOutputObj() {

    }

    public getOutputObj(String page, String per_page, String total, String total_pages, String data, String support) throws Exception {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.mapper = new ObjectMapper();
        this.data = mapper.readValue(data, getDataObj[].class);
        this.support = mapper.readValue(support, getSupportObj.class);
    }

    public String getPage() {
        return page;
    }

    public String getPer_page() {
        return per_page;
    }

    public String getTotal() {
        return total;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public getDataObj[] getData() {
        return data;
    }

    public getSupportObj getSupport() {
        return support;
    }
}
