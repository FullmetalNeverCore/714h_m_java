package com.example; 
 
public class VerifData{
    private String uname;
    private String pword; 
    private String chr;

    public VerifData(String name,String pword,String chr) {
        this.uname = name;
        this.pword = pword;
        this.chr = chr;
    }

    public String getName() {
        return uname;
    }

    public void setName(String name) {
        this.uname = name;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    } 

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }
}