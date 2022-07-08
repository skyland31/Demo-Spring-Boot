package com.example.demo.feature.master.gim.services;

import com.example.demo.data.mybatis.mappers.GimMasterMapper;
import com.example.demo.data.mybatis.models.GimHeaderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GimMasterService {
    private final GimMasterMapper mapper;

    public List<GimHeaderModel> getAllGimHeaders() {
        return mapper.findAllGimHeaders();
    }
}
