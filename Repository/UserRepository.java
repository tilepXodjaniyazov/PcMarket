package com.example.pcmarket.Repository;

import com.example.pcmarket.Model.User;
import com.example.pcmarket.Projection.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
@RepositoryRestResource(path = "user",excerptProjection = CustomerUser.class)
public interface UserRepository extends JpaRepository<User,Integer> {

}
