package com.chenyo.permission.terminal;

import com.chenyo.permission.PermissionCommand;

public interface onCommand {


    default String terminalCommand(String command , String userPermission){
        command = Terminal.executeCommand();
        userPermission = PermissionCommand.userPermission.get(PermissionCommand.userID);

        return "result";
    }




}
