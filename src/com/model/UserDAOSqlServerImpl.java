package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class UserDAOSqlServerImpl extends JDBCUtil implements UserDAO {


    @Override
    public boolean findUser(User user) {
        Boolean flag = false;
        String sql = "SELECT * FROM t_user WHERE userName=? and password=?";
        Object[] params = {user.getUserName(), user.getPassword()};
        List<HashMap> listUser = new ArrayList<>();
        listUser = this.executeQuery(sql, params);
        if (listUser.size() > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public int insertUser(User user) {
        String sql = "INSERT INTO t_user VALUES (?,?,?,?,?,?)";
        Object[] params = {user.getUserId(), user.getUserName(), user.getPassword(), user.getEmail(), user.getGrade(), user.getPicture()};
        int n = this.executeUpdate(sql, params);
        return n;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM t_user WHERE userId = ?";
        Object[] params = {id};
        int n = this.executeUpdate(sql, params);
        return n;

    }

    @Override
    public int searchCount() {
        int rowCount = 0;
        int pageSize = 3;
        int pageCount;
        List<HashMap> lists = new ArrayList<>();
        String sql = "SELECT * FROM t_user";
        lists = this.executeQuery(sql,null);
        rowCount = lists.size();
        if (rowCount % pageSize == 0){
            pageCount = rowCount / pageSize;
        }else {
            pageCount = rowCount / pageSize + 1;
        }
        return pageCount;
    }

    @Override
    public int update(User user) {
        //修改用户
        String sql = "UPDATE t_user SET userName=?,password=?,email=?, grade =? WHERE userId =?";
        Object[] params = {user.getUserName(),user.getPassword(),user.getEmail(),user.getGrade(),user.getUserId()};
        return this.executeUpdate(sql,params);

     }

    @Override
    public int addUser(User user) {
        //添加用户功能
      String sql = "INSERT INTO t_user (userName, password,email,grade) VALUES (?,?,?,?)";
      Object[] params = {user.getUserName(),user.getPassword(),user.getEmail(),user.getGrade()};
      int n = this.executeUpdate(sql,params);
      return n;
    }



    @Override
    public int countUserId() {
        String sql = "SELECT COUNT(userId) FROM t_user";
        int n = this.executeUpdate(sql);
        return n;
    }

    @Override
    public List<HashMap> search(int pageSize, int ePageSize) {
        List<HashMap> lists = new ArrayList<>();
        String sql = "SELECT  * FROM t_user LIMIT ?,?";
        Object[] params = {pageSize,ePageSize};
        lists= this.executeQuery(sql,params);
        return lists;
    }
}