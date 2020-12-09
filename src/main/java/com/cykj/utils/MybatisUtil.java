package com.cykj.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
    private static final String CONFIG_PATH="mybatis-config.xml";
    private SqlSessionFactory ssf = null;
    private SqlSession session = null;
    private static MybatisUtil util = null;
    private MybatisUtil(){
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(CONFIG_PATH);
            ssf = new SqlSessionFactoryBuilder().build(reader);
            session = ssf.openSession(false);//打开事务,false:取消自动提交，默认自动提交
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //获取MybatisUtil单例
    public static synchronized MybatisUtil getInstance(){
        if (null==util){
            synchronized (MybatisUtil.class){
                util=new MybatisUtil();
            }
        }
        return util;
    }

    public synchronized SqlSession getSession(){
        return session;
    }

}

