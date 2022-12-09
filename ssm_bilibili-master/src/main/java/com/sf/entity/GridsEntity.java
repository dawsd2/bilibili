package com.sf.entity;


//商品实体表
public class GridsEntity {
    private String gridsID;//商品ID
    private String girdsName;//商品名字
    private String girdsjiage;//商品价格
    private String girdsimg;//商品图片地址
    private int girdskucun;//商品库存

    public String getGridsID() {
        return gridsID;
    }

    public void setGridsID(String gridsID) {
        this.gridsID = gridsID;
    }

    public String getGirdsName() {
        return girdsName;
    }

    public void setGirdsName(String girdsName) {
        this.girdsName = girdsName;
    }

    public String getGirdsjiage() {
        return girdsjiage;
    }

    public void setGirdsjiage(String girdsjiage) {
        this.girdsjiage = girdsjiage;
    }

    public String getGirdsimg() {
        return girdsimg;
    }

    public void setGirdsimg(String girdsimg) {
        this.girdsimg = girdsimg;
    }

    public int getGirdskucun() {
        return girdskucun;
    }

    public void setGirdskucun(int girdskucun) {
        this.girdskucun = girdskucun;
    }


}
