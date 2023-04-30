package com.example; 
 
public class NNvals{
    private String rnd;
    private String len;
    private String ppen; 
    private String fpen; 

    public NNvals(String rnd,String len,String ppen,String fpen) {
        this.rnd = rnd;
        this.len = len;
        this.ppen = ppen;
        this.fpen = fpen;
    }

    public String getRnd() {
        return rnd;
    }

    public void setRnd(String content) {
        this.rnd = content;
    }


    public String getLen() {
        return len;
    }

    public void setLen(String content) {
        this.len = content;
    }


    public String getPpen() {
        return ppen;
    }

    public void setPpen(String content) {
        this.ppen = ppen;
    }


    public String getFpen() {
        return fpen;
    }

    public void setFpen(String content) {
        this.fpen = content;
    }
}