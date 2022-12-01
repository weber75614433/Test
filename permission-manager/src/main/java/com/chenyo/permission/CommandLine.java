package com.chenyo.permission;

public class CommandLine {
    public final String command;
    public final Runnable runnable;


    public CommandLine(String command, Runnable runnable) {
        this.command = command;
        this.runnable = runnable;
    }
}
