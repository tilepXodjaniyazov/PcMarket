package com.example.pcmarket.Projection;

import com.example.pcmarket.Model.Address;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Address.class)
public interface CustomAddress {
    Integer getId();
    Integer getCity();
    String getDistrict();
    String getStreet();
    String getHomeNumber();
}
