package org.example.sq.part2.ch12.repositories;

import org.example.sq.part2.ch12.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase VALUES(DEFAULT,?,?)";
        jdbcTemplate.update(sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    public List<Purchase> getPurchase() {
        String sql = "SELECT * from purchase";

        RowMapper<Purchase> rowMapper = (r,i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setPrice(r.getBigDecimal("price"));
            rowObject.setProduct(r.getString("product"));
            return rowObject;
        };
        return jdbcTemplate.query(sql,rowMapper);
    }
}
