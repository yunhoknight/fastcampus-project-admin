package com.fastcampus.projectadmin.domain;

import com.fastcampus.projectadmin.domain.constant.RoleType;
import com.fastcampus.projectadmin.domain.converter.RoleTypesConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "email", unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class UserAccount extends AuditingFields {

    @Id
    @Column(length = 50)
    private String userId;

    @Setter
    @Column(nullable = false)
    private String userPassword;

    @Convert(converter = RoleTypesConverter.class)
    @Column(nullable = false)
    private Set<RoleType> roleTypes = new LinkedHashSet<>();

    @Setter
    @Column(length = 100)
    private String email;

    @Setter
    @Column(length = 100)
    private String nickname;

    @Setter
    private String memo;

    protected UserAccount() {
    }

    private UserAccount(String userId, String userPassword, Set<RoleType> roleTypes, String email, String nickname, String memo, String createBy) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.roleTypes = roleTypes;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
        this.createdBy = createBy;
        this.modifiedBy = createBy;
    }

    public static UserAccount of(String userId, String userPassword, Set<RoleType> roleTypes, String email, String nickname, String memo) {
        return new UserAccount(userId, userPassword, roleTypes, email, nickname, memo, null);
    }

        public static UserAccount of(String userId, String userPassword, Set<RoleType> roleTypes, String email, String nickname, String memo, String createBy) {
        return new UserAccount(userId, userPassword, roleTypes, email, nickname, memo, createBy);
    }

    public void addRoleType(RoleType roleType) {
        this.getRoleTypes().add(roleType);
    }

    public void addRoleTypes(Collection<RoleType> roleTypes) {
        this.getRoleTypes().addAll(roleTypes);
    }

    public void removeRoleType(RoleType roleType) {
        this.getRoleTypes().remove(roleType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount that)) return false;
        return userId != null && userId.equals(that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPassword, email, nickname, memo);
    }
}
