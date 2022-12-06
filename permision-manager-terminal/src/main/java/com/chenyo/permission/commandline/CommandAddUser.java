package com.chenyo.permission.commandline;


import com.chenyo.permission.LogRecord;
import com.chenyo.permission.PermissionCommand;
import com.chenyo.permission.SetCommandPermission;
import com.chenyo.permission.UserPermissionList;

public class CommandAddUser implements Runnable, SetCommandPermission {

    @Override
    public void run() {
        System.out.println("AddUser");
        String getCommand = PermissionCommand.command;
        String[] subs = getCommand.split(" ");

        if(!hasPermission("aaa")){
            LogRecord.setWarning("user : " + PermissionCommand.userID +" - "
                    +PermissionCommand.command + "Permission Unqualified");
            System.out.println("Permission Unqualified");
        }else if(Admin()){
            System.out.println("Can't modified Admin");
        }
        else{
            if(subs.length <= 1){
                System.out.println("user name can't be null");
            }else{
                UserPermissionList.userPermission.put(subs[1], "aaa");
            }
        }





    }
}
