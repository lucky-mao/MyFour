package com.cykj.orm;

import com.cykj.bean.Discuser;
import com.cykj.mapper.UserMapper;
import com.cykj.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class DemoRun {
//    public static void main(String[] args){
//            SqlSession session = MybatisUtil.getInstance().getSession();
//            UserMapper userMapper=session.getMapper(UserMapper.class);
//            //实例化对象,传参入接口方法
//            Discuser discuser = new Discuser();
//            userMapper.addDiscuser(discuser);
//            //提交事务，关闭session
//            session.commit();
//            session.close();
//
//    }
}
