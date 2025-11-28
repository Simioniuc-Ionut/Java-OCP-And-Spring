package org.example.sq.part1.SmartHomeController.controllers;

import org.example.sq.part1.SmartHomeController.aop.audit.ToLog;
import org.example.sq.part1.SmartHomeController.dto.LightingRequestDTO;
import org.example.sq.part1.SmartHomeController.model.dateTime.DateTimer;
import org.example.sq.part1.SmartHomeController.model.dateTime.TimeTimer;
import org.example.sq.part1.SmartHomeController.model.lightning.Colors;
import org.example.sq.part1.SmartHomeController.services.lightning.LightingControlService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lighting")
@ToLog
public class LightingController {

    private final Map<String,LightingControlService> lightService;

    public LightingController(Map<String,LightingControlService> lightService) {
        this.lightService = lightService;
    }

    @RequestMapping("/{id}/turnOn")
    public ResponseEntity<String> turnOn(@PathVariable long id){
        lightService.get("lightControlServiceImpl").turnOn(id);
        return ResponseEntity.ok().body("The light is turned on.");
    }

    @RequestMapping("/{id}/turnOff")
    public ResponseEntity<String> turnOff(@PathVariable long id){
        lightService.get("lightControlServiceImpl").turnOff(id);
        return ResponseEntity.ok().body("The light is turned off.");
    }

    @RequestMapping(value = "/group/turnOn", method = RequestMethod.POST)
    public ResponseEntity<String> turnOn(){
        lightService.get("groupLightControlServiceImpl").turnOn();
        return ResponseEntity.ok().body("The lights are turned on.");
    }

    @RequestMapping(value = "/group/turnOff", method = RequestMethod.POST)
    public ResponseEntity<String> turnOff(){
        lightService.get("groupLightControlServiceImpl").turnOff();
        return ResponseEntity.ok().body("The lights are turned off.");
    }

    @RequestMapping(value = "/{id}/brightness", method = RequestMethod.PATCH)
    public ResponseEntity<String> changeBrightness(@PathVariable long id, @RequestParam double value){
        lightService.get("lightControlServiceImpl").setBrightness(value, id);
        return ResponseEntity.ok("The light is successfully changed at value: " + value);
    }

    @RequestMapping(value = "/group/brightness", method = RequestMethod.POST)
    public ResponseEntity<String> changeBrightness(@RequestParam double value){
        lightService.get("groupLightControlServiceImpl").setBrightness(value);
        return ResponseEntity.ok("The lights are successfully changed at value: " + value);
    }

    @PatchMapping("/{id}/color/{color}")
    public ResponseEntity<String> changeColor(@PathVariable long id, @PathVariable Colors color){
        lightService.get("lightControlServiceImpl").setColor(color,id);
        return ResponseEntity.ok("The light color are successfully changed with color: " + color);
    }

    @PatchMapping("/group/color/{color}")
    public ResponseEntity<String> changeColor(@PathVariable Colors color){
        lightService.get("groupLightControlServiceImpl").setColor(color);
        return ResponseEntity.ok("The lights color are successfully changed with color: " + color);
    }

    @PatchMapping("/{id}/checkWifi")
    public ResponseEntity<String> checkWifiConnection(@PathVariable Long id){
        return ResponseEntity.ok().body(lightService.get("lightControlServiceImpl").checkWifiConnection(id));
    }

    @PatchMapping("/group/checkWifi")
    public ResponseEntity<String> checkWifiConnection(){
        return ResponseEntity.ok().body(lightService.get("groupLightControlServiceImpl").checkWifiConnection());
    }

    @PatchMapping("/{id}/connectWifi")
    public ResponseEntity<String> connectWifi(@PathVariable long id, @RequestParam String wifiValue){
        lightService.get("lightControlServiceImpl").connectWifi(wifiValue, id);
        return ResponseEntity.ok().body("The light is successfully connected to wifi network: " + wifiValue);
    }

    @PostMapping("/group/connectWifi")
    public ResponseEntity<String> connectWifi(@RequestParam String wifiValue){
        lightService.get("groupLightControlServiceImpl").connectWifi(wifiValue);
        return ResponseEntity.ok().body("The lights are successfully connected to wifi network: " + wifiValue);
    }

