package com.example.rezero;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

//외부에서 new login_find_id 프래그먼트 호출시
public class login_find_id extends Fragment {

    private EditText name_text;
    private EditText birth_text;
    private EditText phone_text;
    private View find_id_view;
    private LinearLayout login_find_id_layout;
    private InputMethodManager imm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.login_find_id, container, false);

        name_text = (EditText)v.findViewById(R.id.login_find_id_edit_name); //이름
        birth_text = (EditText)v.findViewById(R.id.login_find_id_edit_birth); //생년월일
        phone_text = (EditText) v.findViewById(R.id.login_find_id_edit_phone); //핸드폰 번호
        find_id_view = (View) v.findViewById(R.id.login_find_id_view); //아이디 찾기 버튼

        //(0) Edittext 배경 클릭 시 키보드 내림
        login_find_id_layout = (LinearLayout) v.findViewById(R.id.login_find_id_layout_all);
        imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        login_find_id_layout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imm.hideSoftInputFromWindow(name_text.getWindowToken(), 0); //edittext1 실제로
                imm.hideSoftInputFromWindow(birth_text.getWindowToken(), 0); //edittext2 내려가게 만들기
                imm.hideSoftInputFromWindow(phone_text.getWindowToken(), 0); //edittext2 내려가게 만들기

            }
        });


        find_id_view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // (1) 로그인 뷰 클릭시 화면 성공했는지 확인

                // (1-1) 값 가져옴
                String username = name_text.getText().toString();
                String user_birth = birth_text.getText().toString();
                String user_phone_num = phone_text.getText().toString();
                Log.i("입력된 username은 ",username);
                Log.i("입력된 user_birth는 ",user_birth);
                Log.i("입력된 user_phone_num은 ",user_phone_num);

                //(1-2) 요청 responseListenr 정의 (Volley 사용)
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.i("response","응답 왔음?");
                            Log.i(">>>>>",response.toString());
                            //JSON 형태로 담아준다음에 서버로 전송 위해 패키징 (문자열로 전송할 수 없어서 사용)
                            JSONObject jsonObject = new JSONObject(response);

                            //성공 여부 가져오기
                            boolean success = jsonObject.getBoolean("success"); //php에 있는 success 키 값을 가져와서 True / False 담
                            Log.i("성공?", success+"" );

                            //성공했으면
                            if (success)
                            {
                                //php에 있는 쿼리 결과 바인딩 변수 user_email랑 user_pwd 키의 값을 가져와서 해당 변수에 담음!
                                String username = jsonObject.getString("username");
                                String user_birth = jsonObject.getString("user_birth");
                                String user_phone_num = jsonObject.getString("user_phone_num");
                                String user_email = jsonObject.getString("user_email");

                                Log.i("가져온 username은 ",username);
                                Log.i("가져온 user_birth는 ",user_birth);
                                Log.i("가져온 user_phone_num은 ",user_phone_num);


                                //짧게 알람 문구 보여주기 - 확인용
                                Log.i("가져온 user_email은 ",user_email);

                                //성공 화면으로 넘기기
                                Intent intent = new Intent(getActivity(), login_id_success.class);

                                //화면 넘어갈 때 이메일 알려주기 위해 값 넘김
                                intent.putExtra("user_email",user_email);
                                startActivity(intent);
                                return;
                            }
                            else //실패했으면
                            {
                                // (2) 틀렸으면 경고창 문구 띄우고 다시
                                //틀림 알람 문구 띄우기
                                Log.i("실패 띄우기","");

                                //실패 화면으로 넘기기
                                Intent intent = new Intent(getActivity(), login_id_fail.class);
                                startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // (3) 서버로 Volley를 이용해서 요청함

                //login_1_request 클래스 (URL/PHP/전송방식 설정) 형식의 login_check_request 클래스 생성 > edittext에서 가져온 값 실제 전송
                login_find_request login_find_request = new login_find_request(username, user_birth, user_phone_num, responseListener);
                Log.i("오잉1","뭐가 되고 있는거긴함?");
                //login_1_화면에서 큐 생성
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                //큐에 login_check_request 클래스 담음 (실제 값 전송-성공여부담아옴)
                queue.add(login_find_request);
                Log.i("오잉2","발리 큐에 들어갔냐?");
            }
        });

        return v;
    }
}
