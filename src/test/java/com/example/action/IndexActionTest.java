package com.example.action;

import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class IndexActionTest extends StrutsJUnit4TestCase<IndexAction> {

  @Test
  public void testExecuteAction() throws Exception {
    String execute = executeAction("/get");
    IndexAction action = getAction();
    assertFalse(action.hasActionErrors());
    assertNotNull(execute);
    assertTrue(execute.isEmpty());
  }
}
