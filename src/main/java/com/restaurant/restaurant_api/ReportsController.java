package com.restaurant.restaurant_api;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportsController {

    private final JdbcTemplate jdbcTemplate;

    public ReportsController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/reports/daily-revenue")
    public List<Map<String, Object>> dailyRevenue() {
        return jdbcTemplate.queryForList(
            "SELECT DATE(o.order_date) AS tag, SUM(oi.quantity * m.price) AS umsatz " +
            "FROM orders o " +
            "JOIN order_items oi ON o.order_id = oi.order_id " +
            "JOIN menu_items m ON oi.item_id = m.item_id " +
            "GROUP BY DATE(o.order_date) ORDER BY tag");
    }

    @GetMapping("/reports/top-items")
    public List<Map<String, Object>> topItems() {
        return jdbcTemplate.queryForList(
            "SELECT m.name AS gericht, SUM(oi.quantity) AS anzahl " +
            "FROM order_items oi " +
            "JOIN menu_items m ON oi.item_id = m.item_id " +
            "GROUP BY m.name ORDER BY anzahl DESC");
    }

    @GetMapping("/reports/orders-per-customer")
    public List<Map<String, Object>> ordersPerCustomer() {
        return jdbcTemplate.queryForList(
            "SELECT c.name AS kunde, COUNT(o.order_id) AS anzahl_bestellungen " +
            "FROM customers c " +
            "JOIN orders o ON c.customer_id = o.customer_id " +
            "GROUP BY c.name ORDER BY anzahl_bestellungen DESC");
    }
}