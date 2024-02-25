package com.mkandirou.aftas.auth;



import com.mkandirou.aftas.app_user.App_UserRepository;
import com.mkandirou.aftas.app_user.App_user;
import com.mkandirou.aftas.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final App_UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    App_user user= new App_user();
    user.setName(request.getName());
    user.setFamilyName(request.getFamilyName());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setAccessionDate(request.getAccessionDate());
    user.setNationality(request.getNationality());
    user.setIdentityDocument(request.getIdentityDocument());
    user.setIdentityNumber(request.getIdentityNumber());
    user.setRole(request.getRole());
    repository.save(user);
    String jwt=jwtService.generateToken(user);
    return AuthenticationResponse.builder().Token(jwt).build();
  }

  public HashMap<String,String> login(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    App_user user=repository.findByEmail(request.getEmail())
            .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    Map<String, Object> claims = new HashMap<>();
    claims.put("email", user.getEmail());
    claims.put("role", user.getRole().name());
    String jwt=jwtService.generateToken(claims,user);
    HashMap<String,String> loginInfo= new HashMap<>();

    loginInfo.put("token", String.valueOf(AuthenticationResponse.builder().Token(jwt).build().getToken()));
    loginInfo.put("role",user.getRole().name());
    return loginInfo;
  }

}
