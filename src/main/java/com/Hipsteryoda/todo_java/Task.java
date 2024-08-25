package com.Hipsteryoda.todo_java;

import java.io.PrintWriter;
import java.io.FileOutputStream;

class Task {
  public int id;
  public String task;
  public boolean completed;
  //private JSONObject jo;

  public Task(int id, String task, boolean completed) {
    // TOOD: increment the id to the next available id
    this.id = getId();
    this.task = task;
    this.completed = completed;
  }

  public Task(String task) {
    this.id = getId();
    this.task = task;
  }

  public String getTask() {
    return this.task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  private int getId() {
    // FIXME: read in the json file and return the highest id + 1
    return 123;
  }

  public void writeOut() {
    try {
      // TODO: read in file path from a config file
      FileOutputStream fileStream = new FileOutputStream("/home/ksmith/birds/todo_java/src/main/java/com/Hipsteryoda/todo_java/todo.json", true);
      PrintWriter outFS = new PrintWriter(fileStream);
      outFS.write("{");
      outFS.write("\n\t\"id\": " + this.id);
      outFS.write(",\n\t\"task\": \"" + this.task + "\"");
      outFS.write(",\n\t\"completed\": " + this.completed);
      outFS.write("\n},\n");
      outFS.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
} 
