package com.other.database;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer;

import java.sql.*;

/**
 * jdbc数据库模拟插入数据
 */
public class SqlMock {
    public static void main(String[] args) {
        try{
            // 连接SQLite的JDBC
            String url = "jdbc:sqlite:D:/project.db";
            String diverClassName = "org.sqlite.JDBC";
            // 加载驱动
            Class.forName(diverClassName);
            Connection conn = DriverManager.getConnection(url);
            Statement stm = conn.createStatement();
            stm.executeUpdate("drop table user");
            stm.executeUpdate("create table user (\n" +
                    "\tid integer primary key autoincrement,\n" +
                    "\tname varchar(50),\n" +
                    "\tpassword varchar(50),\n" +
                    "\tnickname varchar(50)\n" +
                    "\t);");

            PreparedStatement prep1 = conn.prepareStatement("delete from user");
            prep1.executeUpdate();
            prep1 = conn.prepareStatement("delete from sqlite_sequence");
            prep1.executeUpdate();
            prep1.close();

            PreparedStatement prep = conn.prepareStatement("insert into user(name,password,nickname) values(?,?,?)");
            for (int i = 0; i < 100; i++) {
                prep.setString(1,RandomStringUtils.randomAlphabetic(5));
                prep.setString(2,RandomStringUtils.randomAlphabetic(5));
                prep.setString(3,RandomStringUtils.randomAlphabetic(5));
                prep.executeUpdate();
            }
            prep.close();
            conn.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
