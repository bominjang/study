package com.example.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//설정파일에 대한 것이 들어간다
@Configuration
//JPA에 대한 감시를 활성화 시키겠다.
@EnableJpaAuditing
public class JpaConfig {
}
