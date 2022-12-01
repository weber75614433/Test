package com.chenyo.permission;

import java.util.ArrayList;
import java.util.HashMap;

public class UserPermissionList {

    public static HashMap<String, String> userPermission = new HashMap<>();

    public static void UserList(){
        userPermission.put("Lisa", "aaa.bb.c");
        userPermission.put("Boss", "Admin.*");
        userPermission.put("Weber", "aaa.bb");
        userPermission.put("Danny", "aaa.bb.c.*");
        userPermission.put("Admin", "Admin.*");
    }

}
