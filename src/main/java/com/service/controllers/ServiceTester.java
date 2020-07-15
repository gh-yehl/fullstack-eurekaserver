package com.service.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

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
        return "Success! - Service Two";
    }

    @RequestMapping(value = "/testInternal", method = RequestMethod.GET)
    public String testInternal() {
        String responseStr = "";

        Jedis jedis = new Jedis("C03z0082.boulder.ibm.com", 6379);
        //Jedis jedis = new Jedis("www.curvelife.top", 6379);
        responseStr = jedis.get("oneKey");
        LOGGER.info("Connecting...");
        LOGGER.info("ping: "+ jedis.ping());
        return "Success: "+ responseStr;
    }

    @RequestMapping(value = "/testExternal", method = RequestMethod.GET)
    public String testExternal() {
        String responseStr = "";

        Jedis jedis = new Jedis("www.curvelife.top", 6379);
        responseStr = jedis.get("oneKey");

        LOGGER.info("Connecting...");
        LOGGER.info("ping: "+ jedis.ping());

        return "Success: "+responseStr;
    }
}
