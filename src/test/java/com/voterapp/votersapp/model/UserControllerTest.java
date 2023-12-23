package com.voterapp.votersapp.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.voterapp.votersapp.auth.AuthRegistrationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;


    @Test
    public void testController () throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        AuthRegistrationRequest request = new AuthRegistrationRequest();
        request.setEmail("timileyin1708@gmail.com");
        request.setFirstname("timileyin");
        request.setLastname("Tunde");
      mockMvc.perform(post("/api/v1/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(request)))
                .andExpect(status().isOk())
                .andDo(print());
    }

}