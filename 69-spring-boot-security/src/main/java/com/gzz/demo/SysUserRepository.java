package com.gzz.demo;

import org.springframework.data.jpa.repository.JpaRepository;

 
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
