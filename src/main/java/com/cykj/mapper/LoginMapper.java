package com.cykj.mapper;

import com.cykj.bean.Admin;
import com.cykj.bean.Discuser;

import java.util.List;

public interface LoginMapper {
    public List<Admin> adminLogin(Admin admin);
    public List<Discuser> login(Discuser discuser);
    public int regiser(Discuser discuser);
    public int existence(Discuser discuser);
}
