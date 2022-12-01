package com.chenyo.permission.commandline;

import com.chenyo.permission.PermissionCommand;
import com.chenyo.permission.UserPermissionList;

public class CommandEditUserPermission implements Runnable{
    @Override
    public void run() {
        System.out.println("EditUserPermission");

        String getCommand = PermissionCommand.command;
        String[] subs = getCommand.split(" ");

        if(UserPermissionList.userPermission.containsKey(subs[1])){
            UserPermissionList.userPermission.put(subs[1], subs[2]);
        }else{
            System.out.println("No such user");
        }

    }
}
