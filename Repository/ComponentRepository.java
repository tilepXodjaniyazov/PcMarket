package com.example.pcmarket.Repository;

import com.example.pcmarket.Model.Component;
import com.example.pcmarket.Projection.CustomerComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "component",excerptProjection = CustomerComponent.class)
public interface ComponentRepository extends JpaRepository<Component,Integer> {
}
