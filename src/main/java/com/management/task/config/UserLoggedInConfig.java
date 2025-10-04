package com.management.task.config;

import com.management.task.entity.managementuser.User;
import lombok.Getter; // dari Lombok otomatis membuat public User getUser() sehingga kamu bisa mengakses user dari luar.
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// UserLoggedInConfig adalah adapter yang mengubah entitas User milikmu menjadi objek
// UserDetails yang dipakai Spring Security untuk otentikasi (password) dan otorisasi (roles/authorities).
// Jadi Spring Security tidak perlu tahu detil entitasmu — cukup berinteraksi dengan UserDetails.

@Getter
public class UserLoggedInConfig implements UserDetails {

    private final User user;

        // buat object baru dari UserLoggedInConfig yg di implements dari userDetails
        // simpan parameter user dari db di dalam this.user untuk di proses dalam userDetails.
        // untuk di ambil data user yg login melalui security dalam userDetails
        // lalu dikembalikan di controller untuk dijalankan data ke logic service sampai logout.
        public UserLoggedInConfig(User user) {
            this.user = user;
            System.out.println("UserLoggedInConfig created for: " + user.getUsername());
        }

    @Override // Menandakan method ini meng-override method dari interface UserDetails.
    // hasRole
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

}