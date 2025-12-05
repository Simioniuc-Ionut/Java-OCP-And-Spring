package org.example.sq.part2.ch13.repository;

import org.example.sq.part2.ch13.AccountRowMapper;
import org.example.sq.part2.ch13.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {
    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(long id) {
        String sql = "SELECT * FROM account WHERE id = ?";

//        RowMapper<Account> rowMapper = (r, i) -> {
//            Account account = new Account();
//            account.setId(r.getInt("id"));
//            account.setAmount(r.getBigDecimal("amount"));
//            account.setName(r.getString("name"));
//            return account;
//        };
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }

    public List<Account> findAllAccounts() {
        String sql = "SELECT * FROM account";
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbcTemplate.update(sql, amount, id);
    }
}
