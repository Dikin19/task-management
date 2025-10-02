package com.management.task.entity.managementuser;


import com.management.task.entity.app.BaseEntity;
import com.management.task.model.enums.UserStatus;
import com.management.task.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_user", indexes = { //dipakai untuk membuat indeks database di kolom tertentu.
        // Indeks ini gunanya mempercepat query SELECT (misalnya WHERE, JOIN, ORDER BY).
        // jika tidak butuh query tidak perlu memakai table indexes.
        //create index idx_user_username on m_user(username);
        // select * from m_user where username = 'andi';
        @Index(name = "idx_user_created_date", columnList = "createdDate"),
        @Index(name = "idx_user_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_user_username", columnList = "username"),
        @Index(name = "idx_user_password", columnList = "password"),
        @Index(name = "idx_user_role", columnList = "role"),
        @Index(name = "idx_user_userStatus", columnList = "userStatus")
        })

public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus userStatus = UserStatus.ACTIVE;

    private String token;

    private LocalDateTime expiredTokenAt;

}
