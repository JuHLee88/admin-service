package com.example.adminservice.authManage.controller;

import com.example.adminservice.authManage.model.UserVO;
import com.example.adminservice.authManage.service.AuthManageService;
import com.example.adminservice.queGen.model.QueVO;
import io.micrometer.core.annotation.Timed;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin-service")
public class AuthManageController {

    @Autowired
    AuthManageService authManageService;

    //권한관리리스트
    @GetMapping("/authManage")
    @Timed(value = "admin.authManage",longTask = true)
    public ModelAndView authManage(Model model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("authManage/authManageList");

        //메뉴타입
        model.addAttribute("menu_nm", "authManage");

        //사용자정보
        List<UserVO> getUserList = authManageService.getUserList();
        model.addAttribute("getUserList", getUserList);

        return mav;
    }


    //권한관리리스트
    @PostMapping("/authManage")
    @Timed(value = "admin.searchAuthManage",longTask = true)
    public List<UserVO> searchAuthManage(Model model, HttpServletRequest request, String boardAuth, String queTypeAuth, String queAuth) {
        System.out.println("::::::::::::::::::::::"+boardAuth+ queAuth+ queTypeAuth);

        //사용자정보
        List<UserVO> getUserList = authManageService.searchUserList(boardAuth, queAuth, queTypeAuth);

        return getUserList;
    }

//    userId+"&"+userAuth+"&"+boardAuth+"&"+queAuth+"&"+queTypeAuth;

    //권한관리리스트
    @PostMapping("/authManage/saveAuthManage")
    @Timed(value = "admin.saveAuthManage",longTask = true)
    public void saveAuthManage(Model model, HttpServletRequest request, UserVO userVO) {
        System.out.println("::::::::::::::::::::::"+ userVO);

        //권한저장
        authManageService.saveUserList(userVO);

//        return getUserList;
    }
}

