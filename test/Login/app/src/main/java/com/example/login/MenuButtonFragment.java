package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuButtonFragment extends Fragment {
    /*
        Fragment
            액티비티에 띄우기 위한 서브화면
            서브 화면이기 때문에 반드시 액티비티에 의해 호출이 되어야함
            액티비티의 어디에 출력이 될건지 → container

            프레임 레이아웃과의 차이점
                프레임 레이아웃: 가시성 속성으로 다뤄짐
                                내가 출력할 레이아웃이 한꺼번에 만들어져있음
                                자원을 많이 차지함
                                액티비티마다 구현을 동일하게 해줘야 함(중복 작성)

                Fragment: 사용할 때만 호출하기 때문에 사용할 자원만 사용
                          java + xml 파일로 구성되어 있어서 구현을 한번만 해주면 다른 액티비티에서도 동일 실행(중복 작성x)
                          부분 화면의 구현을 java 파일로 따로 작성이 되기 때문에 중복으로 작성하지 않아 관리 용이

            Fragment 추가 방법
                -xml 상에서 fragment 태그로 추가
                -java 코드상에서 FragmentManager 클래스로 추가
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
            Inflate the layout for this fragment
            인플레이션을 함
            뷰들을 객체화해서 초기화
        */
        View root = inflater.inflate(R.layout.menu_button, container, false);

        Button toMainButton = root.findViewById(R.id.button_toMain);
        Button toMenuButton = root.findViewById(R.id.button_toMenu);

        toMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });

        toMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MenuActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}