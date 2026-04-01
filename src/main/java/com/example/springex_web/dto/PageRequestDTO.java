package com.example.springex_web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    @Builder.Default   //기본값 세팅
    @Min(value = 1)
    @Positive  // 무조건 양수값을 가져야함 ,음수 x
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private  int size = 10;

    private String link;
    private String[] types;
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;

    public int getSkip(){
        return (page -1) * 10;
    }

    public String getLink(){
        if(link == null){
            StringBuilder builder = new StringBuilder();

            builder.append("page=" + this.page); // 현재 페이지 번호
            builder.append("&size=" + this.size); // 페이지당 데이터 개수

            if(finished) {
                builder.append("&finished=on"); // 완료 여부 true면 on
            }

            if(types != null && types.length > 0){
                for (int i = 0; i < types.length ; i++) {
                    builder.append("&types=" + types[i]); // 검색 타입들 (여러 개 가능)
                }
            }

            if(keyword != null){ //Null이 아닐 때
                try {
                    builder.append("&keyword=" + URLEncoder.encode(keyword,"UTF-8")); // 검색 키워드 (인코딩 처리)
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace(); // 인코딩 예외 출력
                }
            }

            if(from != null){
                builder.append("&from=" + from.toString()); // 시작 날짜
            }

            if(to != null){
                builder.append("&to=" + to.toString()); // 종료 날짜
            }

            link = builder.toString(); // 최종 URL 파라미터 생성
        }
        return link;
    }

    public boolean checkType(String type){
        if(types == null || types.length == 0){
            return false;
        }
        return Arrays.stream(types).allMatch(type::equals); //타입 equals와 일치하는게 하나라도 있으면 true를 반환
    }
}