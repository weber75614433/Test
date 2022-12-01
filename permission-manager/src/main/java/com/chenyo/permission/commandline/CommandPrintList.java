package com.chenyo.permission.commandline;

import com.chenyo.permission.PermissionCommand;
import com.chenyo.permission.UserPermissionList;

public class CommandPrintList implements Runnable{
    @Override
    public void run() {
        String getPermission = PermissionCommand.userID;
        if(UserPermissionList.userPermission.get(getPermission).contains("aaa")
                | UserPermissionList.userPermission.get(getPermission).contains("Admin")){
            for(String key : UserPermissionList.userPermission.keySet()){
                System.out.println(key + " - " + UserPermissionList.userPermission.get(key));
            }
        }


    }
}
