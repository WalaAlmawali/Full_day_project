package com.example.visitorlog.controller;

import com.example.visitorlog.model.Visitor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private List<Visitor> visitors = new ArrayList<>();
    private AtomicLong counter= new AtomicLong();


    @GetMapping
    public List<Visitor> getAllVisitors(){
        return visitors;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable Long id) {
        for (Visitor visitor : visitors) {
            if (visitor.getId().equals(id)) {
                return ResponseEntity.ok(visitor);
            }
        }
        return ResponseEntity.notFound().build();
    }




}
