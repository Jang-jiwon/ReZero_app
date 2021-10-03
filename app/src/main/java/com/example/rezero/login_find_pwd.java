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

//외부에서 new login_find_pwd 프래그먼트 호출시
public class login_find_pwd extends Fragment {

    //XML에서 가져올 변수들
    private EditText name_text;
    private EditText birth_text;
    private EditText email_text;
    private EditText phone_text;
    private EditText check_text;
    private View phone_send;
    private View phone_check;
    private View login_pwd_find;
    private Boolean check = false;
    private InputMethodManager imm;
    private LinearLayout login_find_pwd_layout;

    //PHP에서 가져온 변수
    private String username_php = "";
    private String user_birth_php = "";
    private String user_email_php = "";
    private String user_phone_num_php = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        /* login_find_pwd.xml을 객체화 시켜 화면에 표시. 기초 작업 */
        View v = inflater.inflate(R.layout.login_find_pwd, container, false);
        name_text = (EditText)v.findViewById(R.id.login_find_pwd_edit_name);
        birth_text = (EditText)v.findViewById(R.id.login_find_pwd_edit_birth);
        email_text = (EditText) v.findViewById(R.id.login_find_pwd_edit_email);
        phone_text = (EditText) v.findViewById(R.id.login_find_pwd_edit_phone);
        check_text = (EditText) v.findViewById(R.id.login_find_pwd_edit_checkNum);
        phone_send = (View) v.findViewById(R.id.login_find_pwd_view_phone);
        phone_check = (View) v.findViewById(R.id.login_find_pwd_view_checkNum);
        login_pwd_find = (View) v.findViewById(R.id.login_find_pwd_view);

        //(0) Edittext 배경 클릭 시 키보드 내림
        login_find_pwd_layout = (LinearLayout) v.findViewById(R.id.login_find_pwd_layout_all);
        imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        login_find_pwd_layout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imm.hideSoftInputFromWindow(name_text.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(birth_text.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(email_text.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(phone_text.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(check_text.getWindowToken(), 0);

            }
        });

        /* 1. 인증받기 버튼 눌렀을 때*/
        phone_send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               //1. DB에서  이름, 생년월일, 이메일, 핸드폰 번호 조회

                // (1-1) 값 가져옴
                String username = name_text.getText().toString();
                String user_birth = birth_text.getText().toString();
                String user_email = email_text.getText().toString();
                String user_phone_num = phone_text.getText().toString();

                Log.i("입력된 username은 ",username);
                Log.i("입력된 user_birth는 ",user_birth);
                Log.i("입력된 user_email은 ",user_email);
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
                                String user_email = jsonObject.getString("user_email");
                                String user_phone_num = jsonObject.getString("user_phone_num");

                                Log.i("가져온 username은 ",username);
                                Log.i("가져온 user_birth는 ",user_birth);
                                Log.i("가져온 user_email은 ",user_email);
                                Log.i("가져온 user_phone_num은 ",user_phone_num);

                                username_php = username;
                                user_birth_php = user_birth;
                                user_email_php = user_email;
                                user_phone_num_php = user_phone_num;


                                Log.i("넣은 username은 ",username_php);
                                Log.i("넣은 user_birth는 ",user_birth_php);
                                Log.i("넣은 user_email은 ",user_email_php);
                                Log.i("넣은 user_phone_num은 ",user_phone_num_php);


                                /* 2. 조회 성공했으면 문자 보내는 서비스 구현*/
                                //2-(1) 타임초 3분 세고
                                //2-(2) 문자 보내고
                                //2-(3) 기다림



                                Log.i("성공 ",": O");
                                check_text.setHint("인증 서비스 구현 중...\n(바로 인증하기와 찾기 버튼 클릭!)"); //문자 인증 구현하면 없애기

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
                login_find_pwd_request login_pwd_request = new login_find_pwd_request(username, user_birth, user_email, user_phone_num, responseListener);
                //login_1_화면에서 큐 생성
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                //큐에 login_check_request 클래스 담음 (실제 값 전송-성공여부담아옴)
                queue.add(login_pwd_request);
            }

        });
        
        /* 3. 인증하기 버튼 눌렀을 때*/
        phone_check.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //3-(1) 인증번호 같은지 확인
                //if(인증번호 같으면)
                //Log.i("인증받기 전 check 값: ",check+"");
                check = true;
                //Log.i("인증받은 뒤 check 값: ",check+"");

            }
        });


        /* 3. 비밀번호 찾기 버튼 눌렀을 때 */
        login_pwd_find.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //3-(1)체크 했으면 비밀번호 재설정 페이지로 이동
                if (check == true)
                {
                    check = false;
                    //Log.i("재설정 페이지 들어오고 check 값 : ", check+"");
                    Intent intent = new Intent(getActivity(), login_pwd_new_activity.class);
                    //화면 넘어갈 때 이메일 알려주기 위해 값 넘김
                    intent.putExtra("username_findpwd",username_php);
                    intent.putExtra("userbirth_findpwd",user_birth_php);
                    intent.putExtra("user_email_findpwd",user_email_php);
                    intent.putExtra("user_phone_num_findpwd",user_phone_num_php);
                    startActivity(intent);

                }
                else
                {
                    Log.i("인증 제대로 안했음","!");
                    //인증번호를 다시 확인해주세요 문구 표시하기 (CustomDialog 클래스 불러와서)
                    CustomDialog dlg = new CustomDialog(getActivity());
                    dlg.show();
                }
            }
        });





       return v;
    }
}