    @PatchMapping("/{id}/disconnectWifi")
    public ResponseEntity<String> disconnectWifi(@PathVariable long id){
        lightService.get("lightControlServiceImpl").disconnectWifi(id);
        return ResponseEntity.ok().body("The light is successfully disconnected!");
    }

    @PatchMapping("/group/disconnectWifi")
    public ResponseEntity<String> disconnectWifi(){
        lightService.get("groupLightControlServiceImpl").disconnectWifi();
        return ResponseEntity.ok().body("The lights are successfully disconnected!");
    }

    @GetMapping("/{id}/getLight")
    public ResponseEntity<String> getLight(@PathVariable long id) {
        return ResponseEntity.ok()
                .body(lightService.get("lightControlServiceImpl").getLight(id).toString());
    }

    @GetMapping("/group/getLight")
    public ResponseEntity<String> getLights(@RequestParam List<Long> ids) {
        return ResponseEntity.ok()
                .body(lightService.get("groupLightControlServiceImpl").getLight(ids.toArray(Long[]::new)).toString());
    }

    @PostMapping("/group/create")
    public ResponseEntity<String> createLightProduct(@RequestBody List<LightingRequestDTO> requestList) {
        boolean response = lightService.get("groupLightControlServiceImpl").addLight(requestList.toArray(LightingRequestDTO[]::new));
        return  response? ResponseEntity.ok("The lights are successfully added!")
                : ResponseEntity.internalServerError().body("An error occurred while trying to add.");
    }

    @PostMapping("/create")
    public ResponseEntity<String> createLightProduct(@RequestBody LightingRequestDTO requestList) {
        boolean response = lightService.get("lightControlServiceImpl").addLight(requestList);
        return  response? ResponseEntity.ok("The light has been successfully added!")
                : ResponseEntity.internalServerError().body("An error occurred while trying to add.");
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<java.lang.String> delete(@PathVariable Long id) {
        boolean response = lightService.get("lightControlServiceImpl").removeLight(id);
        return response? ResponseEntity.ok("The light has been successfully deleted!")
                : ResponseEntity.internalServerError().body("An error occurred while trying to delete.");
    }

    @DeleteMapping("/group/delete")
    public ResponseEntity<java.lang.String> delete() {
        boolean response = lightService.get("groupLightControlServiceImpl").removeLight();
        return response? ResponseEntity.ok("The light has been successfully deleted!")
                : ResponseEntity.internalServerError().body("An error occurred while trying to delete.");
    }

    @PutMapping("/{id}/scheduleTime")
    public ResponseEntity<String> scheduleTime(@PathVariable long id, @RequestParam int hour, @RequestParam int minutes) {
        boolean response = lightService.get("lightControlServiceImpl").scheduleTimer(new TimeTimer(hour,minutes), id);
        return response? ResponseEntity.ok("The light has been successfully updated with the time!")
                : ResponseEntity.internalServerError().body("An error occurred while trying to update.");
    }

    @PutMapping("/{id}/scheduleDate")
    public ResponseEntity<String> scheduleTime(@PathVariable long id, @RequestParam LocalDateTime dateTime) {
        boolean response = lightService.get("lightControlServiceImpl").scheduleTimer(new DateTimer(dateTime), id);
        return response? ResponseEntity.ok("The light has been successfully updated with the date!")
                : ResponseEntity.internalServerError().body("An error occurred while trying to update.");
    }

    @PutMapping("/group/scheduleTime")
    public ResponseEntity<String> scheduleTime(@RequestBody List<Long> ids, @RequestParam int hour, @RequestParam int minutes) {
        boolean response = lightService.get("groupLightControlServiceImpl").scheduleTimer(new TimeTimer(hour,minutes), ids.toArray(Long[]::new));
        return response? ResponseEntity.ok("The lights has been successfully updated with the time!")
                : ResponseEntity.internalServerError().body("An error occurred while trying to update.");
    }

    @PutMapping("/group/scheduleDate")
    public ResponseEntity<String> scheduleTime(@RequestBody List<Long> ids, @RequestParam LocalDateTime dateTime) {
        boolean response = lightService.get("groupLightControlServiceImpl").scheduleTimer(new DateTimer(dateTime), ids.toArray(Long[]::new));
        return response? ResponseEntity.ok("The lights has been successfully updated with the date!")
                : ResponseEntity.internalServerError().body("An error occurred while trying to update.");
    }

}
