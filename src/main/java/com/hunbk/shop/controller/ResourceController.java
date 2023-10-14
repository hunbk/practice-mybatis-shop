package com.hunbk.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceLoader resourceLoader;

    @GetMapping("/images/{fileName}")
    public ResponseEntity<Resource> serveImage(@PathVariable String fileName) {
        Resource image = resourceLoader.getResource(StringConst.UPLOAD_PATH + fileName);
        return ResponseEntity.ok().body(image);
    }
}
