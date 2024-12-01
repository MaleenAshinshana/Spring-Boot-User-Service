/*
package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Admin {

        private List<AdminEntity> users;

        public String login(String username, String password,String role) {
            for (AdminEntity user : users) {
           if (user.getRole().equals(role)) {
               if (user.getName().equals(username)) {
                   if (user.getPassword().equals(password)) {
                       if (user.getRole().equals("admin")) {
                           return "Login successful as admin.";
                       } else {
                           return "Login successful as user.";
                       }
                   } else {
                       return "Incorrect password.";
                   }
               }
               else {
                   return "Incorrect role.";
               }
           }
            }
            return "User not found.";
        }


    }



*/
