package com.example.demo.services;

import com.example.demo.data.mybatis.mappers.ProvinceDropdownMapper;
import com.example.demo.data.mybatis.models.DropdownModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinceDropdownService {
    private final ProvinceDropdownMapper provinceDropdownMapper;

    @Transactional(readOnly = true)
    public List<DropdownModel> getAllProvinces() {
        return provinceDropdownMapper.findAllProvinces();
    }

    @Transactional(readOnly = true)
    public List<DropdownModel> getAllActiveProvinces() {
        return provinceDropdownMapper.findAllActiveProvinces("Y");
    }

    @Transactional(readOnly = true)
    public List<DropdownModel> getAllActiveProvincesIn(final List<String> provinceCds) {
        return provinceDropdownMapper.findAllProvincesIn("Y", provinceCds);
    }
}
