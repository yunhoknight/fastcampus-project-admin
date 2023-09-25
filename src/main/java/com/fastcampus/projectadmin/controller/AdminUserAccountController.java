package com.fastcampus.projectadmin.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.data.domain.Sort.Direction.DESC;

@RequestMapping("/admin/members")
@Controller
public class AdminUserAccountController {

    @GetMapping
    public String members(
            @PageableDefault(size = 10, sort = "createdAt", direction = DESC)Pageable pageable,
            Model model
            ) {
        return "admin/members";
    }
}
