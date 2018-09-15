package vn.myclass.core.persistance.data.entity;

import vn.myclass.core.persistance.data.entity.CommentEntity;
import vn.myclass.core.persistance.data.entity.RoleEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Admin on 4/6/2017.
 */
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "createdate")
    private Timestamp createDate;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private RoleEntity roleEntity;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList;

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

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }
}
