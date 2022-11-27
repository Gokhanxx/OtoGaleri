package com.example.otogaleri.models;

public class iller {
    String id;
    String il;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    @Override
    public String toString() {
        return "iller{" +
                "id=" + id +
                ", il='" + il + '\'' +
                '}';
    }


}
