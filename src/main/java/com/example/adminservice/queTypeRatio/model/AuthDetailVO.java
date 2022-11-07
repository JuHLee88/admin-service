package com.example.adminservice.queTypeRatio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDetailVO {
    private String AUTHCD;
    private String AUTHNM;
    private String QTYPECD;
    private String QTYPENM;
    private int RATION;
    private int IDX;
}
