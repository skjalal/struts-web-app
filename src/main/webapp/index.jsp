<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <meta charset="UTF-8"/>
    <title>Sample Struts 2 Application - Welcome</title>
  </head>
  <body>
    <h1>Welcome To Struts 2!</h1><br/>
    <s:property value="id" />
    <s:property value="name" />
  </body>
</html>