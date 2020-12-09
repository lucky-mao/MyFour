package com.cykj.dao;

import com.cykj.bean.Admin;
import com.cykj.bean.Discuser;
import com.cykj.mapper.LoginMapper;
import com.cykj.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class LoginDao {

    public List<Admin> adminLogin(Admin admin){
        MybatisUtil mybatisUtil = MybatisUtil.getInstance();
        SqlSession session = mybatisUtil.getSession();
        LoginMapper loginMapper = session.getMapper(LoginMapper.class);
        List<Admin> admin1= loginMapper.adminLogin(admin);
        session.close();
        return admin1;
    }
    public List<Discuser> login(Discuser discuser){
        SqlSession session = MybatisUtil.getInstance().getSession();
        LoginMapper loginMapper = session.getMapper(LoginMapper.class);
        List<Discuser> discusers = loginMapper.login(discuser);
        session.close();
        return discusers;
    }
    public int regiser(Discuser discuser){
        SqlSession session = MybatisUtil.getInstance().getSession();
        LoginMapper loginMapper = session.getMapper(LoginMapper.class);
        int in = loginMapper.regiser(discuser);
        session.commit();
        session.close();
        return in;
    }

    public int existence(Discuser discuser) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        LoginMapper loginMapper = session.getMapper(LoginMapper.class);
        int cou = loginMapper.existence(discuser);
        session.commit();
        session.close();
        return cou;
    }
}
