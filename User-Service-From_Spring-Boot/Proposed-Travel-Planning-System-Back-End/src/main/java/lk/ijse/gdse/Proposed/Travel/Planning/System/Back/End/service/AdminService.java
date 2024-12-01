package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.service;

import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.dto.AdminDTO;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity.AdminEntity;

import java.util.List;

public interface AdminService {
   AdminDTO saveAdmin(AdminDTO adminDTO);
   AdminDTO getSelectedAdmin(String id);
   void  updateAdmin(String admin_id,AdminDTO adminDTO);
   void  deleteAdmin(String id);
   List<AdminDTO> getAllAdmins();
   AdminEntity getAdminByRole(String role);

   AdminEntity getAdminByName(String userName);

   /* AdminDTO saveAdmin(String id, String userName, String password);*/

}
