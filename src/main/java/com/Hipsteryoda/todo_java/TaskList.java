package com.Hipsteryoda.todo_java;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class TaskList {

  private ArrayList<Task> tasks = new ArrayList<Task>();
  private String fileName = "/home/ksmith/birds/todo_java/src/main/java/com/Hipsteryoda/todo_java/todo.json"; 
  private String jsonStr = "";

  public TaskList() {
    try { 
      BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
      String line;
      System.out.printf("%-14s", "ID");
      System.out.printf("%-14s", "| Completed");
      System.out.printf("%-100s\n", "| Task");
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
            System.out.printf("%-14s", id);
            System.out.printf("%-14s", "| " + completed);
            System.out.printf("%-14s\n", "| " + task);
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
