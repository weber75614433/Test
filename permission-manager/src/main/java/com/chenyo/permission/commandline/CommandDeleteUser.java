package com.chenyo.permission.commandline;

import com.chenyo.permission.PermissionCommand;
import com.chenyo.permission.UserPermissionList;

public class CommandDeleteUser implements Runnable{
    @Override
    public void run() {
        System.out.println("DeleteUser");
        String getPermission = PermissionCommand.userID;

        if(UserPermissionList.userPermission.get(getPermission).contains("aaa.bb")
                | UserPermissionList.userPermission.get(getPermission).contains("Admin")){
            String getCommand = PermissionCommand.command;
            String[] subs = getCommand.split(" ");
            if(subs.length <= 1){
                System.out.println("user can't be null");
            }else if(UserPermissionList.userPermission.containsKey(subs[1])){
                UserPermissionList.userPermission.remove(subs[1]);
            }else{
                System.out.println("no such user");
            }

        }




    }
}
