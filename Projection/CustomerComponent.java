package com.example.pcmarket.Projection;

import com.example.pcmarket.Model.Component;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Component.class)
public interface CustomerComponent {
    Integer getId();
    String getName();
}
