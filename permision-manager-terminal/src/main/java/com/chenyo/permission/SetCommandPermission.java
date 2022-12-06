package com.chenyo.permission;



import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public interface SetCommandPermission {

    default boolean Admin(){
        String[] subs = PermissionCommand.command.split(" ");
        if(subs.length<= 1){
            return false;
        }else{
            return subs[1].toLowerCase().contains(toLowerCase("Admin"));
        }
    }


    default boolean hasPermission(String commandPerms){
        String user = PermissionCommand.userID;
        String userPermission = UserPermissionList.userPermission.get(user);
        if(userPermission.contains("Admin")){
            return true;
        }else {
            return userPermission.contains(commandPerms);
        }

    }


}
