package com.stussy.stussyclone20220930eunji.service;

import com.stussy.stussyclone20220930eunji.dto.RegisterReqDto;

public interface AccountService {

    public void duplicateEmail(RegisterReqDto resisterReqDto) throws Exception;
    public void register(RegisterReqDto resisterReqDto) throws Exception;

}
