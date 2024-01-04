package com.iamf.stays.mappers;

import com.iamf.stays.dtos.user.UserVerified;
import com.iamf.stays.models.Customer;
import com.iamf.stays.models.Family;
import com.iamf.stays.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

	public UserVerified userToUserVerified(User user){
	    UserVerified userVerified = UserVerified.builder()
	    		.id(user.getId())
	    		.name(user.getName())
	    		.email(user.getEmail())
	    		.userType(user.getUserType())
	    		.role(user.getRole())
				.image(user.getImage())
	    		.build();
	    return userVerified;
	}

	public List<UserVerified> customersToUsersVerified(List<Customer> customers){
		List<UserVerified> userVerifiedList = new ArrayList<>();
		customers.forEach((u) -> userVerifiedList.add(this.userToUserVerified(u)));
		return userVerifiedList;
	}

	public List<UserVerified> familiesToUsersVerified(List<Family> families){
		List<UserVerified> userVerifiedList = new ArrayList<>();
		families.forEach((u) -> userVerifiedList.add(this.userToUserVerified(u)));
		return userVerifiedList;
	}

}
