package com.tujuhsembilan.assessmentproject;

public class DataMember {

    private String photoList;
    private String nameList;
    private String roleList;


    DataMember(String photoList, String nameList, String roleList){
        this.photoList = photoList;
        this.nameList = nameList;
        this.roleList = roleList;
    }

    public String getPhotoList() {
        return this.photoList;
    }

    public String getNameList() {
        return this.nameList;
    }

    public String getRoleList() {
        return this.roleList;
    }
}
