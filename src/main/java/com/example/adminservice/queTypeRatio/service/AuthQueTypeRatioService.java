package com.example.adminservice.queTypeRatio.service;

import com.example.adminservice.queTypeRatio.model.AuthDetailVO;
import com.example.adminservice.queTypeRatio.model.AuthVO;

import java.util.List;

public interface AuthQueTypeRatioService {

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
