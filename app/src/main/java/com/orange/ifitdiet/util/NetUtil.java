package com.orange.ifitdiet.util;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.orange.ifitdiet.domain.LoginUserBean;
import com.orange.ifitdiet.domain.RegisterUserBean;

import org.apache.http.Header;

/**
 * Created by 廖俊瑶 on 2016/9/2.
 */
public class NetUtil {
    private String server_url="10.30.11.80:8080/iFitDiet2/cn/chengzi/account/AccountServlet";
    private AsyncHttpClient client = new AsyncHttpClient();
    private boolean isRegistered = false;

    public boolean register(RegisterUserBean userBean){
        RequestParams params=new RequestParams();
        params.put("username",userBean.getUserName());
        params.put("sex",userBean.getSex());
        params.put("password",userBean.getPsw());
        params.put("phone",userBean.getTel());
        params.put("portrait",userBean.getAvatar());
        params.put("email",userBean.getEmail());
        params.put("hometown",userBean.getHometown());
        params.put("birthday",userBean.getBirthday());
        client.post(server_url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                isRegistered =true;
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                isRegistered=false;
            }
        });
        return isRegistered;
    }
    public boolean login(LoginUserBean userBean){


        return false;
    }

}