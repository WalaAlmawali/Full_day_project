package com.example.visitorlog.controller;

import com.example.visitorlog.model.Visitor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private List<Visitor> visitors = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();


    @GetMapping
    public List<Visitor> getAllVisitors() {
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

    @PostMapping
    public ResponseEntity<Visitor> addVisitor(@RequestBody Visitor visitor) {
        visitor.setId(counter.incrementAndGet());
        visitors.add(visitor);
        return ResponseEntity.ok(visitor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable Long id) {
        boolean removed = visitors.removeIf(visitor -> visitor.getId().equals(id));

        if (removed) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }

        return ResponseEntity.notFound().build(); // 404 Not Found
    }


}
