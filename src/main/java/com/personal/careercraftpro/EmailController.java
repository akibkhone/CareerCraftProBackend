package com.personal.careercraftpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("akibkhone@gmail.com");
        message.setTo("akibkhone@gmail.com");
        message.setSubject("New Contact Form Submission");
        message.setText("Name: " + request.getName() + "\n" +
                        "Email: " + request.getEmail() + "\n" +
                        "Message: " + request.getMessage());

        emailSender.send(message);

        return ResponseEntity.ok("Email sent successfully");
    }
}

class EmailRequest {
    private String name;
    private String email;
    private String message;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}