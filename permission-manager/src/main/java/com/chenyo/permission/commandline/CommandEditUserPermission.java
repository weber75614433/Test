package com.chenyo.permission.commandline;

import com.chenyo.permission.PermissionCommand;
import com.chenyo.permission.SetCommandPermission;
import com.chenyo.permission.UserPermissionList;

public class CommandEditUserPermission implements Runnable, SetCommandPermission {
    @Override
    public void run() {
        System.out.println("EditUserPermission");

        String getCommand = PermissionCommand.command;
        String[] subs = getCommand.split(" ");

        if(!hasPermission("Admin")){
            System.out.println("Permission Unqualified");
        }else if(Admin()){
            System.out.println("Can't modified Admin");
        }
        else{
            if(UserPermissionList.userPermission.containsKey(subs[1])){
                UserPermissionList.userPermission.put(subs[1], subs[2]);
            }else{
                System.out.println("No such user");
            }
        }
    }
}
