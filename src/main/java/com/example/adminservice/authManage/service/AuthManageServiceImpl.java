package com.example.adminservice.authManage.service;

import com.example.adminservice.authManage.mapper.AuthManageMapper;
import com.example.adminservice.authManage.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthManageServiceImpl implements AuthManageService {
    private AuthManageMapper authManageMapper;

    @Autowired
    public AuthManageServiceImpl(AuthManageMapper authManageMapper) {
        this.authManageMapper = authManageMapper;
    }

    @Override
    public List<UserVO> getUserList() {
        return authManageMapper.getUserList();
    }

    @Override
    public List<UserVO> searchUserList(String boardAuth, String queAuth, String queTypeAuth) {
        return authManageMapper.searchUserList(boardAuth, queAuth, queTypeAuth);
    }

    @Override
    public void saveUserList(UserVO userVO) {
        authManageMapper.saveUserList(userVO);
    }
}