package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.converter;


import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.dto.*;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Convert {
    private  final ModelMapper modelMapper;

    public Convert(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public AdminDTO convertToDTO(AdminEntity admin) {
//        System.out.println(admin.getUser_id()+"Entity");
//        System.out.println(admin.getUserName()+"Entity");
//        System.out.println(admin.getPassword()+"Entity");
        System.out.println(admin.getAdmin_id()+ "Converter");
        return modelMapper.map(admin, AdminDTO.class);
    }
    public AdminEntity convertToEntity(AdminDTO adminDTO) {

        return modelMapper.map(adminDTO, AdminEntity.class);
    }


    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public  UserDTO toUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public BillEntity toBillEntity(BillDTO billDTO){
        return modelMapper.map(billDTO, BillEntity.class);
    }
    public  BillDTO toBillDTO(BillEntity billEntity){
        return modelMapper.map(billEntity, BillDTO.class);
    }

}
