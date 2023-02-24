package com.example.app0209;

import android.widget.TextView;

public class DirectVO {
    // VO(DTO) 구성요소

    // alt +insert 단축키


    // 1. 필드 - 저장하고 싶은 변수들
    private String tv_address, tv_title;

    // 2. 생성자 메소드 - 필드 초기화 용도
    public DirectVO(String tv_title, String tv_address){
        this.tv_address = tv_address;
        this.tv_title = tv_title;
    }
    // 3. get(확인용), set(수정용)
    public String getTv_title() {
        return tv_title;
    }
    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public String getTv_address() {
        return tv_address;
    }
    public void setTv_address(String tv_title) {
        this.tv_address = tv_address;
    }

    // 4. toString() - 객체에 저장된 모든 필드들을 문자열로 리턴~


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DirectVO{");
        sb.append("tv_address='").append(tv_address).append('\'');
        sb.append(", tv_title='").append(tv_title).append('\'');
        sb.append('}');
        return sb.toString();
        // 결론! String 을 + 연산 할 때는 (+) 보다 Buffer 쓰는게
        // 메모리 소모도 적고 더 빠르다!
    }
}
