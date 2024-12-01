package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.service.util;

import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.converter.Convert;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.dto.AdminDTO;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity.AdminEntity;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.exception.NotFoundException;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.repo.AdminRepository;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceIMPL implements AdminService {




    private final Convert convert;


    private final AdminRepository adminRepository;



    @Override
    public AdminDTO saveAdmin(AdminDTO adminDTO) {
        System.out.println(adminDTO.getAdmin_id() +"Service");
        System.out.println(adminDTO.getRoleType()+"ROLE");

        return convert.convertToDTO(adminRepository.save(convert.convertToEntity(adminDTO)));

    }

    @Override
    public AdminDTO getSelectedAdmin(String id) {
        Optional<AdminEntity> byId = adminRepository.findById(id);
        if (!byId.isPresent()){
            throw new NotFoundException("Admin Id does not found"+id);
        }
        return convert.convertToDTO(byId.get());

    }

    @Override
    public void updateAdmin(String admin_id,AdminDTO adminDTO) {
        Optional<AdminEntity> adminEntity=adminRepository.findById(admin_id);
        if (!adminEntity.isPresent()){
            throw new NotFoundException("Admin Id does not found :"+admin_id);
            /*adminEntity.get().setAdmin_name(adminDTO.getAdmin_name());
            adminEntity.get().setPassword(adminDTO.getPassword());*/
        }
        AdminEntity admin=adminEntity.get();
        admin.setName(adminDTO.getName());
        admin.setPassword(adminDTO.getPassword());

        adminRepository.save(admin);

    }

    @Override
    public void deleteAdmin(String id) {
        Optional<AdminEntity> byId = adminRepository.findById(id);
        if (!byId.isPresent()){
            throw new NotFoundException("Admin Id does not found :"+id);
        }
        adminRepository.deleteById(id);
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        return adminRepository.findAll().stream().map(admin->convert.convertToDTO(admin)).collect(Collectors.toList());
    }

    @Override
    public AdminEntity getAdminByRole(String role) {
        AdminEntity adminEntityByRole = adminRepository.findAdminEntityByRoleType(role);
        return adminEntityByRole;
    }

    @Override
    public AdminEntity getAdminByName(String userName) {
        AdminEntity adminEntityByName = adminRepository.findAdminEntityByName(userName);

        return adminEntityByName;
    }
}
