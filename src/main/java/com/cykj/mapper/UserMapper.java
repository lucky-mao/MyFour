package com.cykj.mapper;

import com.cykj.bean.Discuser;

import java.util.List;

public interface UserMapper {
    public int addDiscuser(Discuser discuser);
    public int deleteDiscuser(Discuser discuser);
    public int updataDiscuser(Discuser discuser);
    public List<Discuser> findAll();
}
