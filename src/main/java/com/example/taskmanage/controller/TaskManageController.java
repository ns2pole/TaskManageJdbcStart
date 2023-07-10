package com.example.taskmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


@Controller
public class TaskManageController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String index(Model model) {
        String sql = "SELECT * FROM TASKS";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        model.addAttribute("tasks", result);
        return "/task/index";
    }

}