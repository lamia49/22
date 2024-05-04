package org.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Requests {
     @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestId ;


        @Column(columnDefinition = "varchar(20) not null")
     private String sportType;
           @Column(columnDefinition = "varchar(20) not null")
     private String teamName;
//            @Pattern(regexp = "^(Accepted|rejected)$" , message = "status must be Accepted or Pending or rejected")
              @Column(columnDefinition = "varchar(20) not null")
     private String status="Pending";

       @ManyToMany
         @JsonIgnore
       private Set<TeamAdmin> teamAdminList;


       @ManyToMany
         @JsonIgnore
       private Set<SportAdmin>sportAdminList;

}
