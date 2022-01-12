package org.example.getPojo;


import com.fasterxml.jackson.databind.ObjectMapper;

public class GetOutputObj {

    private String page;
    private String per_page;
    private String total;
    private String total_pages;
    private GetDataObj[] data;
    private GetSupportObj support;
    private ObjectMapper mapper;

    public GetOutputObj() {

    }

    public GetOutputObj(String page, String per_page, String total, String total_pages, String data, String support) throws Exception {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.mapper = new ObjectMapper();
        this.data = mapper.readValue(data, GetDataObj[].class);
        this.support = mapper.readValue(support, GetSupportObj.class);
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

    public GetDataObj[] getData() {
        return data;
    }

    public GetSupportObj getSupport() {
        return support;
    }
}
