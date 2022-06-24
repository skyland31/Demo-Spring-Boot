package com.example.demo.controllers;

import com.example.demo.data.mybatis.models.DropdownModel;
import com.example.demo.dto.DropdownDTO;
import com.example.demo.services.ProvinceDropdownService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProvinceDropdownController {
    private final ProvinceDropdownService provinceDropdownService;

    @GetMapping("/dropdown/provinces")
    public List<DropdownDTO> getAllProvinces() {
        return provinceDropdownService.getAllProvinces().stream().map(this::convertDropdownModelToDTO).collect(Collectors.toList());
    }

    @GetMapping("/dropdown/active/provinces")
    public List<DropdownDTO> getAllActiveProvinces() {
        return provinceDropdownService.getAllActiveProvinces().stream().map(this::convertDropdownModelToDTO).collect(Collectors.toList());
    }

    @GetMapping("/dropdown/active/provinces/in/{provinceList}")
    public List<DropdownDTO> getAllActiveProvinces(@PathVariable("provinceList") final String provinceCodes) {
        List<String> provinceList = Arrays.asList(StringUtils.split(provinceCodes, ","));
        return provinceDropdownService.getAllActiveProvincesIn(provinceList).stream().map(this::convertDropdownModelToDTO).collect(Collectors.toList());
    }

    private DropdownDTO convertDropdownModelToDTO(DropdownModel model) {
        return new DropdownDTO(model.getValText(), model.getLabelText());
    }
}
