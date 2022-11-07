package com.example.adminservice.queTypeRatio.controller;

import com.example.adminservice.queTypeRatio.model.AuthDetailVO;
import com.example.adminservice.queTypeRatio.model.AuthVO;
import com.example.adminservice.queTypeRatio.service.AuthQueTypeRatioService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin-service")
public class AuthQueTypeRatioController {

    @Autowired
    private AuthQueTypeRatioService authQueTypeRatioService;

    @GetMapping("/queTypeRatio")
    @Timed(value = "admin.queTypeRatio",longTask = true)
    public ModelAndView boardList(Model model, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("authQueTypeRatio/authQueTypeRatioList");

        //메뉴타입
        model.addAttribute("menu_nm","queTypeRatio");

        //인증분야
        List<AuthVO> authList = authQueTypeRatioService.authList();
        System.out.println("authList====" + authList.toString());
        model.addAttribute("authList", authList);

        //인증세부분야
        List<AuthDetailVO> authQueTypeRatioList = authQueTypeRatioService.authQueTypeRatioList();
        System.out.println("authQueTypeRatioList====" + authQueTypeRatioList.toString());
        model.addAttribute("authQueTypeRatioList", authQueTypeRatioList);


        return mav;
    }

    @PostMapping("/queTypeRatio/searchAuthDetail")
    @ResponseBody
    public List<AuthDetailVO> searchAuthDetail(String authcd, HttpServletRequest request){

        System.out.println("::::::::::::::::::::::::   "+authcd);

        //인증세부분야
        List<AuthDetailVO> authQueTypeRatioSelect = authQueTypeRatioService.authQueTypeRatioSelect(authcd);
        System.out.println("authQueTypeRatioList====" + authQueTypeRatioSelect.toString());

        return authQueTypeRatioSelect;
    }

    @GetMapping("/queTypeRatio/queTypeRatioAuthModal")
    @ResponseBody
    public ModelAndView queTypeRatioAuthModal(Model model, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("authQueTypeRatio/popup/authModal");

        return mav;
    }

    @GetMapping("/queTypeRatio/queTypeRatioAuthDetailModal")
    @ResponseBody
    public ModelAndView queTypeRatioAuthDetailModal(Model model, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("authQueTypeRatio/popup/authDetailModal");

        //인증분야콤보박스
        List<AuthVO> authList = authQueTypeRatioService.authList();
        System.out.println("authList====" + authList.toString());
        model.addAttribute("authList", authList);

        return mav;
    }

    @PostMapping("/queTypeRatio/queTypeRatioAuthModal/insertAuth")
    @ResponseBody
    public void queTypeRatioAuthModalInsert(AuthVO authVO,Model model, HttpServletRequest request){
        System.out.println(authVO);

        authQueTypeRatioService.insertAuth(authVO);
    }

    @PostMapping("/queTypeRatio/queTypeRatioAuthModal/deleteAuth")
    @ResponseBody
    public void queTypeRatioAuthModalDelete(String authcd,Model model, HttpServletRequest request){
        //인증분야 삭제
        authQueTypeRatioService.deleteAuth(authcd);

        //인증세부분야 삭제
        List<AuthDetailVO> authQueTypeRatioList = authQueTypeRatioService.authQueTypeRatioList();
        for (var i = 0; i < authQueTypeRatioList.size(); i++){
            AuthDetailVO authDetailVO = authQueTypeRatioList.get(i);
            if(authDetailVO.getAUTHCD().equals(authcd)){
                authQueTypeRatioService.deleteQtype(authDetailVO.getQTYPECD());
                authQueTypeRatioService.deleteQtypeRatio(authDetailVO.getQTYPECD());
            }
        }
    }

    @PostMapping("/queTypeRatio/queTypeRatioAuthModal/insertAuthDetail")
    @ResponseBody
    public void queTypeRatioAuthQtypeModalInsert(String authcd,String qtypecd,String qtypenm,int ratio,Model model
                                                , HttpServletRequest request){
        AuthDetailVO authDetailVO = new AuthDetailVO();
        authDetailVO.setAUTHCD(authcd);
        authDetailVO.setQTYPECD(qtypecd);
        authDetailVO.setQTYPENM(qtypenm);
        authDetailVO.setRATION(ratio);

        System.out.println(authDetailVO);

        //quetype, ratio 저장
        authQueTypeRatioService.insertQtype(authDetailVO);
        authQueTypeRatioService.insertQtypeRatio(authDetailVO);
    }

    @PostMapping("/queTypeRatio/queTypeRatioAuthModal/deleteQtype")
    @ResponseBody
    public void queTypeRatioAuthQtypeModalDelete(String qtypecd,Model model, HttpServletRequest request){
        System.out.println(qtypecd);

        authQueTypeRatioService.deleteQtype(qtypecd);
        authQueTypeRatioService.deleteQtypeRatio(qtypecd);
    }
}
