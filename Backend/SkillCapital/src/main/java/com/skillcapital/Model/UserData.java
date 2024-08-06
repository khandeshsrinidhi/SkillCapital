package com.skillcapital.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatic ID generation
    private int userId;
    private String userName;
    private String password;
}
