package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.repo;

import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity.AdminEntity;

import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity.AdminType;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<AdminEntity,String> {
List<AdminEntity> findAll();
AdminEntity findAdminEntityByRoleType(String role);
AdminEntity findAdminEntityByName(String name);
/*AdminEntity findByAdmin*/
    /*AdminEntity findByAdminE(String username);*/
/*AdminEntity findBya(String adminType, String username, String password);*/

}
