package com.example.study.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Header부분에, data부분을 어떠한 generic으로 생성할 지 언급!
public class Header<T> {

    //api 통신 시간
    private LocalDateTime transactionTime; //ISO, YYYY-MM-DD, 등의 매핑 방법이 있지만, ISO로 할 것.


    //api 응답 코드
    private String resultCode;

    //api 부가 설명
    private String description;

    //해당 generic으로 data부분 생성
    private T data;

    //OK
    public static <T> Header<T> OK(){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    //data OK
    public static <T> Header<T> OK(T data){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    //ERROR
    public static <T> Header<T> ERROR(String description){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }
}

