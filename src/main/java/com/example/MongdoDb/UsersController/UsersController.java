//package com.example.MongdoDb.UsersController;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.MongdoDb.UsersModel.AuthRequest;
//import com.example.MongdoDb.UsersModel.UsersModel;
//import com.example.MongdoDb.UsersRepository.UsersRepository;
//
//import lombok.AllArgsConstructor;
//
//@RestController
//@AllArgsConstructor
//public class UsersController {
//
//
//	private final UsersRepository usersRepository;
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@PostMapping("/register")
//	private ResponseEntity<?> subscribeClient(@RequestBody UsersModel register) {
//
//		try {
//			usersRepository.save(register);
//		} catch (Exception e) {
//			return (ResponseEntity<?>) ResponseEntity.badRequest();
//		}
//		return ResponseEntity.ok("Email with" + register.getEmail() + " successfully registered!");
//
//	}
//
//	@PostMapping("/auth")
//	private ResponseEntity<?> authenticateClient(@RequestBody AuthRequest auth) {
//
//		try {
//			authenticationManager
//					.authenticate(new UsernamePasswordAuthenticationToken(auth.getEmail(), auth.getPassword()));
//		} catch (BadCredentialsException e) {
//			return (ResponseEntity<?>) ResponseEntity.badRequest();
//		}
//		return ResponseEntity.ok(null);
//	}
//}
