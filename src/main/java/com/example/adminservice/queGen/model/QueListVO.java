package com.example.adminservice.queGen.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueListVO { //게시판 첫 화면 데이터 형식
    private String qid;
    private String admnum;
    private String authcd;
    private String authnm;
    private String qtypecd;
    private String qtypenm;
    private String question;
    private String anstype;
    private String anstypenm;
    private String lvl;
    private String lvlnm;
    private String useyn;
    private String useynnm;
    private String source;
    private String url;
    private String writer;
    private String writernm;
    private String requser;
    private String requsernm;
    private String modifyuser;
    private String createdt;
    private String itemid1;
    private String item1;
    private String itemid2;
    private String item2;
    private String itemid3;
    private String item3;
    private String itemid4;
    private String item4;
    private String answer;
    private String anscd;
    private String anscd1;
    private String anscd2;
    private String anscd3;
    private String anscd4;
    private String explanation;
}
