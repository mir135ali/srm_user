package com.srm.user.service;

import com.srm.user.Exception.BadRequestException;
import com.srm.user.model.entity.UserClass;
import com.srm.user.model.payload.CreateUserPayload;
import com.srm.user.model.response.UserResponse;
import com.srm.user.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {

    @Autowired
    UserRepo userRepo;

//    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginService.class);

    public UserClass getUser(UserClass userRequest){
        String email = userRequest.getEmail();
        String pwd = userRequest.getPassword();

        if(email== null ){

            return null;
        }
        else {
            UserClass user = userRepo.findByEmail(email);
            return user;
        }
    }
    public String updateUser(UserClass userRequest){
        try{
            String email = userRequest.getEmail();
            String name = userRequest.getName();
            if(email == null || name== null){
                return "bad reqiest";
            }
            else{
                userRepo.save(userRequest);
            }
        } catch (Exception e){
            e.printStackTrace();

        }
        return "success created";


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

//    public UserClass updateUser(UpdateUser userRequest) throws UserException {
//
//        try{
//            String email = userRequest.getEmail();
//            UserClass user = userRepo.findByEmail(email);
//            if(user==null){
//                throw new UserException("user not found");
//            }
//            else{
//
//            }
//            return null;
//
//        }
//        catch (Exception e){
//            throw new UserException("user not found");
//        }
//
//    }
}
