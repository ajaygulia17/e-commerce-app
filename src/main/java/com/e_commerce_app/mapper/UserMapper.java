package com.e_commerce_app.mapper;

import com.e_commerce_app.dto.UserDTO;
import com.e_commerce_app.entity.User;

public class UserMapper {
	public static UserDTO toUserDto(User user) {
		if (user==null) {
			return null;
		}
		
		UserDTO userDto = new UserDTO();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setEmail(user.getEmail());
		return userDto;
	}
}
