package com.example.adminservice.queGen.service;

import com.example.adminservice.queGen.mapper.QueGenMapper;
import com.example.adminservice.queGen.model.QueListVO;
import com.example.adminservice.queGen.model.QueVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueGenServiceImpl implements QueGenService {
    private QueGenMapper queGenMapper;

    @Autowired
    public QueGenServiceImpl(QueGenMapper queGenMapper) {
        this.queGenMapper = queGenMapper;
    }

    @Override
    public List<QueVO> queGenList() { return queGenMapper.queGenList(); } // 첫화면

    @Override
    public List<QueListVO> queGenDetail(String qid) {
        return queGenMapper.queGenDetail(qid);
    }  // 상세내역

    @Override
    public List<QueVO> selectQueType() {
        return queGenMapper.selectQueType();
    }

    @Override
    public List<QueVO> selectQueTypeByAuth() {
        return queGenMapper.selectQueTypeByAuth();
    }

    @Override
    public List<QueVO> maxQid() { return queGenMapper.maxQid(); }

    @Override
    public void queWrite(QueListVO quelistVO) { queGenMapper.getqueWrite(quelistVO); }

    @Override
    public void queWrite1(QueListVO quelistVO) { queGenMapper.getqueWrite1(quelistVO); }

    @Override
    public void queWrite2(QueListVO quelistVO) { queGenMapper.getqueWrite2(quelistVO); }

    @Override
    public void queWrite3(QueListVO quelistVO) { queGenMapper.getqueWrite3(quelistVO); }

    @Override
    public void queWrite4(QueListVO quelistVO) { queGenMapper.getqueWrite4(quelistVO); }

    @Override
    public List<QueVO> queGenListSearch(String auth, String authDetail, String staymd, String endymd, String searchItem, String searchInput) {
        return queGenMapper.queGenListSearch(auth, authDetail, staymd, endymd, searchItem, searchInput);
    }

    @Override
    public void queGenDelete(String qidPop) {
        queGenMapper.queGenDelete(qidPop);
        queGenMapper.queGenItemDelete(qidPop);
    }

    @Override
    public List<QueListVO> queGenModifyDetail(String qid) {
            return queGenMapper.queGenModifyDetail(qid);
    }

    @Override
    public void queGenModifyUpdateQue(QueListVO queListVO) {
        queGenMapper.queGenModifyUpdateQue(queListVO);
    }

    @Override
    public void queGenModifyUpdateQueItem(QueListVO queListVO) {
        queGenMapper.queGenModifyUpdateQueItem1(queListVO);
        queGenMapper.queGenModifyUpdateQueItem2(queListVO);
        queGenMapper.queGenModifyUpdateQueItem3(queListVO);
        queGenMapper.queGenModifyUpdateQueItem4(queListVO);
    }

}