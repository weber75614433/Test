package com.chenyo.permission.commandline;

import com.chenyo.permission.PermissionCommand;
import com.chenyo.permission.UserPermissionList;

import java.io.IOException;

public class CommandLogOut implements Runnable{
    @Override
    public void run() {
        System.out.println("LogOut");
        try {
            UserPermissionList.UploadYml();
            PermissionCommand.UserVerify();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
