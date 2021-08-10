package com.dsumtsov.non.web.context.config;

import com.dsumtsov.non.web.context.beans.SpringBean1;
import com.dsumtsov.non.web.context.beans.SpringBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration2 {

    /**
     * Created bean name matches method name
     * @return
     */
    @Bean
    public SpringBean1 springBean1() {
        return new SpringBean1();
    }

    @Bean
    public SpringBean2 springBean2() {
        return new SpringBean2();
    }
}
