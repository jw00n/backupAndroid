package com.example.ex220319;

public class DataVO {

    private String data1;
    private String data2;
    private String data3;

    public DataVO(String data1, String data2, String data3) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

    public DataVO() {}

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public String getData3() {
        return data3;
    }
}
