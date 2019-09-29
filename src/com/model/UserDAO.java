package com.model;


import java.util.HashMap;
import java.util.List;

public interface UserDAO {

    //根据数据库用户名进行登录
    boolean findUser(User user);

    //增加数据库用户信息
    int insertUser(User user);

    //删除数据库信息
    int delete(int id);

    //计算页面的数目
    public int searchCount();

    //统计数据库中的用户数量
    int countUserId();
    public List<HashMap> search(int pageSize,int ePageSize);




}