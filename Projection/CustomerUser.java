package com.example.pcmarket.Projection;

import com.example.pcmarket.Model.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = User.class)
public interface CustomerUser {
    Integer getId();
    String getEmail();
    String getPassword();
}
