package com.example.study.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data //Get,Set 메서드, 생성자 만들어줌.
@AllArgsConstructor //모든 argument를 가지는 생성자 추가.
public class SearchParam {
    private String account;
    private String email;
    private int page;

    //{"account" : "", "email": "", "page":0} 스프링부트에서 jackson이라는 라이브러리를 갖고 json형태로 바꿍줄 것.

    //해당 파라미터를 입력받기 위해서는 get, set, 생성자 가 있어야 함.
    //Code -> Generate -> Getter and Setter -> 전체 선택 하면 자동으로 생성 가능

    /* 하지만 Lombok을 사용하면 이렇게 get,set메서드 길게 안써도 됨.
    public String getAccount() {    return account;}

    public void setAccount(String account) {this.account = account;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public int getPage() {return page;}

    public void setPage(int page) {this.page = page; }
     */
}
