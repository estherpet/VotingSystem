package com.voterapp.votersapp.utils;


import com.voterapp.votersapp.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static com.voterapp.votersapp.utils.AppUtil.generateActivationLink;
import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
class AppUtilsTest {


    private final AppConfig appConfig;

    AppUtilsTest(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Test
    public void testGenerateActivationLink(){
        String activationLink = generateActivationLink(appConfig.getBaseUrl(), "test@email.com");
        log.info("activation link -->{}", activationLink);
        assertThat(activationLink).isNotNull();
        assertThat(activationLink).contains("http://localhost:8080/activate");
    }


    @Test
    public void generateTokenTest() {
        String email = "test@email.com";
        String token = generateVerificationToken(email);
        log.info("generated token--->{}", token);
        assertThat(token).isNotNull();
    }

    private String generateVerificationToken(String email) {
        return null;
    }
}