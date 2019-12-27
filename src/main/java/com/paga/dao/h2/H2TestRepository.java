package com.paga.dao.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paga.dao.h2.entity.H2Test;


@Repository
@Transactional
public interface H2TestRepository extends JpaRepository<H2Test,Integer> {

}
