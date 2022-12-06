package com.chenyo.permission;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class UserPermissionList {

    public static HashMap<String, String> userPermission = new HashMap<>();
    static File file = new File("./src/main/resources/UserPermission.yml");
    static Yaml yaml = new Yaml();

    public static void ImportYml() throws IOException {

        if(file.exists() && !file.isDirectory()){
            InputStream inputStream = new FileInputStream(file);
            userPermission = yaml.load(inputStream);
        }else{
            userPermission.put("Lisa", "aaa.bb.c");
            userPermission.put("Boss", "Admin.*");
            userPermission.put("Weber", "aaa.bb");
            userPermission.put("Danny", "aaa.bb.c.*");
            userPermission.put("Admin", "Admin.*");

        }
    }

    public static void UploadYml() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(
                new File("./src/main/resources/UserPermission.yml"));
        yaml.dump(userPermission, writer);
    }



    /*public static void UserList(){
        userPermission.put("Lisa", "aaa.bb.c");
        userPermission.put("Boss", "Admin.*");
        userPermission.put("Weber", "aaa.bb");
        userPermission.put("Danny", "aaa.bb.c.*");
        userPermission.put("Admin", "Admin.*");
    }*/

}
