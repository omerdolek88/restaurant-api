package com.restaurant.restaurant_api;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    private final JdbcTemplate jdbcTemplate;

    public MenuController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/menu")
    public List<Map<String, Object>> getMenu() {
        return jdbcTemplate.queryForList("SELECT item_id, name, price FROM menu_items ORDER BY item_id");
    }
}