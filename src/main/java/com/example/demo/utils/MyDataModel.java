package com.example.demo.utils;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.AbstractJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.ConnectionPoolDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;

public class MyDataModel {
    //数据模型 FileDataModel、JDBCDataModel
    public static JDBCDataModel myDataModel(){
        //数据库接口
        MysqlDataSource dataSource=new MysqlDataSource();
        JDBCDataModel jdbcDataModel=null;
        try {
            //设置数据库属性
            dataSource.setServerName("localhost");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            dataSource.setDatabaseName("test");
            //连接池
            ConnectionPoolDataSource conn=new ConnectionPoolDataSource(dataSource);
            //获取数据模型 参数1连接池，参数据2：数据库表 后面参数都是对应标里面的字段
            jdbcDataModel=new MySQLJDBCDataModel(conn,"movie_preferences","userID","movieID","preference","timestamp");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jdbcDataModel;
    }
}
