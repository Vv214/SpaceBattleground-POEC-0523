package com.templateproject.api.controller;

import com.templateproject.api.controller.payload.Payload;
import com.templateproject.api.controller.payload.AdminPayload;
import com.templateproject.api.entity.Admin;
import com.templateproject.api.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

private final AdminService adminService;

public AdminController(AdminService adminService) {
this.adminService = adminService;
}

// CREATE
@PostMapping
public ResponseEntity<AdminPayload> addAdmin(@RequestBody Admin admin) {
    var payload = new AdminPayload();
    try {
        adminService.addAdmin(
                        admin.getName(),
                        admin.isCreatePlayer(),
                        admin.isRemovPlayer(),
                        admin.isCreatePlanet(),
                        admin.isRemovePlanet(),
                        admin.isGiveRessources(),
                        admin.isRemoveRessources(),
                        admin.isCreateBuilding(),
                        admin.isRemoveBuilding(),
                        admin.isGiveClan(),
                        admin.isRemoveClan(),
                        admin.isAddToClan(),
                        admin.isDeleteToClan()
                    );

        payload.setMessage(admin.getName() + "created");
        return new ResponseEntity<>(payload, HttpStatus.CREATED);
    } catch (Exception e) {
        payload.setMessage(e.getMessage());
        return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

// RESEARCH ALL
@GetMapping("/admins")
    public ResponseEntity<Payload> getAllAdmins() {
        var payload = new Payload();
        try {
        
            payload.setData(adminService.getAllAdmins());
            payload.setMessage("Get all Admins Game");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        
        } catch (Exception e) {
        
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

// RESARCH ONE
@GetMapping("/{name}")
    public ResponseEntity<Payload> getAdmin(@PathVariable String name) {
        var payload = new Payload();
        try {
                var admin = adminService.getAdmin(name);
                payload.setMessage("Get Amdim Game " + name + "'");
                payload.setData(admin);
                return new ResponseEntity<>(payload, HttpStatus.OK);
            } catch (Exception e) {
                
                payload.setMessage(e.getMessage());
                payload.setData(null);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// TODO: handle exception
}

}

// UPDATE ONE 
@PutMapping("/{name}")
public ResponseEntity<AdminPayload> updateAdmin(@PathVariable String name, @RequestBody Admin admin) {
    var payload = new AdminPayload();
    try {
        payload.setName(admin.getName());
        payload.setCreatePlayer(admin.isCreatePlayer());
        payload.setRemovPlayer(admin.isRemovPlayer());
        payload.setCreatePlanet(admin.isCreatePlanet());
        payload.setRemovePlanet(admin.isRemovePlanet()); 
        payload.setGiveRessources(admin.isGiveRessources()); 
        payload.setRemoveRessources(admin.isRemoveRessources());
        payload.setCreateBuilding(admin.isCreateBuilding()); 
        payload.setRemoveBuilding(admin.isRemoveBuilding()); 
        payload.setGiveClan(admin.isGiveClan()); 
        payload.setRemoveClan(admin.isRemoveClan());
        payload.setAddToClan(admin.isAddToClan());
        payload.setDeleteToClan(admin.isDeleteToClan());

        adminService.updateAdmin(name,payload);

        payload.setMessage("Rule Update");
        return new ResponseEntity<>(payload, HttpStatus.OK);
    
    } catch (Exception e) {
        payload.setMessage(e.getMessage());
        return new ResponseEntity<>(payload, HttpStatus.OK);
        // TODO: handle exception
    }
}

// DELETE ONE
@DeleteMapping("/{name}")
public ResponseEntity<Payload> deleteAdmin(@PathVariable String name) {
// TODO set Confirm Message
        var payload = new Payload();
        try {
            adminService.deleteAdmin(name);
            payload.setMessage("Rule deleted");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) { // TODO 4.x.x
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);

        }
}
}
