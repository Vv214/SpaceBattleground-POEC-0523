// package com.templateproject.api.controller;

// import java.security.Provider.Service;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.templateproject.api.entity.Clan;
// import com.templateproject.api.entity.Postmapping;
// import com.templateproject.api.service.ClanService;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;
// import jakarta.validation.Payload;

// @RestController
// //@RequestMapping("/clans")

// public class ClanControler {

//    private final ClanService clanService;

//    ClanControler(ClanService clanService) {

//     this.clanService = clanService;
// }

// @Postmapping("/clan")
// public ResponseEntity<Payload> addClan(@RequestBody Clan clan) {
//     var payload = new Payload();
//     try {
//         clanService.add(clan.getClanName(), clan.getClanTag(), clan.getClanLvl());
//         payload.setMessage(clan.getClanName() + " added");
//         return new ResponseEntity<>(payload ,HttpStatus.CREATED);
//     } catch (Exception e) {
//         // TODO: handle exception
//         payload.setMessage(e.getMessage());
//             return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }
// @GetMapping("/clan")
// public ResponseEntity<Payload> getAllClan() {
//     var payload = new Payload();
//     try {
//         payload.setData(clanService.getAll());
//         payload.setMessage("Get all clan");
//         return new ResponseEntity<>(payload, HttpStatus.OK);
//     } catch (Exception e) {
//         payload.setMessage(e.getMessage());
//         payload.setData(null);
//         return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }

// @GetMapping("/clan/{name}")
//     public ResponseEntity<Payload> getClanByTag(@PathVariable String name) {
//         var payload = new Payload();
//         try {
//             var clan = clanService.getByName(name);
//             payload.setMessage("Get clan by name '" + name +"'");
//             payload.setData(clan);
//             return new ResponseEntity<>(payload, HttpStatus.OK);
//         } catch (Exception e) {
//             payload.setMessage(e.getMessage());
//             payload.setData(null);
//             return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }

//     @PutMapping("/clan/{name}")
//     public ResponseEntity<Payload> updateClan(@PathVariable String name, @RequestBody Clan clan) {
//         var payload = new Payload();
//         try {
//             clanService.update(name, clan.getClanName(), clan.getClanTag(), clan.getClanLvl());
//             payload.setMessage("Clan updated");
//             return new ResponseEntity<>(payload, HttpStatus.OK);
//         } catch (Exception e) { //TODO NOT FOUND
//             payload.setMessage(e.getMessage());
//             return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }

//     @DeleteMapping("/clan/{name}")
//     public ResponseEntity<Payload> deleteClan(@PathVariable String name) {
//         var payload = new Payload();
//         try {
//             clanService.delete(name);
//             payload.setMessage("'" + name+ "' deleted");
//             return new ResponseEntity<>(payload, HttpStatus.OK);
//         } catch (Exception e) { //TODO 4.x.x
//             payload.setMessage(e.getMessage());
//             return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }





// }
