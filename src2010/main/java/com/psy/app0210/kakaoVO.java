package com.psy.app0210;

public class kakaoVO {

    //필드 생성
    private int tv_profile;
    private  String tv_name;
    private  String tv_content;
    private  String tv_time;

    public kakaoVO(){}

    //생성자 메소드
    public kakaoVO(int tv_profile, String tv_name, String tv_content, String tv_time) {
        this.tv_profile = tv_profile;
        this.tv_name = tv_name;
        this.tv_content = tv_content;
        this.tv_time = tv_time;
    }

    // getter/setter 메소드
    public int getTv_profile() {
        return tv_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public String getTv_content() {
        return tv_content;
    }

    public String getTv_time() {
        return tv_time;
    }

    public void setTv_profile(int tv_profile) {
        this.tv_profile = tv_profile;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }

    public void setTv_time(String tv_time) {
        this.tv_time = tv_time;
    }
}
