package com.example.demo.services;

import com.example.demo.data.jpa.entities.GimHeaderHbn;
import com.example.demo.data.jpa.repositories.GimHeaderRepository;
import com.example.demo.data.mybatis.mappers.GimMasterMapper;
import com.example.demo.data.mybatis.models.GimHeaderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GimMasterService {
    private final GimHeaderRepository headerRepository;
    private final GimMasterMapper gimMasterMapper;

    @Transactional(readOnly = true)
    public List<GimHeaderHbn> findAllGimHeader(){
        List<GimHeaderHbn> returnList = new ArrayList<>();
        headerRepository.findAll().forEach(returnList::add);
        return returnList;
    }

    @Transactional(readOnly = true)
    public List<GimHeaderHbn> findAllGimHeaderByCdLength(Integer cdLength){
        return headerRepository.findAllByCdLength(cdLength);
    }

    @Transactional(readOnly = true)
    public List<GimHeaderModel> findAllGimHeaderByMyBatis(){
        return gimMasterMapper.findAllGimHeaders();
    }
}
