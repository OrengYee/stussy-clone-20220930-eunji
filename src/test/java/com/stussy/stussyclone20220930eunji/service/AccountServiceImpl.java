package com.stussy.stussyclone20220930eunji.service;

import com.stussy.stussyclone20220930eunji.dto.RegisterReqDto;
import com.stussy.stussyclone20220930eunji.dto.exception.CustomValidationException;

import java.util.HashMap;

public class AccountServiceImpl implements AccountService {

    @Override
    public void register(RegisterReqDto registerReqDto) throws Exception {

        User user = accountRepository.findUserByEmail(registerReqDto.getEmail());
        if(user != null) {
            map<String,String> errorMap = new HashMap<String,String>();
            errorMap.put("email", "Email already exists");

            throw new CustomValidationException("Duplicate email",errorMap);
        }

    }


}
