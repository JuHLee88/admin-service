package com.example.adminservice.queGen.service;

import com.example.adminservice.queGen.model.QueListVO;
import com.example.adminservice.queGen.model.QueVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QueGenService {
    List<QueVO> queGenList(); //첫 화면에서 나오는 데이터
    List<QueListVO> queGenDetail(String qid); //상세내역 데이터
    List<QueVO> selectQueType(); //문제분류에 따른 인증분야 조회
    List<QueVO> selectQueTypeByAuth(); //문제분류에 따른 인증분야 조회
    List<QueVO> maxQid(); //qid값 가져오기
    void queWrite(QueListVO quelistVO); //작성하기
    void queWrite1(QueListVO quelistVO); //작성하기
    void queWrite2(QueListVO quelistVO); //작성하기
    void queWrite3(QueListVO quelistVO); //작성하기
    void queWrite4(QueListVO quelistVO); //작성하기
    //문제관리조회
    List<QueVO> queGenListSearch(String auth, String authDetail, String staymd, String endymd, String searchItem, String searchInput);
    void queGenDelete(String qidPop);

    List<QueListVO> queGenModifyDetail(String qid);

    void queGenModifyUpdateQue(QueListVO queListVO);
    void queGenModifyUpdateQueItem(QueListVO queListVO);
}
