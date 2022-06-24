package com.example.demo.controllers;

import com.example.demo.data.jpa.entities.GimHeaderHbn;
import com.example.demo.data.mybatis.models.GimHeaderModel;
import com.example.demo.services.GimMasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gimmaster")
@RequiredArgsConstructor
public class DemoController {
    private final GimMasterService service;

    @GetMapping("/headers")
    public List<GimHeaderHbn> findAllGimHeader() {
        return service.findAllGimHeader();
    }

    @GetMapping("/headers/cdlength/{cdLength}")
    public List<GimHeaderHbn> findAllGimHeaderByCdLength(@PathVariable("cdLength") Integer cdLength) {
        return service.findAllGimHeaderByCdLength(cdLength);
    }
    @GetMapping("/mybatis/headers")
    public List<GimHeaderModel> findAllGimHeaderByMyBatis() {
        return service.findAllGimHeaderByMyBatis();
    }
}
