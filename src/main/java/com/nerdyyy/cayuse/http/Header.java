package com.nerdyyy.cayuse.http;

public class Header {
    public String key;
    public String value;

    public Header(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + ": " + value;
    }
}
