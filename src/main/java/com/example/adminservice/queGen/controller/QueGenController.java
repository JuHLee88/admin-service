package com.example.adminservice.queGen.controller;

import com.example.adminservice.queGen.model.QueListVO;
import com.example.adminservice.queGen.model.QueVO;
import com.example.adminservice.queGen.service.QueGenService;
import com.example.adminservice.queTypeRatio.model.AuthDetailVO;
import com.example.adminservice.queTypeRatio.model.AuthVO;
import com.example.adminservice.queTypeRatio.service.AuthQueTypeRatioService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/admin-service")
public class QueGenController {

    @Autowired
    private QueGenService queGenService;

    @Autowired
    private AuthQueTypeRatioService authQueTypeRatioService;

    //문제등록 - 리스트
    @GetMapping("/queGen")
    @Timed(value = "admin.queGenlist",longTask = true)
    public ModelAndView boardList(Model model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("queGen/queGenList");

        //메뉴타입
        model.addAttribute("menu_nm", "queGen");

        //문제리스트
        List<QueVO> queGenList = queGenService.queGenList();
        model.addAttribute("queGenList", queGenList);

        //인증분야리스트
        List<AuthVO> authList = authQueTypeRatioService.authList();
        model.addAttribute("authList",authList);

        //인증분야세부리스트
        List<AuthDetailVO> authDetailList = authQueTypeRatioService.authQueTypeRatioList();
        model.addAttribute("authDetailList",authDetailList);


        return mav;
    }

    //문제등록 - 리스트
    @PostMapping("/queGen")
    public ModelAndView boardListSearch(Model model, HttpServletRequest request, String auth, String authDetail
                                     , String staymd, String endymd, String searchItem, String searchInput) {
        ModelAndView mav = new ModelAndView("queGen/queGenList");

        System.out.println(":::::::::::::::::  "+auth);
        System.out.println(":::::::::::::::::  "+authDetail);
        System.out.println(":::::::::::::::::  "+staymd);
        System.out.println(":::::::::::::::::  "+endymd);
        System.out.println(":::::::::::::::::  "+searchItem);
        System.out.println(":::::::::::::::::  "+searchInput);

        String param_staymd = staymd.replaceAll("-","");
        String param_endymd = endymd.replaceAll("-","");;


        //메뉴타입
        model.addAttribute("menu_nm", "queGen");

        //문제리스트
        List<QueVO> queGenList = queGenService.queGenListSearch(auth, authDetail, param_staymd, param_endymd, searchItem, searchInput);
        model.addAttribute("queGenList", queGenList);

        //인증분야리스트
        List<AuthVO> authList = authQueTypeRatioService.authList();
        model.addAttribute("authList",authList);

        //인증분야세부리스트
        List<AuthDetailVO> authDetailList = authQueTypeRatioService.authQueTypeRatioList();
        model.addAttribute("authDetailList",authDetailList);


        return mav;
    }

    //문제등록 - 문제상세내역
    @GetMapping("/queGenPopup")
    public ModelAndView queGenDetail(@RequestParam String qid, Model model, HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("queGen/popup/queGenModal");
        //메뉴타입
        model.addAttribute("menu_nm", "queGen");

        System.out.println("queGenDetail#############################################");
        System.out.println("qtypecd==" + qid);
        //model.addAttribute("menu_nm", "queListPrint");
        List<QueListVO> queGenDetail = queGenService.queGenDetail(qid);
        System.out.println("queGenDetailList==" + queGenDetail);
        model.addAttribute("queGenDetail", queGenDetail);

        return mav;
    }

    //문제등록 - 등록화면
    @GetMapping("/queGenCreate")
    @Timed(value = "admin.queGenCreate",longTask = true)
    public ModelAndView queGenCreate(Model model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("queGen/queGenCreate");

        //메뉴타입
        model.addAttribute("menu_nm", "queGen");

        // List<QueVO> queGenList = queGenService.queGenList();
        // model.addAttribute("queGenList", queGenList);

        List<QueVO> selectQueType = queGenService.selectQueType();
        model.addAttribute("selectQueType", selectQueType);

        List<QueVO> selectQueTypeByAuth = queGenService.selectQueTypeByAuth();
        model.addAttribute("selectQueTypeByAuth", selectQueTypeByAuth);

        List<QueVO> maxQid = queGenService.maxQid();
        model.addAttribute("maxQid", maxQid);


        return mav;
    }

