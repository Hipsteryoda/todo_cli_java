package com.Hipsteryoda.todo_java;

import java.util.Scanner;

/**
 * Todo app written in Java.
 * Todo reads and writes from a file in json format. 
 */
public class Todo {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);

    String task = scnr.nextLine();

    Task newTask = new Task(task);
    newTask.writeOut();
    TaskList taskList = new TaskList();

    scnr.close();

  }
}
