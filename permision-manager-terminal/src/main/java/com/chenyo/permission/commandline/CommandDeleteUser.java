package com.chenyo.permission.commandline;


import com.chenyo.permission.LogRecord;
import com.chenyo.permission.PermissionCommand;
import com.chenyo.permission.SetCommandPermission;
import com.chenyo.permission.UserPermissionList;

public class CommandDeleteUser implements Runnable, SetCommandPermission {
    @Override
    public void run() {
        System.out.println("DeleteUser");

        if(!hasPermission("aaa.bb")){
            LogRecord.setWarning("user : " + PermissionCommand.userID +" -> "
                    +PermissionCommand.command + " Permission Unqualified");
            System.out.println("Permission Unqualified");
        }else{
            String getCommand = PermissionCommand.command;
            String[] subs = getCommand.split(" ");
            if(subs.length <= 1){
                LogRecord.setWarning(PermissionCommand.userID + " " + PermissionCommand.command + "parameter is null");
                System.out.println("user can't be null");
            }else if(Admin()){
                LogRecord.setWarning(PermissionCommand.userID + " " + PermissionCommand.command + "modified admin");
                System.out.println("Can't modified Admin");
            }
            else if(UserPermissionList.userPermission.containsKey(subs[1])){
                UserPermissionList.userPermission.remove(subs[1]);
            }else{
                LogRecord.setWarning(PermissionCommand.userID + " " + "modified with wrong parameter");
                System.out.println("no such user");
            }
        }
    }
}
