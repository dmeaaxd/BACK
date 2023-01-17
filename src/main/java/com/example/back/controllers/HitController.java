package com.example.back.controllers;

import com.example.back.entities.Hit;
import com.example.back.services.HitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class HitController {

    private final HitService hitService;

    public HitController(HitService hitService) {
        this.hitService = hitService;
    }

    @PostMapping("/hit")
    public ResponseEntity<?> hit(@RequestBody Hit hit) {
        if (hit.getX() == null || hit.getY() == null || hit.getR() == null) {
            return ResponseEntity.badRequest().build();
        }

        return hitService.service(hit.getX(), hit.getY(), hit.getR());

    }

    @GetMapping("/hits")
    public ResponseEntity<List<Hit>> getAllHits() {
        return hitService.getHits();
    }

    @DeleteMapping("/hits")
    public ResponseEntity delete() {
        return hitService.delete();
    }
}
