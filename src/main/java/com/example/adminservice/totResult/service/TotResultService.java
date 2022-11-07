package com.example.adminservice.totResult.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface TotResultService {
    ArrayList<HashMap<String, String>> totResultSelectBox(String param_auth);
    ArrayList<HashMap<String, String>> searchTotResult(String auth, String staymd, String endymd, String gubun);
}
