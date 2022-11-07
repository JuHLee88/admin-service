package com.example.adminservice.queGen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueVO { //board db row 전체
    private int rnum;
    private String qid;
    private String qtypenm;
    private String question;
    private String url;
    private String writernm;
    private String createdt;
    private String admnumr;
    private String useyn;

    private String cd;
    private String nm;
}
