package com.example.adminservice.queGen.mapper;

import com.example.adminservice.queGen.model.QueListVO;
import com.example.adminservice.queGen.model.QueVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QueGenMapper {
    List<QueVO> queGenList();
    List<QueListVO> queGenDetail(@Param("qid") String qid); // 상세내역
    List<QueVO> selectQueType();  //문제분류에 따른 인증분야 조회
    List<QueVO> selectQueTypeByAuth();  //문제분류에 따른 인증분야 조회
    List<QueVO> maxQid();  //qid 값 가져오기

    void getqueWrite(QueListVO quelistVO); //데이터 삽입
    void getqueWrite1(QueListVO quelistVO); //데이터 삽입
    void getqueWrite2(QueListVO quelistVO); //데이터 삽입
    void getqueWrite3(QueListVO quelistVO); //데이터 삽입
    void getqueWrite4(QueListVO quelistVO); //데이터 삽입

    List<QueVO> queGenListSearch(String auth, String authDetail, String staymd, String endymd, String searchItem, String searchInput);

    void queGenDelete(String qidPop); //문제삭제
    void queGenItemDelete(String qidPop); //문제보기삭제
    List<QueListVO> queGenModifyDetail(String qid); //문제수정조회
    void queGenModifyUpdateQue(QueListVO queListVO); //문제수정
    void queGenModifyUpdateQueItem1(QueListVO queListVO); //문제보기수정
    void queGenModifyUpdateQueItem2(QueListVO queListVO);
    void queGenModifyUpdateQueItem3(QueListVO queListVO);
    void queGenModifyUpdateQueItem4(QueListVO queListVO);
}
