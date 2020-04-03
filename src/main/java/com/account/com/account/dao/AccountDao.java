package com.account.com.account.dao;

import java.sql.SQLException;


public interface AccountDao {
    //根据卡号查询账户
    Account queryAccountByCard(int cardid) throws SQLException;
    //修改账户
    void updateAccount(Account account) throws SQLException;
}
