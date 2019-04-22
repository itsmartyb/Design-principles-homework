package com.epam.cleandesign.srp;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public final class EmployeeManager {
    public static final String RECEIVER = "abcd@gmail.com";
    public static final String SENDER = "web@gmail.com";
    public static final String HOST = "localhost";
    
    private List<Employee> cache = null;

    void getEmployees(Connection connection) {
        this.cache = EmployeeReader.readEmployees(connection);
    }

    String getAllEmployeesAsJson(Connection connection) {
        if(cache == null) {
            getEmployees(connection);
        }
        return EmployeeJsonParser.employeesAsJson(cache);
    }

    public void sendEmployeesReport(Connection connection) {
        if(cache == null) {
            getEmployees(connection);
        }

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", HOST);
        Session session = Session.getDefaultInstance(properties);

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(SENDER));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(RECEIVER));
            message.setSubject("Employees report");

            String employeesHtml = EmployeeHtmlParser.getAllEmployeesAsHtml(cache);

            message.setContent(employeesHtml, "text/html; charset=utf-8");

            Transport.send(message);
        } catch (MessagingException e) {
            throw new IllegalStateException(e);
        }
    }




}
