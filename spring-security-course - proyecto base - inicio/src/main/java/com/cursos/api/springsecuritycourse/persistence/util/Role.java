package com.cursos.api.springsecuritycourse.persistence.util;


import java.util.Arrays;

public enum Role {
    ROLE_ADMINISTRATOR(Arrays.asList(
            RolePermission.READ_ALL_PRODUCTS,
            RolePermission.READ_ONE_PRODUCT,
            RolePermission.CREATE_ONE_PRODUCT,
            RolePermission.UPDATE_ONE_PRODUCT,,
            RolePermission.DISABLED_ONE_PRODUCT,

            RolePermission.READ_ALL_CATEGORIES,
            RolePermission.READ_ONE_CATEGORY,
            RolePermission.CREATE_ONE_CATEGORY,
            RolePermission.UPDATE_ONE_CATEGORY,
            RolePermission.DISABLED_ONE_CATEGORY,


            RolePermission.READ_MY_PROFILE

    )),
    ROLE_ASSISTENT_ADRMINISTRATOR(Arrays.asList(
            RolePermission.READ_ALL_PRODUCTS,
            RolePermission.READ_ONE_PRODUCT,
            RolePermission.UPDATE_ONE_PRODUCT,,

            RolePermission.READ_ALL_CATEGORIES,
            RolePermission.READ_ONE_CATEGORY,
            RolePermission.UPDATE_ONE_CATEGORY,


            RolePermission.READ_MY_PROFILE

    )),
    ROLE_CUSTOMER(Arrays.asList(
            RolePermission.READ_MY_PROFILE
    )),;
    


}
