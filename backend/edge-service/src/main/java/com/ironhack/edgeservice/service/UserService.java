package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.client.UserServiceClient;
import com.ironhack.edgeservice.config.FeignBadResponseWrapper;
import com.ironhack.edgeservice.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserServiceClient userClient;

    @HystrixCommand(fallbackMethod = "findUserByIdFake", ignoreExceptions = FeignBadResponseWrapper.class)
    public User findUserById(Integer id) throws Exception {
        User user = null;
        try {
            user = userClient.findById(id);
        } catch (HystrixBadRequestException e) {
            if (e instanceof FeignBadResponseWrapper) {
                throw new FeignBadResponseWrapper(((FeignBadResponseWrapper) e).getStatus(), ((FeignBadResponseWrapper) e).getHeaders(), ((FeignBadResponseWrapper) e).getBody());
            }
        }
        return user;
    }

    public User findUserByIdFake(Integer id){
        throw new NullPointerException("User service is down. Try again Later");
    }

    @HystrixCommand(fallbackMethod = "findUserByUsernameFake", ignoreExceptions = FeignBadResponseWrapper.class)
    public User findUserByEmail(String email){
        User user = null;
        try {
            user = userClient.findByEmail(email);
        } catch (HystrixBadRequestException e) {
            if (e instanceof FeignBadResponseWrapper) {
                throw new FeignBadResponseWrapper(((FeignBadResponseWrapper) e).getStatus(), ((FeignBadResponseWrapper) e).getHeaders(), ((FeignBadResponseWrapper) e).getBody());
            }
        }
        return user;
    }

    public User findUserByUsernameFake(String username){
        throw new NullPointerException("User service is down. Try again Later");
    }

    @HystrixCommand(fallbackMethod = "findAllUsersFake")
    public List<User> findAllUsers(){
        return userClient.findAll();
    }

    public List<User> findAllUsersFake(){
        throw new NullPointerException("User service is down. Try again Later");
    }
}
