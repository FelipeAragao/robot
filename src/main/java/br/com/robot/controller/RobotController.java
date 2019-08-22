package br.com.robot.controller;

import br.com.robot.service.RobotSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/rest")
public class RobotController {

    @Autowired
    private RobotSevice robotSevice;

    @PostMapping("/mars/{route}")
    public ResponseEntity<?> index(@PathVariable String route) {
        try {
            return ResponseEntity.ok().body(robotSevice.run(route));
        } catch (Exception e) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("error", e.getMessage());

            return ResponseEntity.badRequest().body(map);
        }
    }
}