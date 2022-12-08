package com.srm.user.service;

import com.srm.user.Exception.BadRequestException;
import com.srm.user.Exception.UserException;
import com.srm.user.model.entity.UserClass;
import com.srm.user.model.payload.CreateUserPayload;
import com.srm.user.model.payload.GetUserPayload;
import com.srm.user.model.payload.UpdateUserPayload;
import com.srm.user.model.response.UserResponse;
import com.srm.user.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class LoginService {

    @Autowired
    UserRepo userRepo;

//    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginService.class);

    public UserResponse getUser(GetUserPayload req) throws Exception{
        String email = req.getEmail();
        String password = req.getPassword();

        if(email== null || password==null){
            throw  new BadRequestException("Please enter proper field");
        }
        UserClass user = userRepo.findByEmail(email);
        if(ObjectUtils.isEmpty(user)){
            throw new UserException("user not found");
        }
        UserResponse userResponse = new UserResponse();

        userResponse.setUserId(user.getId());
        userResponse.setAddress(user.getAddress());
        userResponse.setEmail(user.getEmail());
        userResponse.setName(user.getName());
        userResponse.setPhone(user.getPhoneNumber());
        userResponse.setPassword(user.getPassword());
        return userResponse;
    }


    public UserResponse createUser(CreateUserPayload userPayload) throws Exception {
        if(userPayload == null){
            throw new BadRequestException("dekh ke bhar na laude");
        }

        UserClass userClass = new UserClass();
        userClass.setName(userPayload.getName());
        userClass.setEmail(userPayload.getEmail());
        userClass.setPhoneNumber(userPayload.getPhone());
        userClass.setPassword(userPayload.getPassword());
        userClass.setAddress(userPayload.getAddress());

        userClass = userRepo.save(userClass);

        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(userClass.getId());
        userResponse.setName(userClass.getName());
        userResponse.setPhone(userClass.getPhoneNumber());
        userResponse.setEmail(userClass.getEmail());
        userResponse.setAddress(userClass.getAddress());

        return userResponse;
    }

    public UserResponse updateUser(UpdateUserPayload req) throws Exception{

        String email = req.getEmail();
        if(email==null){
            throw  new BadRequestException("no email");
        }
        UserClass user = userRepo.findByEmail(email);
        if(user==null){
            throw new UserException("user not found");
        }
        else{
            UserClass userObj = new UserClass();

            if (req.getAddress() != null) {
                userObj.setAddress(req.getAddress());
            } else {
                userObj.setAddress(user.getAddress());
            }

            if(req.getName()!=null){
                userObj.setName(req.getName());
            } else {
                userObj.setName(user.getName());
            }
            if(req.getPhone()!= null){
                userObj.setPhoneNumber(req.getPhone());
            }else{
                userObj.setPhoneNumber(user.getPhoneNumber());
            }

            if(req.getPassword()!= null){
                userObj.setPassword(req.getPassword());
            } else {
                userObj.setPassword(user.getPassword());
            }
            userObj.setEmail(user.getEmail());

            userObj.setId(user.getId());

            userRepo.save(userObj);


            UserResponse response = new UserResponse();
            UserClass user1 = userRepo.findByEmail(email);
            response.setPassword(user1.getPassword());
            response.setUserId(user1.getId());
            response.setEmail(user1.getEmail());
            response.setAddress(user1.getAddress());
            response.setName(user1.getName());
            response.setPhone(user1.getPhoneNumber());
            return response;
        }

    }

}
