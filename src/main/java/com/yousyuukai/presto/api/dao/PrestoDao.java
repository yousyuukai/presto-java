package com.yousyuukai.presto.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PrestoDao {

    @Autowired
    @Qualifier("prestoJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> query(String sql) {
        return jdbcTemplate.queryForList(sql);
    }
}
