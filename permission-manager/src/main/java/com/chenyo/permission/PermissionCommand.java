package com.chenyo.permission;

import com.chenyo.permission.commandline.*;

import java.util.HashMap;
import java.util.Scanner;

public class PermissionCommand extends UserPermissionList implements Runnable{
    public final HashMap<String, CommandLine> commandLineList = new HashMap<>();

    public static String command;
    public static String userID;

    public static void main(String[] args){
        UserPermissionList.UserList();
        UserVerify();
    }

    public PermissionCommand(){
        commandLineList.put("add", new CommandLine("AddUser", new CommandAddUser()));
        commandLineList.put("del", new CommandLine("DeleteUser", new CommandDeleteUser()));
        commandLineList.put("edit", new CommandLine("EditUserPermission", new CommandEditUserPermission()));
        commandLineList.put("prt", new CommandLine("PrintList", new CommandPrintList()));
        commandLineList.put("exit", new CommandLine("LogOut", new CommandLogOut()));
    }

    public static void UserVerify(){
        while(true){
            Scanner idScanner = new Scanner(System.in);
            userID = idScanner.nextLine();
            if(userPermission.containsKey(userID)){
                System.out.println("User : " + userID);
                new PermissionCommand().run();
            }else {
                System.out.println("no such user");
            }
        }

    }
    @Override
    public void run() {
        while(true){
            Scanner cliScanner = new Scanner(System.in);
            command = cliScanner.nextLine();
            String[] subs = command.split(" ");
            CommandLine commandLine = this.commandLineList.get(subs[0]);
            if(commandLine == null){
                System.out.println("No such command");
            }else{
                try{
                    commandLine.runnable.run();
                }catch (Throwable throwable){
                    throwable.printStackTrace();
                }
            }
        }
    }
}
