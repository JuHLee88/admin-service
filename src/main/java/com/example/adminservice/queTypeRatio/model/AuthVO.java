package com.example.adminservice.queTypeRatio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AuthVO {
    private String authcd;
    private String nm;
    private String use_yn;
    private int ord;
}
