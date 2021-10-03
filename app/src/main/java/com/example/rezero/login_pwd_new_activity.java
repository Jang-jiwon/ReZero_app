package com.example.rezero;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class login_pwd_new_activity extends AppCompatActivity {

    private String username;
    private String user_pwd;
    private String user_pwd_php;
    private String user_birth;
    private String user_email;
    private String user_phone_num;
    private EditText login_pwd_new_edittext1;
    private EditText login_pwd_new_edittext2;
    private String login_pwd_text1;
    private String login_pwd_text2;
    private View login_change_view;
    private TextView login_text_error1;
    private TextView login_text_error2;

    private LinearLayout login_pwd_layout;
    private TextView login_pwd_pwd_textview;
    private InputMethodManager imm;
    private ImageView back;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        /* 1. PutExtra 값 가져오기 */
        //: login_find_pwd.java에서 입력했던 (putExtra한) name, birth, phone num 값 (아이디 찾기에서 DB 조회한 결과) 넘겨 받아오기!!

        Intent intent = new Intent(this.getIntent());
        username  = intent.getStringExtra("username_findpwd");
        user_birth = intent.getStringExtra("userbirth_findpwd");
        user_email = intent.getStringExtra("user_email_findpwd");
        user_phone_num = intent.getStringExtra("user_phone_num_findpwd");


        /* 2. 레이아웃에서 띄울 XML 화면 표시 */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_pwd_new_1);


        /* 3. XML에 있는 필요한 값 가져오기 */
        login_pwd_new_edittext1 = (EditText) findViewById(R.id.login_pwd_new_edittext1);
        login_pwd_new_edittext2 = (EditText) findViewById(R.id.login_pwd_new_edittext2);
        login_text_error1 = (TextView) findViewById(R.id.login_find_pwd_textview_error1);
        login_text_error2 = (TextView) findViewById(R.id.login_find_pwd_textview_error2);


        //3-(1) 키보드 배경 터치하면 내려가게 만들기
        login_pwd_layout = (LinearLayout) findViewById(R.id.login_pwd_layout);
        login_pwd_pwd_textview = (TextView) findViewById(R.id.login_pwd_pwd_textview);
        imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        login_pwd_layout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imm.hideSoftInputFromWindow(login_pwd_new_edittext1.getWindowToken(), 0); //edittext1 실제로
                imm.hideSoftInputFromWindow(login_pwd_new_edittext2.getWindowToken(), 0); //edittext2 내려가게 만들기
            }
        });

        login_pwd_pwd_textview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imm.hideSoftInputFromWindow(login_pwd_new_edittext1.getWindowToken(), 0); //edittext1 실제로
                imm.hideSoftInputFromWindow(login_pwd_new_edittext2.getWindowToken(), 0); //edittext2 내려가게 만들기
            }
        });


        //3-(2) 뒤로가기 구현
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });


        /* 4. 변경 뷰 누르면 비밀번호 입력 값 오류 없는 지 확인 */
        login_change_view = (View) findViewById(R.id.login_pwd_new_view_change);

        login_change_view.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                //3-(0) 들어온게 제대로 된 값이긴 함?
                login_pwd_text1 = login_pwd_new_edittext1.getText().toString();
                login_pwd_text2 = login_pwd_new_edittext2.getText().toString();
                Log.i("첫번째 비밀번호 : ", login_pwd_text1);
                Log.i("두번째 비밀번호 : ", login_pwd_text2);

                //3-(1) 비밀번호 8글자 이상인지 확인
                if (login_pwd_text1.length() > 7) {

                    Log.i("비밀번호 통과", "8글자 이상임");
                    login_pwd_new_edittext1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_find_gray_few_alpha))));
                    login_text_error1.setText("");
                    login_pwd_new_edittext2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_find_gray_few_alpha))));
                    login_text_error2.setText("");
                    //3-(2) 영문, 숫자, 특수문자 있는지 확인
                    //1. 숫자 있는지
                    if (login_pwd_text1.matches(".*[0-9].*")) {
                        //숫자 있음
                        Log.i("비밀번호 통과", "숫자 있음");
                        login_pwd_new_edittext1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_find_gray_few_alpha))));
                        login_text_error1.setText("");
                        login_pwd_new_edittext2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_find_gray_few_alpha))));
                        login_text_error2.setText("");
                        //2. 문자 있는지
                        if (login_pwd_text1.matches(".*[a-zA-Z].*")) {
                            //문자 있음
                            Log.i("비밀번호 통과", "문자 있음");
                            login_pwd_new_edittext1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_find_gray_few_alpha))));
                            login_text_error1.setText("");
                            login_pwd_new_edittext2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_find_gray_few_alpha))));
                            login_text_error2.setText("");

                            //3. 특수 기호 있는지
                            if (login_pwd_text1.matches(".*[!@#$%^&+=].*")) {
                                // 특수 기호 있음
                                Log.i("비밀번호 통과", "특수 기호 있음");
                                login_pwd_new_edittext1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_find_gray_few_alpha))));
                                login_text_error1.setText("");
                                login_pwd_new_edittext2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_find_gray_few_alpha))));
                                login_text_error2.setText("");

                                //3-(3) 비밀번호 입력한 거랑 재확인이 같은지 확인
                                if (login_pwd_text1.equals(login_pwd_text2)) {

                                    //3-(4) 같으면 비밀번호 값 업데이트 구현하기
                                    Log.i("비밀번호 통과", "두 비밀번호 같음");
                                    login_pwd_new_edittext1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_find_gray_few_alpha))));
                                    login_text_error1.setText("");
                                    login_pwd_new_edittext2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_find_gray_few_alpha))));
                                    login_text_error2.setText("");



                                    /* 4. 비밀번호 업데이트 하기 */
                                    user_pwd = login_pwd_text1;
                                    //1. XML에서  비밀번호, 이름, 생년월일, 이메일, 핸드폰 번호 조회
                                    Log.i("입력된 user_pwd는 ", user_pwd);
                                    Log.i("입력된 username은 ", username);
                                    Log.i("입력된 user_birth는 ", user_birth);
                                    Log.i("입력된 user_email은 ", user_email);
                                    Log.i("입력된 user_phone_num은 ", user_phone_num);


                                    //(1-2) 요청 responseListenr 정의 (Volley 사용)
                                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            try {
                                                Log.i("response", "응답 왔음?");
                                                Log.i(">>>>>", response.toString());
                                                //JSON 형태로 담아준다음에 서버로 전송 위해 패키징 (문자열로 전송할 수 없어서 사용)
                                                JSONObject jsonObject = new JSONObject(response);

                                                //성공 여부 가져오기
                                                boolean success = jsonObject.getBoolean("success"); //php에 있는 success 키 값을 가져와서 True / False 담
                                                Log.i("성공?", success + "");

                                                //성공했으면
                                                if (success) {
                                                    //php에 있는 쿼리 결과 바인딩 변수 user_email랑 user_pwd 키의 값을 가져와서 해당 변수에 담음!
                                                    String username = jsonObject.getString("username");
                                                    String user_pwd = jsonObject.getString("user_pwd");
                                                    String user_birth = jsonObject.getString("user_birth");
                                                    String user_email = jsonObject.getString("user_email");
                                                    String user_phone_num = jsonObject.getString("user_phone_num");

                                                    Log.i("업데이트된 username은 ", username);
                                                    Log.i("업데이트된 user_pwd는 ", user_pwd);
                                                    Log.i("업데이트된 user_birth는 ", user_birth);
                                                    Log.i("업데이트된 user_email은 ", user_email);
                                                    Log.i("업데이트된 user_phone_num은 ", user_phone_num);

                                                    user_pwd_php = user_pwd;
                                                    Log.i("다음 화면에 넣을 user_pwd는 ", user_pwd_php);

                                                    Log.i("성공 ", ": O");
                                                    //성공 화면으로 넘기기
                                                    Intent intent = new Intent(getApplicationContext(), login_pwd_new2_activity.class);
                                                    //화면 넘어갈 때 이메일 알려주기 위해 값 넘김
                                                    intent.putExtra("user_pwd_findpwd", user_pwd_php);
                                                    startActivity(intent);

                                                    return;
                                                } else //실패했으면
                                                {
                                                    // (2) 틀렸으면 경고창 문구 띄우고 다시
                                                    //틀림 알람 문구 띄우기
                                                    Log.i("실패 띄우기", "");
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    };

                                    // (3) 서버로 Volley를 이용해서 요청함

                                    //login_1_request 클래스 (URL/PHP/전송방식 설정) 형식의 login_check_request 클래스 생성 > edittext에서 가져온 값 실제 전송
                                    login_pwd_new_request login_pwd_request = new login_pwd_new_request(user_pwd, username, user_birth, user_email, user_phone_num, responseListener);
                                    //login_1_화면에서 큐 생성
                                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                                    //큐에 login_check_request 클래스 담음 (실제 값 전송-성공여부담아옴)
                                    queue.add(login_pwd_request);


                                } else {
                                    //3-(3)-(1) 입력하신 비밀번호와 일치하지 않습니다. 문구 출력
                                    Log.i("비밀번호 오류", "두 비밀번호 다름");
                                    login_pwd_new_edittext1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_find_gray_few_alpha))));
                                    login_text_error1.setText("");
                                    login_pwd_new_edittext2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_pwd_red))));
                                    login_text_error2.setText("입력하신 비밀번호와 일치하지 않습니다");
                                }

                            } else {
                                //특수 기호 없음
                                Log.i("비밀번호 오류", "특수 기호 없음");
                                login_pwd_new_edittext1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_pwd_red))));
                                login_text_error1.setText("영문, 숫자, 특수문자를 모두 포함해주세요");
                                login_pwd_new_edittext2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_pwd_red))));
                                login_text_error2.setText("영문, 숫자, 특수문자를 모두 포함해주세요");
                            }
                        } else {
                            //문자 없음
                            Log.i("비밀번호 오류", "문자 없음");
                            login_pwd_new_edittext1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_pwd_red))));
                            login_text_error1.setText("영문, 숫자, 특수문자를 모두 포함해주세요");
                            login_pwd_new_edittext2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_pwd_red))));
                            login_text_error2.setText("영문, 숫자, 특수문자를 모두 포함해주세요");
                        }

                    } else {
                        //숫자 없음
                        Log.i("비밀번호 오류", "숫자 없음");
                        login_pwd_new_edittext1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_pwd_red))));
                        login_text_error1.setText("영문, 숫자, 특수문자를 모두 포함해주세요");
                        login_pwd_new_edittext2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_pwd_red))));
                        login_text_error2.setText("영문, 숫자, 특수문자를 모두 포함해주세요");

                    }
                } else {
                    //3-(1)-(1) 비밀번호는 8자 이상입니다. 문구 출력
                    Log.i("비밀번호 오류", "8글자 미만임");
                    login_pwd_new_edittext1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_pwd_red))));
                    login_text_error1.setText("비밀번호는 8자 이상입니다");
                    login_pwd_new_edittext2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor((R.color.login_pwd_red))));
                    login_text_error2.setText("비밀번호는 8자 이상입니다");
                }

            }
        });

    }
}
