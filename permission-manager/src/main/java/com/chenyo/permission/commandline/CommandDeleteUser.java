package com.chenyo.permission.commandline;

import com.chenyo.permission.PermissionCommand;
import com.chenyo.permission.SetCommandPermission;
import com.chenyo.permission.UserPermissionList;

public class CommandDeleteUser implements Runnable, SetCommandPermission {
    @Override
    public void run() {
        System.out.println("DeleteUser");

        if(!hasPermission("aaa.bb")){
            System.out.println("Permission Unqualified");
        }else{
            String getCommand = PermissionCommand.command;
            String[] subs = getCommand.split(" ");
            if(subs.length <= 1){
                System.out.println("user can't be null");
            }else if(Admin()){
                System.out.println("Can't modified Admin");
            }
            else if(UserPermissionList.userPermission.containsKey(subs[1])){
                UserPermissionList.userPermission.remove(subs[1]);
            }else{
                System.out.println("no such user");
            }
        }
    }
}
