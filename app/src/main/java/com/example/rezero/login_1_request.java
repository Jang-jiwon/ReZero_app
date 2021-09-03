package com.example.rezero;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class login_1_request extends StringRequest {


    //1. 서버 URL & PHP 파일 연결

    //서버 주소로 나중에 바꾸기
    final static private String URL = "http://delightes.dothome.co.kr/login_check.php"; //URL은 바뀔 일 없으니까 고정 상수!
    private Map<String, String> map;


    //2. 생성자 (방식, URL, 성공했을 때 작업, 실패했을 때 작업) -> String Request
    public login_1_request(String user_email, String user_pwd, Response.Listener<String> listener) //리스너도 매개변수로
    {
        //1) POST 방식으로 URL에 해당 정보를 전송함 - GET(URL에 보임) vs POST(URL에 안보임)
        super(Method.POST, URL, listener,  new Response.ErrorListener(){//에러발생시 호출될 리스너 객체
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       Log.i("에러 => ", error.getMessage());
                    }});

        //2) (키 값, 실제 넣을 문자열 값)으로 전송
        map = new HashMap<>();
        map.put("user_email",user_email);
        map.put("user_pwd",user_pwd);

        Log.i("map 함수로 만들어진 전송 값들", map+"");
    }

    //getParams()함수에서 반환한 Map 객체의 데이터를 웹의 질의 문자열로 만들어 Request Queue에서 서버 요청 시 서버에 전송
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Log.i("getParmas에서 웹 질의 문자열 : ", map+"");
        return map;
    }
}
