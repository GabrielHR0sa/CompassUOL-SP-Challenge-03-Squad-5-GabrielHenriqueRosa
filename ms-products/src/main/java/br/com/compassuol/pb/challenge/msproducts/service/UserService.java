package br.com.compassuol.pb.challenge.msproducts.service;

import br.com.compassuol.pb.challenge.msproducts.dto.LoginDto;
import br.com.compassuol.pb.challenge.msproducts.dto.RegisterDto;

public interface UserService {

    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);

    RegisterDto getUserById(long id);

    RegisterDto updateUser(RegisterDto registerDto, long id);
}
