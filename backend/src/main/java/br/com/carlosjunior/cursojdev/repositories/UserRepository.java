package br.com.carlosjunior.cursojdev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.carlosjunior.cursojdev.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
 
}
