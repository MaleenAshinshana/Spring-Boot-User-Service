package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.service.util;

import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.converter.Convert;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.dto.UserDTO;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity.UserEntity;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.exception.NotFoundException;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.repo.UserRepository;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIMPL implements UserService {
    @Autowired
    private Convert convert;
    @Autowired
   /* @Qualifier("UserRepository")*/
    private UserRepository  userRepository;



    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return convert.toUserDTO(userRepository.save(convert.toUserEntity(userDTO)));
    }

    @Override
    public UserDTO getSelectedUser(String id) {
        Optional<UserEntity> byId = userRepository.findById(id);
        if (!byId.isPresent()){
            throw new NotFoundException("The User id cannot be found :"+id);
        }
        return convert.toUserDTO(byId.get());
    }

   /* @Override
    public UserDTO getByName(String name) {

    }*/


    @Override
    public void updateUser(String user_id,UserDTO userDTO) {
        Optional<UserEntity> user=userRepository.findById(user_id);
        if (!user.isPresent()){
            throw new NotFoundException("The User id cannot be found :"+user_id);
//            user.get().setUser_name(userDTO.getUser_name());
//            user.get().setEmail(userDTO.getEmail());
//            user.get().setUser_registration_time(userDTO.getUser_registration_time());
//            user.get().setEmail(userDTO.getEmail());
//            user.get().setAddress(userDTO.getAddress());
//            user.get().setPassword(userDTO.getPassword());
//            user.get().setNic_or_passport_number(userDTO.getNic_or_passport_number());
//            user.get().setProfile_picture(userDTO.getProfile_picture());
        }
        UserEntity userEntity=user.get();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());

        userEntity.setAddress(userDTO.getAddress());
        userEntity.setPassword(userDTO.getPassword());
        /*userEntity.getGender(userDTO.getGender());*/
        userEntity.setNic_or_passport_number(userDTO.getNic_or_passport_number());
        userEntity.setProfile_picture(userDTO.getProfile_picture());

        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(String user_id) {
        Optional<UserEntity> byId = userRepository.findById(user_id);
        if (!byId.isPresent()){
            throw new NotFoundException("The User id cannot be found :"+user_id);
        }
        userRepository.deleteById(user_id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user->convert.toUserDTO(user)).collect(Collectors.toList());
//        return userRepository.findAll().stream().map(::toUserDto).collect(Collectors.toList());
    }

    @Override
    public UserEntity getUserByUsername(String userName) {
        UserEntity userEntityByName = userRepository.findUserEntityByName(userName);
        return userEntityByName;
//        /*userRepository.*/
        /*userRepository.findByUser_nameIgnoreCase(userName);*/
//        return userName;
    }

    /*@Override
    public boolean authenticateUser(String username, String password) {
        Optional<UserEntity> byUserName = userRepository.findById(username);
        if (byUserName!=null&& byUserName.get().equals(password)){
            return true;
        }
        return false;
    }*/


}
