package com.dsumtsov.basic.authentication.authorization.security.constants;

public class SecurityRoles {

    private SecurityRoles() {}

    public static final String ROLE_PREFIX = "ROLE_";

    public static final String SUPER_ADMIN = "SUPER_ADMIN";

    public static final String CUSTOMERS_ADMIN = "CUSTOMERS_ADMIN";
    public static final String CUSTOMERS_READ = "CUSTOMERS_READ";
    public static final String CUSTOMERS_CREATE = "CUSTOMERS_CREATE";
    public static final String CUSTOMERS_DELETE = "CUSTOMERS_DELETE";
    public static final String CUSTOMERS_PAG_VIEW = "CUSTOMERS_PAG_VIEW";
}
