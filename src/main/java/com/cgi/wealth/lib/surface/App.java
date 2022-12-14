package com.cgi.wealth.lib.surface;

public class App {
    public static void main(String[] args) {
        XClass xClass = new XClass("boo");
        YClass yClass = new YClass();
        ZClass zClass = new ZClass(xClass, yClass);
    }
}

class XClass {
    private String x;
    public XClass(String x){
        this.x = x;
    }
    public String getX(){
        return this.x;
    }
}

class YClass {
    private String y;
    public void setY(String y){
        this.y = y;
    }
    public String gety(){
        return this.y;
    }

}

class ZClass {
    private XClass x;
    private YClass y;
    public ZClass(XClass x, YClass y){
        this.x = x;
        this.y = y;
    }
    public XClass getXClass(){
        return this.x;
    }
    public YClass getYClass(){
        return this.y;
    }
}