package com.example.adminservice.totResult.controller;

import com.example.adminservice.queGen.model.QueVO;
import com.example.adminservice.queGen.service.QueGenService;
import com.example.adminservice.queTypeRatio.model.AuthDetailVO;
import com.example.adminservice.queTypeRatio.model.AuthVO;
import com.example.adminservice.queTypeRatio.service.AuthQueTypeRatioService;
import com.example.adminservice.totResult.service.TotResultService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin-service")
public class TotResultController {

    @Autowired
    private TotResultService totResultService;

    @Autowired
    private AuthQueTypeRatioService authQueTypeRatioService;

    @GetMapping("/totResult")
    @Timed(value = "admin.totResult",longTask = true)
    public ModelAndView totResult(Model model, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("totResult/totResultList");

        //메뉴타입
        model.addAttribute("menu_nm","totResult");

        //인증분야리스트
        List<AuthVO> authList = authQueTypeRatioService.authList();
        model.addAttribute("authList",authList);

        //인증분야세부리스트
        List<AuthDetailVO> authDetailList = authQueTypeRatioService.authQueTypeRatioList();
        model.addAttribute("authDetailList",authDetailList);

        return mav;
    }

    @PostMapping("/totResult")
    @Timed(value = "admin.searchTotResult",longTask = true)
    public ArrayList<HashMap<String,String>> searchTotResult(Model model, HttpServletRequest request, String auth
            , String staymd, String endymd, String gubun){
        ModelAndView mav = new ModelAndView("totResult/totResultList");

        //메뉴타입
        model.addAttribute("menu_nm","totResult");

        String param_sta = staymd.replaceAll("-","");
        param_sta  = param_sta.replaceAll("T","");
        param_sta  = param_sta.replaceAll(":","");
        String param_end = endymd.replaceAll("-","");
        param_end = param_end.replaceAll("T","");
        param_end = param_end.replaceAll(":","");

        //결과조회
        System.out.println(auth+param_sta+gubun+param_end);
        ArrayList<HashMap<String,String>> searchTotResult = totResultService.searchTotResult(auth,param_sta,param_end,gubun);
        System.out.println(searchTotResult);

        return searchTotResult;
    }

    @PostMapping("/totResult/selectBox")
    public ArrayList<HashMap<String,String>> totResultSelectBox(String auth, Model model, HttpServletRequest request){

        //파라미터
        String param_auth = auth;
        System.out.println(param_auth);

        //일일학습 학습항목리스트
        ArrayList<HashMap<String,String>> authDetailList = totResultService.totResultSelectBox(param_auth);
        System.out.println(authDetailList.toString());

        return authDetailList;
    }
}
