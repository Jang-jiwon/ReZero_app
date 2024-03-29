package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class login_1_activity extends AppCompatActivity
{
    private EditText login_id_edittext;
    private EditText login_pwd_edittext;
    private View login_login_view;
    private View login_new_view;
    private TextView login_find_text;

    private LinearLayout login_layout;
    private InputMethodManager imm;
    
    //로그인 변수
    Boolean login = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_1_); //레이아웃에서 띄울 xml 화면 선택

        login_id_edittext = (EditText) findViewById(R.id.login_id_edittext); //아이디 입력한 값
        login_pwd_edittext = (EditText) findViewById(R.id.login_pwd_edittext); //비밀번호 입력한 값
        login_login_view = (View) findViewById(R.id.login_login_view); //로그인 버튼 뷰
        login_new_view = (View) findViewById(R.id.login_new_view); //회원가입 버튼 뷰
        login_find_text = (TextView) findViewById(R.id.login_find_text); //아이디 비밀번호 찾기 텍스트

        // (0) EditText 키보드 배경 자동 내림
        login_layout = (LinearLayout) findViewById(R.id.login_layout);
        imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        login_layout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imm.hideSoftInputFromWindow(login_id_edittext.getWindowToken(), 0); //edittext1 실제로
                imm.hideSoftInputFromWindow(login_pwd_edittext.getWindowToken(), 0); //edittext2 내려가게 만들기
            }
        });

        login_login_view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // (1) 로그인 뷰 클릭시 화면 성공했는지 확인

                // (1-1) 값 가져옴
                String user_email = login_id_edittext.getText().toString();
                String user_pwd = login_pwd_edittext.getText().toString(); // int는 Integer.parseInt(변수.getText().toString())로 하면 됨
                Log.i("입력된 user_email은 ",user_email);
                Log.i("입력된 user_pwd는 ",user_pwd);

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
                                    String user_email = jsonObject.getString("user_email");
                                    String username = jsonObject.getString("username");
                                    String user_pwd = jsonObject.getString("user_pwd");
                                    String user_birth = jsonObject.getString("user_birth");
                                    String user_phone_num = jsonObject.getString("user_phone_num");
                                    String user_bank = jsonObject.getString("user_bank");
                                    String user_account = jsonObject.getString("user_account");
                                    String user_address = jsonObject.getString("user_address");
                                    String user_like_pro = jsonObject.getString("user_like_pro");
                                    String user_order_id = jsonObject.getString("user_order_id");
                                    String user_point = jsonObject.getString("user_point");
                                    String user_coupon_id = jsonObject.getString("user_coupon_id");
                                    String user_mission_id = jsonObject.getString("user_mission_id");
                                    String user_like_designer = jsonObject.getString("user_like_designer");
                                    String user_cart_id = jsonObject.getString("user_cart_id");
                                    String user_review_id = jsonObject.getString("user_review_id");
                                    String user_chat_id = jsonObject.getString("user_chat_id");

                                    Log.i("가져온 user_email은 ",user_email);
                                    Log.i("가져온 user_pwd는 ",user_pwd);
                                    Log.i("가져온 user_name은 ",username);

                                    //짧게 알람 문구 보여주기 - 확인용
                                    Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();

                                    //로그인 상태 ON
                                    login = true;

                                    //메인 화면으로 이동 - 원래는 아랜데 잠시 확인 위해 바꿈
                                    //Intent intent = new Intent(login_1_activity.this, MainActivity.class);
                                    Intent intent = new Intent(login_1_activity.this, MainActivity.class);

                                    /* 화면 넘어갈 때 누가 로그인한건지 알기 위해 값 넘김 */

                                    //1. user_mypage_1로 넘기기!!!
                                    intent.putExtra("login", login+"");

                                    intent.putExtra("login_user_email",user_email);
                                    intent.putExtra("login_user_pwd", user_pwd);
                                    intent.putExtra("login_user_name", username);
                                    intent.putExtra("login_user_birth", user_birth);
                                    intent.putExtra("login_user_phone_num", user_phone_num);
                                    intent.putExtra("login_user_bank", user_bank);
                                    intent.putExtra("login_user_account", user_account);
                                    intent.putExtra("login_user_address", user_address);
                                    intent.putExtra("login_user_like_pro", user_like_pro);
                                    intent.putExtra("login_user_order",user_order_id);
                                    intent.putExtra("login_user_point",user_point);
                                    intent.putExtra("login_user_coupon",user_coupon_id);
                                    intent.putExtra("login_user_mission", user_mission_id);
                                    intent.putExtra("login_user_like_designer", user_like_designer);
                                    intent.putExtra("login_user_cart",user_cart_id);
                                    intent.putExtra("login_user_review",user_review_id);
                                    intent.putExtra("login_user_chat",user_chat_id);

                                    Log.i("login_1 -> 로그인함? ", String.valueOf(login));
                                    startActivity(intent);
                                    return;
                                }
                                else //실패했으면
                                {
                                    // (2) 틀렸으면 경고창 문구 띄우고 다시
                                    //틀림 알람 문구 띄우기
                                    Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();

                                    //Edittext 비우기
                                    login_id_edittext.setText("");
                                    login_pwd_edittext.setText("");
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                // (3) 서버로 Volley를 이용해서 요청함

                //login_1_request 클래스 (URL/PHP/전송방식 설정) 형식의 login_check_request 클래스 생성 > edittext에서 가져온 값 실제 전송
                login_1_request login_check_request = new login_1_request(user_email, user_pwd, responseListener);
                Log.i("오잉1","뭐가 되고 있는거긴함?");
                //login_1_화면에서 큐 생성
                RequestQueue queue = Volley.newRequestQueue(login_1_activity.this);
                //큐에 login_check_request 클래스 담음 (실제 값 전송-성공여부담아옴)
                queue.add(login_check_request);
                Log.i("오잉2","발리 큐에 들어갔냐?");
            }
        });

        login_new_view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //회원가입 뷰 클릭시 회원가입 화면으로 이동
                Intent intent = new Intent(login_1_activity.this, login_new_activity.class);
                startActivity(intent);
            }
        });

        login_find_text.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //아이디,비밀번호 찾기 화면으로 이동
                Intent intent = new Intent(login_1_activity.this, login_find_activity.class);
                startActivity(intent);
            }
        });

    }
}
