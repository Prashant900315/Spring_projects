package com.register.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name="MyUser")
@Table(name="my_user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyUser implements Serializable {
	
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "USER_ID", unique = true, nullable = false)
     private Integer Id;
     
     @Column(name = "USER_NAME")
     private String userName;
     
     @Column(name = "USER_EMAIL")
     private String email;
     
     @Column(name = "USER_PHONE")
     private String mobileNo;
     
     @Column(name = "USER_DOB")
     private String doB;
     
     @Column(name = "USER_PASSWORD")
     private String password;
     
     @Column(name = "ACCOUNT_STATUS")
     private String accountStatus;
      
     @Column(name = "REC_STATUS")
     private String status;

     @Column(name = "VALIDITY_DATE")
     private String validityDate;
     
     @Column(name = "MAKER_ID")
     private String makerId;

}
