package com.mpp.group.proj.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
	public static void main(String[] args){
		String cryptedPassword = new BCryptPasswordEncoder().encode("password");
		System.out.println(cryptedPassword);
		//$2a$10$8Ns39D89dPqXQq8tkE6mtOfB6ISTUr0e.9eest/jhUPmqhPSDv.Cy
		//$2a$10$Vkteot/V8nx6CKRUSOhk7uhC4Q/543cIM/51SnZJ1e0T4jAAf4R4C
		//$2a$10$H8J7/O.8KkjX2rVbmhaWFern6oSf5KwQFZuh.XE2yORSfrNVyCMnS
	}

}

