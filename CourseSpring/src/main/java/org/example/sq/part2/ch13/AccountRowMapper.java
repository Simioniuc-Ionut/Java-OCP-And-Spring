package org.example.sq.part2.ch13;

import org.example.sq.part2.ch13.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setAmount(rs.getBigDecimal("amount"));
        account.setName(rs.getString("name"));
        return account;
    }
}
