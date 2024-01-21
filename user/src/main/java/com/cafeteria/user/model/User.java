package com.cafeteria.user.model;


import com.cafeteria.user.model.dto.UserCreationDto;
import jakarta.persistence.Entity;
import com.cafeteria.user.enumerator.RoleEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity(name ="account")
public class User extends EntityBase {

    public User(){}

    public User(UserCreationDto userCreationDto){
        this.email = userCreationDto.email();
        this.name = userCreationDto.name();
        this.password= userCreationDto.password();
        this.role = RoleEnum.CLIENT;
    }
    private String name;

    private String email;

    private String password;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
