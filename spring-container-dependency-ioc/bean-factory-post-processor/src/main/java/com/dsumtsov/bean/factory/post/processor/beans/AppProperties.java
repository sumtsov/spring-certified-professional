package com.dsumtsov.bean.factory.post.processor.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${app.env}")
    private String appEnv;
    @Value("${app.env.id}")
    private String appEnvId;

    public void printProperties() {
        System.out.println("[AppProperties] app.env = " + appEnv);
        System.out.println("[AppProperties] app.env.id = " + appEnvId);
    }
}
