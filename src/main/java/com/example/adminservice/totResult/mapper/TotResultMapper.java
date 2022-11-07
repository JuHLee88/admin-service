package com.example.adminservice.totResult.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface TotResultMapper {
    ArrayList<HashMap<String, String>> totResultSelectBox(String param_auth);
    ArrayList<HashMap<String, String>> searchTotResult(String auth, String staymd, String endymd, String gubun);
}

