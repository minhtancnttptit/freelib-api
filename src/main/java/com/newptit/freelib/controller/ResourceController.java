package com.newptit.freelib.controller;

import com.newptit.freelib.model.Resource;
import com.newptit.freelib.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ResourceController {
    @Autowired
    private ResourceRepository resourceRepository;

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestBody Resource resource) {
        Resource saved = resourceRepository.save(resource);
        if (resource != null) {
            return new ResponseEntity(saved, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/newEbooks")
    public ResponseEntity getNewEbooks() {
        List<Resource> resources = resourceRepository.getResourcesByTypeOrderById("ebook");
        System.out.println(resources);
        if (resources.size() > 0) {
            return new ResponseEntity(resources, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
}