package com.example.action;

import com.example.model.Person;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class IndexAction extends ActionSupport implements ModelDriven<Person> {
  private static final long serialVersionUID = 44587866668545452L;
  private final Person person = new Person();

  @Override
  public String execute() {
    log.info("Index Action Executed");
    person.setId(101);
    person.setName("ABC");
    return SUCCESS;
  }

  @Override
  public Person getModel() {
    return person;
  }
}
