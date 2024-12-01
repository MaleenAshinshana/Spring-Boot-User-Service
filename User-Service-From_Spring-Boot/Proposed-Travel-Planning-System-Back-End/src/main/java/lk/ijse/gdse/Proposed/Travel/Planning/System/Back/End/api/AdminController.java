package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.api;

import jakarta.validation.Valid;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.converter.Convert;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.dto.AdminDTO;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.entity.AdminEntity;
import lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin("*")
public class AdminController {
    private final AdminService adminService;
    private final Convert convert;

    public AdminController(AdminService adminService, Convert convert) {
        this.adminService = adminService;
        this.convert = convert;
    }

    @PostMapping("/adminLogin")
    public ResponseEntity<AdminDTO> adminLogin(@RequestParam String name,
                                               @RequestParam String password) {
        AdminEntity adminByName = adminService.getAdminByName(name);

        if (adminByName != null) {
            if (adminByName.getPassword().equalsIgnoreCase(password)) {

                AdminDTO adminDTO = convert.convertToDTO(adminByName);

                adminDTO.setRoleType(String.valueOf(adminByName.getRoleType()));
                return ResponseEntity.status(HttpStatus.OK).body(adminDTO);
            } else {
                // Password does not match, return an error message
                String errorMessage = "Incorrect password";
                AdminDTO errorDTO = new AdminDTO();
                /*errorDTO.setError(errorMessage);*/
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDTO);
            }
        } else {
            // Admin not found, return an error message
            String errorMessage = "Admin not found";
            AdminDTO errorDTO = new AdminDTO();
            /*errorDTO.setError(errorMessage);*/
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
        }
    }


    @PostMapping("/login")
public ResponseEntity<AdminDTO> login(
        @RequestParam String role,
        @RequestParam String user_name,
        @RequestParam String password

){
    AdminEntity adminByRole = adminService.getAdminByRole(role);
    if (adminByRole!=null){
        if (adminByRole.getName().equals(user_name)){
            if (adminByRole.getPassword().equals(password)){
                AdminDTO adminDTO = convert.convertToDTO(adminByRole);
                return ResponseEntity.status(HttpStatus.OK).body(adminDTO);
            }
        }

    }
    return (ResponseEntity<AdminDTO>) ResponseEntity.status(HttpStatus.BAD_REQUEST);

}
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    AdminDTO save(@Valid @RequestBody AdminDTO adminDTO){
        System.out.println(adminDTO.getName() + "AWA");
        System.out.println(adminDTO + "waeaeaeaea");
        System.out.println(adminDTO.getAdmin_id() +"ID");
        System.out.println(adminDTO.getRoleType()+"CON");
        return adminService.saveAdmin(adminDTO);
    }
    @RequestMapping("/test")
    @PostMapping()
    public String testSave(@RequestBody AdminDTO adminDTO ){
        /*System.out.println("");*/
        System.out.println("OK");
        return adminDTO.getName();


    }

   @GetMapping(value = "/{admin_id}")
   ResponseEntity <AdminDTO> getAdmin( @PathVariable String admin_id){
       AdminDTO selectedAdmin = adminService.getSelectedAdmin(admin_id);
       return new ResponseEntity<>(selectedAdmin,HttpStatus.OK);
   }
   @DeleteMapping(value = "/{admin_id}")
    void deleteAdmin( @PathVariable String admin_id){
        adminService.deleteAdmin(admin_id);
   }
   @PatchMapping(value = "/{admin_id}")
    void  updateAdmin(@Valid @PathVariable String admin_id,@RequestBody AdminDTO adminDTO){
        adminService.updateAdmin(admin_id,adminDTO);
   }
    @GetMapping
    public  ResponseEntity<List<AdminDTO>> getAllUsers(){
        List<AdminDTO> adminDTOS=adminService.getAllAdmins();
        return new ResponseEntity<>(adminDTOS,HttpStatus.OK);
    }

}
