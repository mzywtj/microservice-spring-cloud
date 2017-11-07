package com.itmouch.cloud.repository;

import com.itmouch.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
}
