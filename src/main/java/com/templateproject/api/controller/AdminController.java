// package com.templateproject.api.controller;

// import com.templateproject.api.controller.payload.Payload;
// import com.templateproject.api.controller.payload.AdminPayload;
// import com.templateproject.api.entity.Admin;
// import com.templateproject.api.service.AdminService;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.*;

// @Controller
// public class AdminController {

// private final AdminService adminService;

// public AdminController(AdminService adminService) {
// this.adminService = adminService;
// }

// // CREATE
// @PostMapping("/admin")
// public ResponseEntity<AdminPayload> addAdmin(@RequestBody Admin admin) {
// var payload = new AdminPayload();
// try {
// adminService.addAdmin(
// admin.getName(),
// admin.isCreatePlayer(),
// admin.isRemovPlayer(),
// admin.isCreatePlanet(),
// admin.isRemovePlanet(),
// admin.isGiveRessources(),
// admin.isRemoveRessources(),
// admin.isCreateBuilding(),
// admin.isRemoveBuilding(),
// admin.isGiveClan(),
// admin.isRemoveClan(),
// admin.isAddToClan(),
// admin.isDeleteToClan());
// payload.setMessage(admin.getName() + "created");
// return new ResponseEntity<>(payload, HttpStatus.CREATED);
// } catch (Exception e) {
// payload.setMessage(e.getMessage());
// return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
// }
// }

// // RESEARCH ALL
// @GetMapping("/admins")
// public ResponseEntity<Payload> getAllAdmins() {
// var payload = new Payload();
// try {
// payload.setData(adminService.getAllAdmins());
// payload.setMessage("Get all Admins Game");
// return new ResponseEntity<>(payload, HttpStatus.OK);
// } catch (Exception e) {
// payload.setMessage(e.getMessage());
// payload.setData(null);
// return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
// }

// }

// // RESARCH ONE
// @GetMapping("/admin/{name}")
// public ResponseEntity<Payload> getAdmin(@PathVariable String name) {
// var payload = new Payload();
// try {
// var admin = adminService.getAdmin();
// payload.setMessage("Get Amdim Game " + name + "'");
// payload.setData(admin);
// } catch (Exception e) {
// payload.setMessage(e.getMessage());
// payload.setData(null);
// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// // TODO: handle exception
// }

// }

// // UPDATE ONE >>>>>HERE<<<<<<<
// @PutMapping("/admin/{name}")
// public ResponseEntity<AdminPayload> updateAdmin(@PathVariable String name,
// @RequestBody Admin admin) {

// }

// // DELETE ONE
// @DeleteMapping("/admin/{name}")
// public ResponseEntity<Payload> deleteAdmin(@PathVariable String name) {
// return new ResponseEntity<>(HttpStatus.OK); // TODO
// }
// }
