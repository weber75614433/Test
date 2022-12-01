package com.chenyo.permission.commandline;

import com.chenyo.permission.PermissionCommand;

public class CommandLogOut implements Runnable{
    @Override
    public void run() {
        System.out.println("LogOut");
        PermissionCommand.UserVerify();
    }
}
