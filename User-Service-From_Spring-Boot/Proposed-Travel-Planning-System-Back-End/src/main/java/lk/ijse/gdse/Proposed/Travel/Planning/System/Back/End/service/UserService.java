package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.service;

import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.dto.UserDTO;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO getSelectedUser(String id);
    /*UserDTO getByName(String name);*/
    void  updateUser(String user_id,UserDTO userDTO);
    void deleteUser(String id);
    List<UserDTO> getAllUsers();

    UserEntity getUserByUsername(String userName);
    /* boolean authenticateUser(String username,String password);*/
    /*List<UserDTO> getUserByName(String user_name);*/
}
