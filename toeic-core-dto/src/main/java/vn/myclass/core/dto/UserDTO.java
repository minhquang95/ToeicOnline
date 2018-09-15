package vn.myclass.core.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Admin on 8/7/2017.
 */
public class UserDTO implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private String fullName;
    private Timestamp createDate;
    private RoleDTO roleDTO;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }
}
