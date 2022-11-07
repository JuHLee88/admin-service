package com.example.adminservice.queTypeRatio.service;

import com.example.adminservice.queTypeRatio.mapper.AuthQueTypeRatioMapper;
import com.example.adminservice.queTypeRatio.model.AuthDetailVO;
import com.example.adminservice.queTypeRatio.model.AuthVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthQueTypeRatioServiceImpl implements AuthQueTypeRatioService {

    @Autowired
    private AuthQueTypeRatioMapper authQueTypeRatioMapper;

    @Override
    public List<AuthVO> authList() {
        return authQueTypeRatioMapper.authList();
    }

    @Override
    public List<AuthDetailVO> authQueTypeRatioList() {
        return authQueTypeRatioMapper.authQueTypeRatioList();
    }

    @Override
    public List<AuthDetailVO> authQueTypeRatioSelect(String authcd) {
        return authQueTypeRatioMapper.authQueTypeRatioSelect(authcd);
    }

    @Override
    public void insertAuth(AuthVO authVO) {
        authQueTypeRatioMapper.insertAuth(authVO);
    }

    @Override
    public void deleteAuth(String authcd) {
        authQueTypeRatioMapper.deleteAuth(authcd);
    }

    @Override
    public void deleteQtype(String qtypecd) {
        authQueTypeRatioMapper.deleteQtype(qtypecd);
    }

    @Override
    public void deleteQtypeRatio(String qtypecd) {
        authQueTypeRatioMapper.deleteQtypeRatio(qtypecd);
    }

    @Override
    public void insertQtype(AuthDetailVO authDetailVO) {
        authQueTypeRatioMapper.insertQtype(authDetailVO);
    }

    @Override
    public void insertQtypeRatio(AuthDetailVO authDetailVO) {
        authQueTypeRatioMapper.insertQtypeRatio(authDetailVO);
    }
}
