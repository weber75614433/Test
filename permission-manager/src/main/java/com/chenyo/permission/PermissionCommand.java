package com.chenyo.permission;

import com.chenyo.permission.commandline.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class PermissionCommand extends UserPermissionList implements Runnable{
    public final HashMap<String, CommandLine> commandLineList = new HashMap<>();
    public static String command;
    public static String userID;

    public static void main(String[] args) throws IOException {
        UserPermissionList.ImportYml();
        LogEvent.setLogger("testing...");
        UserVerify();


    }

    public PermissionCommand() throws IOException {
        commandLineList.put("add", new CommandLine("basic.ADD_USER", new CommandAddUser()));
        commandLineList.put("del", new CommandLine("advanced.DELETE_USER", new CommandDeleteUser()));
        commandLineList.put("edit", new CommandLine("advanced.EDIT_PERMISSION", new CommandEditUserPermission()));
        commandLineList.put("prt", new CommandLine("basic.PRINT_LIST", new CommandPrintList()));
        commandLineList.put("exit", new CommandLine("basic.LOGOUT", new CommandLogOut()));
    }

    public static void UserVerify() throws IOException {
        while(true){

            Scanner idScanner = new Scanner(System.in);
            userID = idScanner.nextLine();
            if(userPermission.containsKey(userID)){
                LogEvent.setLogger("user : " + userID);
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
                    LogEvent.setLogger("user entry : " + command);
                    commandLine.runnable.run();
                }catch (Throwable throwable){
                    throwable.printStackTrace();
                }
            }
        }
    }
}
