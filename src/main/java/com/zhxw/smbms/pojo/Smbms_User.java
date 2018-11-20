package com.zhxw.smbms.pojo;


import org.springframework.stereotype.Repository;
import sun.awt.geom.AreaOp;

import java.util.Calendar;
import java.util.Date;

@Repository
public class Smbms_User {

    private long id;
    private String usercode;
    private String username;
    private String userpassword;
    private long gender;
    private Date birthday;
    private int age;//年龄

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String phone;
    private String address;
    private long userrole;
    private long createdby;
    private Date creationdate;
    private long modifyby;
    private Date modifydate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }


    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
/*              Calendar c = Calendar.getInstance();//可以对每个时间域单独修改   
                int year = c.get(Calendar.YEAR);
                this.birthday= year - Integer.parseInt(birthday.toString().substring(0,4));*/
        this.birthday = birthday;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public long getUserrole() {
        return userrole;
    }

    public void setUserrole(long userrole) {
        this.userrole = userrole;
    }


    public long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(long createdby) {
        this.createdby = createdby;
    }


    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }


    public long getModifyby() {
        return modifyby;
    }

    public void setModifyby(long modifyby) {
        this.modifyby = modifyby;
    }


    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

}
