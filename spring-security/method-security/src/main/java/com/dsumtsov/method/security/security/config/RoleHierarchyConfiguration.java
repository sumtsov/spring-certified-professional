package com.dsumtsov.method.security.security.config;

import com.dsumtsov.method.security.security.util.RoleHierarchyBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

import static com.dsumtsov.method.security.security.constants.SecurityRoles.*;

@Configuration
public class RoleHierarchyConfiguration {

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(
                new RoleHierarchyBuilder()
                        .append(SUPER_ADMIN, CUSTOMERS_ADMIN)
                        .append(SUPER_ADMIN, EMPLOYEES_ADMIN)
                        .build()
        );

        return roleHierarchy;
    }
}
