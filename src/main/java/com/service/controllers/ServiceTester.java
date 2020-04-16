package com.service.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController


public class ServiceTester {

    /**
     *
     * @param
     * @return
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceTester.class);
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        LOGGER.info("testing service one - info");
        LOGGER.debug("testing service one - debug");
        LOGGER.error("testing service one - error");
        return "Success! - Service One";
    }
}
