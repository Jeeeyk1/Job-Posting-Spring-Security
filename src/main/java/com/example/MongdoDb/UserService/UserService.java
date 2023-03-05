//package com.example.MongdoDb.UserService;
//
//import java.util.Optional;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.MongdoDb.UsersModel.UsersModel;
//import com.example.MongdoDb.UsersRepository.UsersRepository;
//
//import lombok.AllArgsConstructor;
//
//@Service
//@AllArgsConstructor
//public class UserService implements UserDetailsService {
//
//	private UsersRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Optional<UsersModel> foundUser = userRepository.findByUsername(email);
//
//		if (foundUser == null)
//			return null;
//
//		String userEmail = foundUser.get().getEmail();
//		String pass = foundUser.get().getEmail();
//
//		return new User(userEmail, pass, null);
//	}
//
//}
