package com.example.adminservice.authManage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO{
    int userNo;
    String userId;
    String userPw;
    String userName;
    String userAuth;
    String appendDate;
    String updateDate;
    String boardAuth;
    String queAuth;
    String queTypeAuth;

}
