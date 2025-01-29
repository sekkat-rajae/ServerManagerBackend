package com.example.ServerManager.repository;

import com.example.ServerManager.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ServerRepo extends JpaRepository<Server, Long>{

    Server findByIpAddress(String IpAddress);
}
