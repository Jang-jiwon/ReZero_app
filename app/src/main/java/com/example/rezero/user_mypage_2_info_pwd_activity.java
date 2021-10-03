package com.example.rezero;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class user_mypage_2_info_pwd_activity extends AppCompatActivity {

    private ImageView back;

    //로그인 변수
    String login;
    String login_user_email;
    String login_user_pwd;
    String login_user_name;
    String login_user_order;
    String login_user_point;
    String login_user_coupon;
    String login_user_birth;
    String login_user_phone_num;
    String login_user_bank;
    String login_user_account;
    String login_user_address;
    String login_user_like_pro;
    String login_user_mission;
    String login_user_like_designer;
    String login_user_cart;
    String login_user_chat;
    String login_user_review;

    //이 화면에서 사용할 변수
    LinearLayout user_mypage_2_info_pwd_layout_all;
    EditText user_mypage_2_edittext_now;
    EditText user_mypage_2_edittext_new_1;
    EditText user_mypage_2_edittext_new_2;
    private InputMethodManager imm;
    View login_pwd_new_view_change;
    TextView user_mypage_2_textview_error1;
    TextView user_mypage_2_textview_error2;
    TextView user_mypage_2_textview_error3;
    Boolean now = false;
    Boolean new_1 = false;
    Boolean new_2 = false;





    public void onCreate(Bundle savedInstance)
    {
        //0. 로그인했을 때 조회한 db 값 가져오기
        Intent intent = new Intent(this.getIntent());

        login = intent.getStringExtra("login");
        Log.i("로그인함?",login+" ");

        login_user_email  = intent.getStringExtra("login_user_email");
        login_user_pwd  = intent.getStringExtra("login_user_pwd");
        Log.i("가져온 로그인 값?", login+"했으면? "+login_user_email+" "+login_user_pwd);

        login_user_name = intent.getStringExtra("login_user_name");
        login_user_order = intent.getStringExtra("login_user_order");
        login_user_point = intent.getStringExtra("login_user_point");
        login_user_coupon = intent.getStringExtra("login_user_coupon");
        login_user_birth = intent.getStringExtra("login_user_birth");
        login_user_phone_num = intent.getStringExtra("login_user_phone_num");
        login_user_bank = intent.getStringExtra("login_user_bank");
        login_user_account = intent.getStringExtra("login_user_account");
        login_user_address = intent.getStringExtra("login_user_address");
        login_user_like_pro = intent.getStringExtra("login_user_like_pro");
        login_user_mission = intent.getStringExtra("login_user_mission");
        login_user_like_designer = intent.getStringExtra("login_user_like_designer");
        login_user_cart = intent.getStringExtra("login_user_cart");
        login_user_chat = intent.getStringExtra("login_user_chat");
        login_user_review = intent.getStringExtra("login_user_review");

        //1. 화면 띄우기
        super.onCreate(savedInstance);
        setContentView(R.layout.user_mypage_2_info_pwd);

        //2. 뒤로가기 버튼
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        //3. 자바 - XML
        user_mypage_2_info_pwd_layout_all = (LinearLayout) findViewById(R.id.user_mypage_2_info_pwd_layout_all);
        user_mypage_2_edittext_now = (EditText) findViewById(R.id.user_mypage_2_edittext_now);
        user_mypage_2_edittext_new_1 = (EditText) findViewById(R.id.user_mypage_2_edittext_new_1);
        user_mypage_2_edittext_new_2 = (EditText) findViewById(R.id.user_mypage_2_edittext_new_2);
        login_pwd_new_view_change = (View) findViewById(R.id.login_pwd_new_view_change);
        user_mypage_2_textview_error1 = (TextView) findViewById(R.id.user_mypage_2_textview_error1);
        user_mypage_2_textview_error2 = (TextView) findViewById(R.id.user_mypage_2_textview_error2);
        user_mypage_2_textview_error3 = (TextView) findViewById(R.id.user_mypage_2_textview_error3);


        //4. 다른 곳 누르면 키보드 내려가게
        user_mypage_2_info_pwd_layout_all = (LinearLayout) findViewById(R.id.user_mypage_2_info_pwd_layout_all);
        imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);

        user_mypage_2_info_pwd_layout_all.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imm.hideSoftInputFromWindow(user_mypage_2_edittext_now.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(user_mypage_2_edittext_new_1.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(user_mypage_2_edittext_new_2.getWindowToken(), 0);

            }
        });

        //5. 현재 비밀번호
        user_mypage_2_edittext_now.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //입력하기 전 호출되는 API
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //EditText에 변화가 있을 때
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //입력이 끝났을 때
                String pwd = user_mypage_2_edittext_now.getText().toString();

                if(pwd.equals(login_user_pwd)) //현재 비밀번호가 같으면
                {
                    Log.i("현재 비밀번호 통과", "O");
                    now = true;
                    user_mypage_2_textview_error1.setText("");

                    if(now && new_1 && new_2)
                    {
                        login_pwd_new_view_change.setEnabled(true);
                        login_pwd_new_view_change.setAlpha(1.0F);
                    }
                }
                else
                {
                    Log.i("현재 비밀번호 오류", "X");
                    now = false;
                    user_mypage_2_textview_error1.setText("기존 비밀번호와 일치하지 않습니다");
                    user_mypage_2_textview_error1.setTextColor(getResources().getColor(R.color.login_pwd_red));
                    user_mypage_2_textview_error1.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(user_mypage_2_info_pwd_activity.this, R.color.login_pwd_red)));

                    login_pwd_new_view_change.setEnabled(false);
                    login_pwd_new_view_change.setAlpha(0.5F);
                }
            }
        });

        //6. 새 비밀번호
        user_mypage_2_edittext_new_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //입력하기 전 호출되는 API
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //EditText에 변화가 있을 때
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //입력이 끝났을 때
                String pwd_1 = user_mypage_2_edittext_new_1.getText().toString();

                if(pwd_1.matches(".*[0-9].*")) //숫자 있으면
                {
                    Log.i("새 비밀번호 1", "숫자 O");

                    if(pwd_1.matches(".*[a-zA-Z].*")) //문자 있으면
                    {
                        Log.i("새 비밀번호 1", "문자 O");

                        if (pwd_1.matches(".*[!@#$%^&+=].*"))  //특수문자 있으면
                        {
                            Log.i("새 비밀번호 1", "특수문자 O");

                            if (pwd_1.length() > 7) //8자 넘으면
                            {
                                Log.i("새 비밀번호 1", "8글자 이상");

                                new_1 = true;
                                user_mypage_2_textview_error2.setText("");

                                if(now && new_1 && new_2)
                                {
                                    login_pwd_new_view_change.setEnabled(true);
                                    login_pwd_new_view_change.setAlpha(1.0F);
                                }
                            }
                            else //숫자 안됨
                            {

                                Log.i("새 비밀번호 1 오류", "숫자 X");
                                new_1 = false;
                                user_mypage_2_textview_error2.setText("올바른 비밀번호를 입력해주세요");
                                user_mypage_2_textview_error2.setTextColor(getResources().getColor(R.color.login_pwd_red));
                                user_mypage_2_textview_error2.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(user_mypage_2_info_pwd_activity.this, R.color.login_pwd_red)));

                                login_pwd_new_view_change.setEnabled(false);
                                login_pwd_new_view_change.setAlpha(0.5F);
                            }

                        }
                        else //특수문자 안됨
                        {
                            Log.i("새 비밀번호 1 오류", "특수문자 X");
                            new_1 = false;
                            user_mypage_2_textview_error2.setText("올바른 비밀번호를 입력해주세요");
                            user_mypage_2_textview_error2.setTextColor(getResources().getColor(R.color.login_pwd_red));
                            user_mypage_2_textview_error2.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(user_mypage_2_info_pwd_activity.this, R.color.login_pwd_red)));

                            login_pwd_new_view_change.setEnabled(false);
                            login_pwd_new_view_change.setAlpha(0.5F);
                        }
                    }
                    else //문자 안됨
                    {
                        Log.i("새 비밀번호 1 오류", "문자 X");
                        new_1 = false;
                        user_mypage_2_textview_error2.setText("올바른 비밀번호를 입력해주세요");
                        user_mypage_2_textview_error2.setTextColor(getResources().getColor(R.color.login_pwd_red));
                        user_mypage_2_textview_error2.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(user_mypage_2_info_pwd_activity.this, R.color.login_pwd_red)));

                        login_pwd_new_view_change.setEnabled(false);
                        login_pwd_new_view_change.setAlpha(0.5F);

                    }
                }
                else //숫자 안됨
                {
                    Log.i("현재 비밀번호 오류", "숫자 X");
                    new_1 = false;
                    user_mypage_2_textview_error2.setText("올바른 비밀번호를 입력해주세요");
                    user_mypage_2_textview_error2.setTextColor(getResources().getColor(R.color.login_pwd_red));
                    user_mypage_2_textview_error2.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(user_mypage_2_info_pwd_activity.this, R.color.login_pwd_red)));

                    login_pwd_new_view_change.setEnabled(false);
                    login_pwd_new_view_change.setAlpha(0.5F);
                }
            }
        });

        //7. 새 비밀번호 확인
        user_mypage_2_edittext_new_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //입력하기 전 호출되는 API
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //EditText에 변화가 있을 때
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //입력이 끝났을 때
                String pwd_1 = user_mypage_2_edittext_new_1.getText().toString();
                String pwd_2 = user_mypage_2_edittext_new_2.getText().toString();

                if(pwd_2.equals(pwd_1)) //새 비밀번호 1,2가 같으면
                {
                    Log.i("새 비밀번호 2 통과", "같음 O");
                    new_2 = true;
                    user_mypage_2_textview_error3.setText("");

                    if(now && new_1 && new_2)
                    {
                        login_pwd_new_view_change.setEnabled(true);
                        login_pwd_new_view_change.setAlpha(1.0F);
                    }
                }
                else
                {
                    Log.i("현재 비밀번호 오류", "X");
                    new_2 = false;
                    user_mypage_2_textview_error3.setText("새로운 비밀번호와 일치하지 않습니다.");
                    user_mypage_2_textview_error3.setTextColor(getResources().getColor(R.color.login_pwd_red));
                    user_mypage_2_textview_error3.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(user_mypage_2_info_pwd_activity.this, R.color.login_pwd_red)));

                    login_pwd_new_view_change.setEnabled(false);
                    login_pwd_new_view_change.setAlpha(0.5F);
                }
            }
        });



        //8. 비밀번호 변경 완료 클릭 시
        login_pwd_new_view_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user_pwd = user_mypage_2_edittext_new_1.getText().toString();
                //1. XML에서  비밀번호, 이름, 생년월일, 이메일, 핸드폰 번호 조회
                Log.i("새로 입력된 user_pwd는 ", user_pwd);


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

                                String user_pwd = jsonObject.getString("user_pwd");
                                String username = jsonObject.getString("username");
                                String user_email = jsonObject.getString("user_email");

                                Log.i("업데이트된 user_pwd는 ", user_pwd);
                                Log.i("업데이트된 user_email은 ", user_email);

                                Log.i("성공 ", ": O");

                                //성공 화면으로 넘기기
                                Intent intent = new Intent(getApplicationContext(), login_pwd_new2_activity.class);
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
                user_mypage_info_pwd_new_request login_pwd_request = new user_mypage_info_pwd_new_request(user_pwd, login_user_name, login_user_email, responseListener);
                //login_1_화면에서 큐 생성
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                //큐에 login_check_request 클래스 담음 (실제 값 전송-성공여부담아옴)
                queue.add(login_pwd_request);

            }
        });


    }
}
