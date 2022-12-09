package com.sf.entity;

//帖子实体表
public class ForumEntity {
    private String forumID;//文章ID
    private String forumBT;//文章标题
    private String forummessage;//文章内容
    private String forumuserName;//发布人名字
    private String forumTime;//发布时间
    private String forumliebie;//发布类别
    private String forumAmount;//帖子浏览量
    private String firumhand;//头像


    public String getFirumhand() {
        return firumhand;
    }

    public void setFirumhand(String firumhand) {
        this.firumhand = firumhand;
    }

    public String getForumID() {
        return forumID;
    }

    public void setForumID(String forumID) {
        this.forumID = forumID;
    }

    public String getForumBT() {
        return forumBT;
    }

    public void setForumBT(String forumBT) {
        this.forumBT = forumBT;
    }

    public String getForummessage() {
        return forummessage;
    }

    public void setForummessage(String forummessage) {
        this.forummessage = forummessage;
    }

    public String getForumuserName() {
        return forumuserName;
    }

    public void setForumuserName(String forumuserName) {
        this.forumuserName = forumuserName;
    }

    public String getForumTime() {
        return forumTime;
    }

    public void setForumTime(String forumTime) {
        this.forumTime = forumTime;
    }

    public String getForumliebie() {
        return forumliebie;
    }

    public void setForumliebie(String forumliebie) {
        this.forumliebie = forumliebie;
    }

    public String getForumAmount() {
        return forumAmount;
    }

    public void setForumAmount(String forumAmount) {
        this.forumAmount = forumAmount;
    }
}
