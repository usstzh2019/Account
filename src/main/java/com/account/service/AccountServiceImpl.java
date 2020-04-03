package com.account.service;

import com.account.Util.JDBCUtil;
import com.account.com.account.dao.Account;
import com.account.com.account.dao.AccountDao;
import com.account.com.account.dao.AccountDaoImpl;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    @Override
    public void transfer(int fromCardId, int toCardId, int money) {
        AccountDaoImpl account=new AccountDaoImpl();
        //开启事务
        try {
            JDBCUtil.beginTransaction();
            //各种DML操作
            Account fromAccount = account.queryAccountByCard(fromCardId);//付款方
            Account toAccount=account.queryAccountByCard(toCardId);//收款方
            if(fromAccount.getBalance()>money){
                //付款方-1000
                int fromBalance=fromAccount.getBalance()-money;
                fromAccount.setBalance(fromBalance);
                account.updateAccount(fromAccount);
                fromAccount.setCardid(fromCardId);
                //收款方+1000
                int toBalance=toAccount.getBalance()+money;
                toAccount.setBalance(toBalance);
                account.updateAccount(toAccount);
                fromAccount.setCardid(toCardId);

                System.out.println("转账成功");
                //正常提交事务
                JDBCUtil.commitTransaction();
            }else {
                System.out.println("余额不足！");
            }

        } catch (SQLException e) {
            try {
                JDBCUtil.rollbackTransaction();
                System.out.println("转账失败，回滚操作");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //结束事务（正常，失败）
    }
}
