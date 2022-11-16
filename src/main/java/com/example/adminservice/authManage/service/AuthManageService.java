package com.example.adminservice.authManage.service;

import com.example.adminservice.authManage.model.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthManageService {
    List<UserVO> getUserList();

    List<UserVO> searchUserList(String boardAuth, String queAuth, String queTypeAuth);

    void saveUserList(UserVO userVO);
}
