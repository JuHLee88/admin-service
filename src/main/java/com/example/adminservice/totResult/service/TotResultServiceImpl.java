package com.example.adminservice.totResult.service;

import com.example.adminservice.totResult.mapper.TotResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class TotResultServiceImpl implements TotResultService {

    @Autowired
    private TotResultMapper totResultMapper;

    @Override
    public ArrayList<HashMap<String, String>> totResultSelectBox(String param_auth) {
        return totResultMapper.totResultSelectBox(param_auth);
    }

    @Override
    public ArrayList<HashMap<String, String>> searchTotResult(String auth, String staymd, String endymd, String gubun) {
        return totResultMapper.searchTotResult(auth, staymd, endymd, gubun);
    }
}
