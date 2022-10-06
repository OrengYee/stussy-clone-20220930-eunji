package com.stussy.stussyclone20220930eunji.dto;


import com.stussy.stussyclone20220930eunji.dto.validation.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisterReqDto {
    // 한글자 이상 무조건 들어와야함, 세글자를 넘을 수는 없다. 무조건 한글이여야함.
    @NotBlank(message = "이름은 비워둘 수 없습니다." ,groups = ValidationGroups.NotBlankGroup.class)
    @Size(min =1,max=3,message = "이름은 3자 이하여야 합니다" ,groups = ValidationGroups.Size.class)
    @Pattern(regexp = "^[가-횧]{1,3}$",message = "한글만 입력 가능합니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String lastName;
    
    @NotBlank(message = "이름은 비워둘 수 없습니다." ,groups = ValidationGroups.NotBlankGroup.class)
    @Size(min =1,max=2,message = "성은 2자 이하여야 합니다" ,groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "^[가-횧]{1,3}$",message = "한글만 입력 가능합니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String firstName;

    @NotBlank(message = "이메일은 비워둘 수 없습니다.")
    @Email
    private String email;
    
    @NotBlank(message = "비밀번호는 비워둘 수 없습니다.")
    @Size(min=8, max=16, message = "비밀번호는 8자이상 16자 이하여야 합니다")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]*$", message = "비밀번호는 특수기호,영문,숫자를 모두 포함해야합니다.")
    private String password;


}
