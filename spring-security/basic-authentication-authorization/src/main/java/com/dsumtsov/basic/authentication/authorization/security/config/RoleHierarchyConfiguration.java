package com.dsumtsov.basic.authentication.authorization.security.config;

import com.dsumtsov.basic.authentication.authorization.security.util.RoleHierarchyBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

import static com.dsumtsov.basic.authentication.authorization.security.constants.SecurityRoles.*;

@Configuration
public class RoleHierarchyConfiguration {

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(
                new RoleHierarchyBuilder()
                        .append(SUPER_ADMIN, CUSTOMERS_ADMIN)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_CREATE)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_READ)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_DELETE)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_PAG_VIEW)
                        .build()
        );

        return roleHierarchy;
    }
}
