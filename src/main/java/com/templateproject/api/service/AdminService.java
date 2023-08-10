package com.templateproject.api.service;

import com.templateproject.api.controller.payload.AdminPayload;
import com.templateproject.api.entity.Admin;
import com.templateproject.api.repository.AdminRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AdminService {

  private final AdminRepository adminRepository;

  public AdminService(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  // CREATE
  public void addAdmin(
     String name,
     boolean createPlayer, 
     boolean removPlayer,
     boolean createPlanet,
     boolean removePlanet, 
     boolean giveRessources, 
     boolean removeRessources,
     boolean createBuilding, 
     boolean removeBuilding, 
     boolean giveClan, 
     boolean removeClan,
     boolean addToClan,
     boolean deleteToClan
  ) {
    var admin = new Admin (
    name,
    createPlayer,
    removPlayer,
    createPlanet,
    removePlanet, 
    giveRessources, 
    removeRessources,
    createBuilding, 
    removeBuilding, 
    giveClan, 
    removeClan,
    addToClan,
    deleteToClan
    );
    adminRepository.save(admin);
  }

  // RESEARCH ALL
  public List<AdminPayload> getAllAdmins() {
    var payload = new ArrayList <AdminPayload>();

    List <Admin> adminList= adminRepository.findAll();
    for (var admin : adminList){
      var newAdmin = new AdminPayload();
        newAdmin.setName(admin.getName());
        newAdmin.setCreatePlayer(admin.isCreatePlayer());
        newAdmin.setRemovPlayer(admin.isRemovPlayer());
        newAdmin.setCreatePlanet(admin.isCreatePlanet());
        newAdmin.setRemovePlanet(admin.isRemovePlanet()); 
        newAdmin.setGiveRessources(admin.isGiveRessources()); 
        newAdmin.setRemoveRessources(admin.isRemoveRessources());
        newAdmin.setCreateBuilding(admin.isCreateBuilding()); 
        newAdmin.setRemoveBuilding(admin.isRemoveBuilding()); 
        newAdmin.setGiveClan(admin.isGiveClan()); 
        newAdmin.setRemoveClan(admin.isRemoveClan());
        newAdmin.setAddToClan(admin.isAddToClan());
        newAdmin.setDeleteToClan(admin.isDeleteToClan());
        payload.add(newAdmin);      
    }
    return payload; 
  }

  // RESARCH ONE
  public HashMap<String, Object> getAdmin(String name) {
    var admin = new HashMap<String, Object>();
    var adminEntity = adminRepository.findByName(name);
        admin.put("Name : ",adminEntity.getName());
        admin.put("Can create a new Player : ", adminEntity.isCreatePlayer());
        admin.put("Can remove a new Player : ", adminEntity.isRemovPlayer());
        admin.put("Can Create a nex Planet : ", adminEntity.isCreatePlanet());
        admin.put("Can Delete a Planet : ", adminEntity.isRemovePlanet()); 
        admin.put("Can add Ressources : ", adminEntity.isGiveRessources()); 
        admin.put("Can Delete Reesources : ", adminEntity.isRemoveRessources());
        admin.put("Can Create or evolve new Building : ", adminEntity.isCreateBuilding()); 
        admin.put("Can Remove a Building : ", adminEntity.isRemoveBuilding()); 
        admin.put("Can Create a Clan : ", adminEntity.isGiveClan()); 
        admin.put("Can Delete a Clan : ", adminEntity.isRemoveClan());
        admin.put("Can add a player to Clan :", adminEntity.isAddToClan());
        admin.put("Can Delete a Clan :",adminEntity.isDeleteToClan());
    return admin;
  }

  // UPDATE ONE
  public void updateAdmin(
    String nameAdminTarget,
    AdminPayload admin
    ) throws Exception {
    var adminToUpdate = adminRepository.findByName(nameAdminTarget);
    if( nameAdminTarget == null ){
      throw new Exception(nameAdminTarget + "doesn't exist");
    }
    adminToUpdate.setCreatePlayer(admin.isCreatePlayer());
    adminToUpdate.setRemovPlayer(admin.isRemovPlayer());
    adminToUpdate.setCreatePlanet(admin.isCreatePlanet());
    adminToUpdate.setRemovePlanet(admin.isRemovePlanet());
    adminToUpdate.setGiveRessources(admin.isGiveRessources());
    adminToUpdate.setRemoveRessources(admin.isRemoveRessources());
    adminToUpdate.setCreateBuilding(admin.isCreateBuilding());
    adminToUpdate.setRemoveBuilding(admin.isRemoveBuilding());
    adminToUpdate.setGiveClan(admin.isGiveClan());
    adminToUpdate.setRemoveClan(admin.isRemoveClan());
    adminToUpdate.setAddToClan(admin.isAddToClan());
    adminToUpdate.setDeleteToClan(admin.isDeleteToClan());
    //no condition to evaluate the value presence because boolean can't be null.
    adminRepository.save(adminToUpdate);
  }

  // DELETE ONE
  public ResponseEntity<String> deleteAdmin(String name) {
    adminRepository.deleteByName(name);
    return new ResponseEntity<String>("Rules as been deleted.", HttpStatus.OK);
  }

}
