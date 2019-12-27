package com.paga.dao.oracle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paga.dao.oracle.entity.OracleTest;


@Repository
@Transactional
public interface OracleTestRepository extends JpaRepository<OracleTest,Integer> {

}
