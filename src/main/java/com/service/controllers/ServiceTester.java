package com.service.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        return "Success! - You find my in my cozy Pod!!!";
    }

    @RequestMapping(value = "/testIP", method = RequestMethod.GET)
    public String testIP() {
        String responseStr = "";
        Jedis jedis = new Jedis("9.17.159.138", 6379);
        jedis.auth("redis");
        responseStr = jedis.get("oneKey");
        LOGGER.info("Connecting...");
        LOGGER.info("ping: "+ jedis.ping());
        return "Access 9.17.159.138 - Success: "+ responseStr;
    }
    
    @RequestMapping(value = "/testDNS", method = RequestMethod.GET)
    public String testDNS() {
        String responseStr = "";
        Jedis jedis = new Jedis("C03z0082.boulder.ibm.com", 6379);
        jedis.auth("redis");
        responseStr = jedis.get("oneKey");
        LOGGER.info("Connecting...");
        LOGGER.info("ping: "+ jedis.ping());
        return "Access C03z0082.boulder.ibm.com- Success: "+ responseStr;
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
    
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo() {

        return "Success:  demo";
    }

    @RequestMapping(value = "/shell", method = RequestMethod.GET)
    public List<String> execShell(@RequestParam("command") String command) {
        Process process = null;

        List<String> processList = new ArrayList<String>();
        try {
            process = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                processList.add(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return processList;
    }

    @RequestMapping(value = "/cmd", method = RequestMethod.GET)
    public List<String> execCmd(@RequestParam("command") String command) {
        Process process = null;
        List<String> processList = new ArrayList<String>();
        System.out.println("call for cmd");
        try {
            process = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                processList.add(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return processList;
    }
    
    @RequestMapping(value = "/testRedis", method = RequestMethod.GET)
    public String testRedis() {
        String responseStr = "";

        Jedis jedis = new Jedis("10.208.226.186", 6379);
        jedis.set("oneKey","my set value for oneKey - access 10.208.226.186");
        responseStr = jedis.get("oneKey");

        LOGGER.info("Connecting...");
        LOGGER.info("ping: "+ jedis.ping());

        return "Success: "+responseStr;
    }
    
    
}
