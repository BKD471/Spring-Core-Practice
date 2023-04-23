package com.example.todo.todomanager.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
  private UUID id;
  private String title;
  private String content;
  private statusType status;

  enum statusType{
     WORKING,DONE,NOT_DONE,PARTIALLY_DONE
  }

  @Override
  public String toString(){
    return String.format(" id:%s title:%s  content:%s  status:%s",id,title,content,status);
  }
}
