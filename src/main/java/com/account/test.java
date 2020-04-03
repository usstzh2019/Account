package com.account;

import com.account.service.AccountServiceImpl;

public class test {
    public static void main(String[] args) {
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.transfer(1234,1111,1000);
    }
}