    //문제등록 - 문제저장
    @RequestMapping(value = "/queGen/queGenCreate", method = {RequestMethod.POST})
    public ModelAndView queWritePost(Model model, HttpServletRequest request, @ModelAttribute QueListVO create) {
        ModelAndView mav = new ModelAndView("queGen/queGenList");
        //메뉴타입
        model.addAttribute("menu_nm", "queGen");

        //날짜 구하기
        LocalDate date = LocalDate.now();
        String writedt = date.toString();
        String anscd1 = "0";
        writedt = writedt.replaceAll("-", "");
        //queListVO 데이터 셋 만들기
        QueListVO quelisteVO = new QueListVO();
        if (create.getQtypecd() != "NULL" && create.getQuestion() != "NULL") {
//문제등록
            quelisteVO.setQid(create.getQid());
            quelisteVO.setQtypecd(create.getQtypecd());
            quelisteVO.setLvl(create.getLvl());
            quelisteVO.setQuestion(create.getQuestion());
            quelisteVO.setCreatedt(writedt);
            quelisteVO.setExplanation(create.getExplanation());
//보기등록
            quelisteVO.setItemid1("1");
            quelisteVO.setItemid2("2");
            quelisteVO.setItemid3("3");
            quelisteVO.setItemid4("4");

            quelisteVO.setItem1(create.getItem1());
            quelisteVO.setItem2(create.getItem2());
            quelisteVO.setItem3(create.getItem3());
            quelisteVO.setItem4(create.getItem4());

            if (create.getAnscd().equals("1")) {
                quelisteVO.setAnscd1(anscd1);
            } else if (create.getAnscd().equals("2")) {
                quelisteVO.setAnscd2(anscd1);
            } else if (create.getAnscd().equals("3")) {
                quelisteVO.setAnscd3(anscd1);
            } else if (create.getAnscd().equals("4")) {
                quelisteVO.setAnscd4(anscd1);
            }
            queGenService.queWrite(quelisteVO);
            queGenService.queWrite1(quelisteVO);
            queGenService.queWrite2(quelisteVO);
            queGenService.queWrite3(quelisteVO);
            queGenService.queWrite4(quelisteVO);
        }

        //게시판 리스트
        List<QueVO> queGenList = queGenService.queGenList();
        model.addAttribute("queGenList", queGenList);

        return mav;
    }

    @RequestMapping(value = "/queGen/queGenDelete", method = {RequestMethod.POST})
    public void queWriteGet(Model model, HttpServletRequest request, String qid) {
        queGenService.queGenDelete(qid);
    }

    //문제수정 - 수정화면
    @GetMapping("/queGenModify")
    public ModelAndView queGenModifyDetail(@RequestParam String qid, Model model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("queGen/queGenModify");

        //메뉴타입
        model.addAttribute("menu_nm", "queGen");

        //문제상세내용
        List<QueListVO> queGenModifyDetail = queGenService.queGenModifyDetail(qid);
        model.addAttribute("queGenModifyDetail", queGenModifyDetail);

        return mav;
    }


    //문제수정 - 저장
    @PostMapping("/queGenModify")
    public ModelAndView queGenModifyUpdate(Model model, HttpServletRequest request, QueListVO queListVO) {
        ModelAndView mav = new ModelAndView("queGen/queGenList");

        //메뉴타입
        model.addAttribute("menu_nm", "queGen");

        //문제수정
        queGenService.queGenModifyUpdateQue(queListVO);
        queGenService.queGenModifyUpdateQueItem(queListVO);
        System.out.println("::::::::::::::::::::::::::     "+queListVO);

        //게시판 리스트
        List<QueVO> queGenList = queGenService.queGenList();
        model.addAttribute("queGenList", queGenList);

        return mav;
    }
}
