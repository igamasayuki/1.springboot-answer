package com.example.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jdbc")
public class JdbcController {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @GetMapping("/execute")
    public String execute() {
        // SQLを定義する
        String sql = """
                SELECT COUNT(*)
                  FROM employees
                 WHERE id = :firstId OR id = :secondId
                """;
        // SQLのプレースホルダに値をセットする
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("firstId", 1)
                .addValue("secondId", 3);
        // SQLを実行して結果を取得する
        Integer result = template.queryForObject(sql, param, Integer.class);
        System.out.println("result = " + result);
        return "finished";
    }

}
