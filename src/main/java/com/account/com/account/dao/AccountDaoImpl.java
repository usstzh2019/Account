package com.account.com.account.dao;

import com.account.Util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account queryAccountByCard(int cardid) throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtil.getConnection();
        Account account=runner.query(conn,"select * from account where cardid=?", new BeanHandler<Account>(Account.class),cardid);

        return account;
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        QueryRunner runner=new QueryRunner();
        Connection conn = JDBCUtil.getConnection();
        runner.update(conn,"update account set balance = ? where cardid=?",new Object[]{account.getBalance(),account.getCardid()});

    }
}
