package com.cykj.bean;

import com.cykj.mapper.UserMapper;
import com.cykj.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class Discuser {
        private int did;
        private String daccount;
        private String dpwd;
        private String sex;
        private String education;
        private String major;
        private String phone;
        private String email;

    public Discuser() {
    }

    public Discuser(int did, String daccount, String dpwd, String sex, String education, String major, String phone, String email) {
        this.did = did;
        this.daccount = daccount;
        this.dpwd = dpwd;
        this.sex = sex;
        this.education = education;
        this.major = major;
        this.phone = phone;
        this.email = email;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDaccount() {
        return daccount;
    }

    public void setDaccount(String daccount) {
        this.daccount = daccount;
    }

    public String getDpwd() {
        return dpwd;
    }

    public void setDpwd(String dpwd) {
        this.dpwd = dpwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
