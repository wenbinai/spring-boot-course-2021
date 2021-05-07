package edu.nefu.mybatisdemo.example07;

import edu.nefu.mybatisdemo.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService07 {
    @Autowired
    private AccountMapper07 accountMapper07;

    public Account buy(Integer uid, float expense) {
        Account account = accountMapper07.selectById(uid);
        float balance = account.getBalance() - expense;
        if (balance < 0) {
            throw new RuntimeException("余额不足");
        }
        account.setBalance(balance);
        int update = accountMapper07.updateById(account);
        if (update == 0) {
            throw new RuntimeException("乐观锁, 余额不足");
        }
        return account;
    }
}
