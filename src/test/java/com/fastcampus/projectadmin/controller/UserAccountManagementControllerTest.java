package com.fastcampus.projectadmin.controller;

import com.fastcampus.projectadmin.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 - 유저 관리")
@Import(SecurityConfig.class)
@WebMvcTest(ArticleManagementController.class)
class UserAccountManagementControllerTest {

    private final MockMvc mvc;

    public UserAccountManagementControllerTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view-GET]유저 관리 페이지 - 정상 호출")
    @Test
    public void GetUserAccountManagementPageTest() throws Exception {
        // given

        // when & then
        mvc.perform(get("/management/user-account"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("management/user-account"));

    }
}