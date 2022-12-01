package com.chenyo.permission.commandline;

import com.chenyo.permission.PermissionCommand;
import com.chenyo.permission.UserPermissionList;

public class CommandAddUser implements Runnable{

    @Override
    public void run() {
        System.out.println("AddUser");

        String getCommand = PermissionCommand.command;
        String[] subs = getCommand.split(" ");
        String getPermission = PermissionCommand.userID;

        if(UserPermissionList.userPermission.get(getPermission).contains("aaa.bb")
                | UserPermissionList.userPermission.get(getPermission).equals("Admin")){
            if(subs.length <= 1){
                System.out.println("user name can't be null");
            }else{
                UserPermissionList.userPermission.put(subs[1], "aaa");
            }
        }else{
            System.out.println("Permission Unqualified");
        }




    }
}
