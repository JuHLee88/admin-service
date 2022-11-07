package com.example.adminservice.queTypeRatio.mapper;

import com.example.adminservice.queTypeRatio.model.AuthDetailVO;
import com.example.adminservice.queTypeRatio.model.AuthVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthQueTypeRatioMapper {

    List<AuthVO> authList();
    List<AuthDetailVO> authQueTypeRatioList();
    List<AuthDetailVO> authQueTypeRatioSelect(String authcd);
    void insertAuth(AuthVO authVO);
    void deleteAuth(String authcd);
    void deleteQtype(String qtypecd);
    void deleteQtypeRatio(String qtypecd);
    void insertQtype(AuthDetailVO authDetailVO);
    void insertQtypeRatio(AuthDetailVO authDetailVO);
}
