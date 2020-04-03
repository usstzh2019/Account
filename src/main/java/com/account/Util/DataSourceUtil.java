package com.account.Util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DataSourceUtil {

    public static DataSource getDataSourceWithC3p0(){
        ComboPooledDataSource c3p0 =new ComboPooledDataSource("mysql");

        return c3p0;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getDataSourceWithC3p0().getConnection());
    }
}
