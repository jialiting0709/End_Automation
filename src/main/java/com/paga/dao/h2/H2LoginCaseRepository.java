package com.paga.dao.h2;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paga.dao.h2.entity.LoginCase;


@Repository
public interface H2LoginCaseRepository extends JpaRepository<LoginCase,Integer> {
	
}
