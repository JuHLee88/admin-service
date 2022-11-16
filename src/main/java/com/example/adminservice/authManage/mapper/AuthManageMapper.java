package com.example.adminservice.authManage.mapper;

import com.example.adminservice.authManage.model.UserVO;
import com.example.adminservice.queGen.model.QueVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthManageMapper {

    List<UserVO> getUserList();

    List<UserVO> searchUserList(String boardAuth, String queAuth, String queTypeAuth);

    void saveUserList(UserVO userVO);
}
