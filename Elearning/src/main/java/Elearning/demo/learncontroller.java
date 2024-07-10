package Elearning.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Controller
public class learncontroller {
    String jdbcurl= "jdbc:mysql://localhost:3306/elearning";
    @GetMapping("/index")
    public String Home(){
        return "index";
    }
    @GetMapping("/login")
    public String Login(){
        return "login";
    }
    @GetMapping("/signup")
    public String Signup(){
        return "signup";
    }
    @GetMapping("/courses")
    public String CoursePage(){
        return "courses";
    }
    @GetMapping("/about")
    public String AboutPage(){
        return "about";
    }
    @GetMapping("/contact")
    public String ContactPage(){
        return "contact";
    }
    @GetMapping("/enrollment")
    public String EnrollmentPage(){
        return "enrollment";
    }
    @PostMapping("/ContactUs")
    public String signup(@RequestParam("name") String username, @RequestParam("email") String email, @RequestParam("message") String message) {
        System.out.println("Inside signup method");
        System.out.println("The attributes are " + username + " " + email + " " + message);

        try (Connection connection = DriverManager.getConnection(jdbcurl, "root", "Pass26")) {
            String sql = "INSERT INTO contact VALUES (?, ?, ?)";
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, username);
            pstatement.setString(2, email);
            pstatement.setString(3, message);
            pstatement.execute();
            System.out.println("Database updated successfully");
        } catch (Exception e) {
            System.out.println("The exception occurred is " + e);
        }
        return "login";
    }


}
