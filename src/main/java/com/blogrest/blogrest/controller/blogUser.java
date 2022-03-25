package com.blogrest.blogrest.controller;

import java.util.*;
import com.blogrest.blogrest.controller.user;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")

public class blogUser {
	ArrayList<user> users = new ArrayList<>();

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody user ob){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("content-type", "application/json");
        Map<String, Object> map = new HashMap<String, Object>();
        for(user user:users) {
            if(user.getEmail().equals(ob.getEmail())) {
            	map.put("Error", "User already Exists");
                return new ResponseEntity<Object>(map, responseHeaders, HttpStatus.NOT_FOUND);
            }
        }
        users.add(ob);
        
        map.put("userName", ob.getUserName());
        return new ResponseEntity<Object>(map, responseHeaders, HttpStatus.CREATED);
    }

	@PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody String data) throws JsonMappingException, JsonProcessingException
    {
        // Get login credentials and then check with object stored in users array.
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("content-type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);
        String userEmail = rootNode.get("userEmail").asText();
        String userPassword = rootNode.get("userPassword").asText();

        Map<String, Object> map = new HashMap<String, Object>();

        for (int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getEmail().equals(userEmail))
            {
                if(users.get(i).getPassword().equals(userPassword))
                {

                    map.put("userName", users.get(i).getUserName());
                    return new ResponseEntity<Object>(map, responseHeaders, HttpStatus.FOUND);
                }
            }
        }

        map.put("Error", "Login Failed");
        return new ResponseEntity<Object>(map, responseHeaders, HttpStatus.NOT_FOUND);

    }



}
