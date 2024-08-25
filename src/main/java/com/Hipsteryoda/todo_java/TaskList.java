package com.Hipsteryoda.todo_java;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class TaskList {

  //private ArrayList<Task> tasks = new ArrayList<Task>();
  // TODO: read in the file path from a config file
  private String fileName = "/home/ksmith/birds/todo_java/src/main/java/com/Hipsteryoda/todo_java/todo.json"; 
  private String jsonStr = "";

  public TaskList() {
    try { 
      BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
      String line;
      
      //TODO: figure out why different escape codes seem to consume more or less width 
      System.out.printf("\n%-14s %-13s %-13s\n", "\033[4;33mID", "| Completed", "| Task \033[0m");
      // only print json elements that are comple
      while ((line = bufferedReader.readLine()) != null) {
        if (line.contains("{") && !line.contains("},")) {
          String idLine = bufferedReader.readLine();
          // TODO: get json parser working to clean this up
          int colonIdx = idLine.indexOf(':');
          int commaIdx = idLine.indexOf(',');
          String id = idLine.substring(colonIdx + 2, commaIdx);
          // Get name of task
          String taskLine = bufferedReader.readLine();
          colonIdx = taskLine.indexOf(':');
          commaIdx = taskLine.indexOf(',');
          String task = taskLine.substring(colonIdx + 3, commaIdx - 1);
          // Get completed status
          String completedLine = bufferedReader.readLine();
          colonIdx = completedLine.indexOf(':');
          String completed = completedLine.substring(colonIdx + 2);

          if (completed.equals("false")) {
            System.out.printf("%-8s", id);
            System.out.printf("%-14s", "| " + completed);
            System.out.printf("%-100s\n", "| " + task);
          }
        }
      }
      bufferedReader.close();
    }

    catch (Exception e) {
      System.out.println(e);
      // add check to make sure bufferedReader is closed
      // Close if it is open
    }
    System.out.println(jsonStr);
  }

}
