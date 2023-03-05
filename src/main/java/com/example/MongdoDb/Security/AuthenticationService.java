package com.example.MongdoDb.Security;

import java.util.Optional;

import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.MongdoDb.Enums.ERoles;
import com.example.MongdoDb.RolesModel.Roles;
import com.example.MongdoDb.UsersModel.UsersModel;
import com.example.MongdoDb.UsersRepository.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UsersRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(RegsiterRequest registerRequest) {

		Optional<UsersModel> checkIfEmailExist = repository.findByUsername(registerRequest.getEmail());

		if (checkIfEmailExist.isEmpty()) {
			var user = UsersModel.builder().firstname(registerRequest.getFirstname())
					.lastname(registerRequest.getLastname()).email(registerRequest.getEmail())
					.password(passwordEncoder.encode(registerRequest.getPassword())).roles("User").build();
			repository.save(user);

			var jwtToken = jwtService.generateToken(user);

			return AuthenticationResponse.builder().token(jwtToken).firstname(user.getFirstname()).roles(user.getRoles()).build();
		} else {
			return AuthenticationResponse.builder().token("Something's wrong cannot register").build();
		}

	}

	public AuthenticationResponse authenticate(AuthenticationRequest authenticate) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticate.getEmail(), authenticate.getPassword()));

		var user = repository.findByUsername(authenticate.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);

		return AuthenticationResponse.builder().token(jwtToken).build();
	}

}
