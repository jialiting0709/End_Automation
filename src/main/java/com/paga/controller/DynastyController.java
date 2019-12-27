package com.paga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.paga.dao.h2.H2LoginCaseRepository;
import com.paga.dao.h2.H2TestRepository;
import com.paga.dao.h2.entity.H2Test;
import com.paga.dao.h2.entity.LoginCase;
import com.paga.dao.oracle.OracleTestRepository;
import com.paga.dao.oracle.entity.OracleTest;

import java.util.List;


    @RestController
    @RequestMapping("/test")
    public class DynastyController {

        @Autowired
        private OracleTestRepository oracleRepository;
        
        @Autowired
        private H2TestRepository h2TestRepository;

        @Autowired
        private H2LoginCaseRepository h2LoginCaseRepository;

        @GetMapping("/saveOracle")
        public void saveOracle(){
            OracleTest oracleTest = new OracleTest();
            oracleTest.setUserCode("1");
            oracleRepository.save(oracleTest);
        }
        @GetMapping("/queryOracle")
        public List<OracleTest> queryOracle(){
            List<OracleTest> lsitRe = oracleRepository.findAll();
            for(OracleTest fr:lsitRe){
                System.out.println(fr.toString());
            }
            return lsitRe;
        }

        @GetMapping("/saveH2")
        public void saveH2() {
            H2Test h2Test = new H2Test();
            h2Test.setUserCode("2");
            h2TestRepository.save(h2Test);
        }

        @GetMapping("/queryH2")
        public List<H2Test> queryH2() {
            List<H2Test> lsitRe = h2TestRepository.findAll();
            for(H2Test fr:lsitRe){
                System.out.println(fr.toString());
            }
            return lsitRe;
        }

        @GetMapping("/loginH2")
        public List<LoginCase> loginH2() {
            List<LoginCase> lsitRe = h2LoginCaseRepository.findAll();
            System.out.println("H2"+lsitRe.get(0));
            return lsitRe;
        }

}
