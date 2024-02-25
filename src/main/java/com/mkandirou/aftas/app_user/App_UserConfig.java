package com.mkandirou.aftas.app_user;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class App_UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerMember(App_UserService memberService) {
        return args -> {

        };
    }
}
