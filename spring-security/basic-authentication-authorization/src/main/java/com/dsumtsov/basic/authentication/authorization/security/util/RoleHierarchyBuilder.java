package com.dsumtsov.basic.authentication.authorization.security.util;

public class RoleHierarchyBuilder {

    private StringBuilder stringBuilder = new StringBuilder();

    public RoleHierarchyBuilder append(String upLineRole, String downLineRole) {
        stringBuilder.append(String.format("ROLE_%s > ROLE_%s\n", upLineRole, downLineRole));
        return this;
    }

    public String build() {
        return stringBuilder.toString();
    }
}
