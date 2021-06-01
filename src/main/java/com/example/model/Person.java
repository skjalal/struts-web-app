package com.example.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

  private static final long serialVersionUID = 4458787878545452L;
  private int id;
  private String name;
}
