package com.chenyo.permission.commandline;

import com.chenyo.permission.UserPermissionList;

public class CommandPrintList implements Runnable{
    @Override
    public void run() {

        for(String key : UserPermissionList.userPermission.keySet()){
            System.out.println(key + " - " + UserPermissionList.userPermission.get(key));
        }
    }
}
