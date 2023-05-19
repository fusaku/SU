package com.softusing.Jia.form;

import com.softusing.Jia.model.User1;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class User1Form {
    public static final String PHONE_REG = "^0[789]0-[0-9]{4}-[0-9]{4}$";
    @NotBlank
    private String username;
    @Length(min = 6, message = "密码至少需要6位")
    private String password;
    @Pattern(regexp = PHONE_REG, message = "请输入正确的手机号")
    private String phone;
    @Email
    private String email;
    @NotBlank
    private String confirmPassword;

    public boolean confirmPassword() {
        if (this.password.equals(this.confirmPassword)) {
            return true;
        }
        return false;
    }

    public User1Form() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public User1 convertToUser() {
        User1 user1 = new User1FormConvert().convert(this);
        return user1;
    }

    private class User1FormConvert implements FormConvert<User1Form, User1> {
        @Override
        public User1 convert(User1Form user1Form) {
            User1 user1 = new User1();
            BeanUtils.copyProperties(user1Form, user1);
            return user1;
        }
    }
}
