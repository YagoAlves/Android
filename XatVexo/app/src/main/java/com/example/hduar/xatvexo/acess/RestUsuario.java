package com.example.hduar.xatvexo.acess;

import android.os.StrictMode;
import android.util.Log;

import com.example.hduar.xatvexo.model.Usuario;
import com.example.hduar.xatvexo.model.Usuario2;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by yago_alves on 19/11/16.
 */
public class RestUsuario {

    private int TIMEOUT_MILLISEC = 3000;

    public void cadastraUsuario(String url, Usuario2 usuario) {

        JSONObject jo = new JSONObject();
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost chamadapost = new HttpPost(url);
        String resposta = "";

        try {

            jo.put("nome", usuario.getNome());
            jo.put("senha", usuario.getSenha());
            jo.put("telefone", usuario.getTelefone());
            jo.put("email", usuario.getEmail());

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            StringEntity se = new StringEntity(jo.toString());
            se.setContentType("application/json;charset=UTF-8");
            //se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));

            chamadapost.setEntity(se);
            HttpResponse httpResponse = httpclient.execute(chamadapost);
            resposta = EntityUtils.toString(httpResponse.getEntity());
            //JSONObject object = new JSONObject(resposta);

            //Log.i("POST :",jo.toString());
            Log.i("POST Cadastro: ", resposta);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String login(String login, String senha, String url) {


        JSONObject jo = new JSONObject();
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost chamadapost = new HttpPost(url);
        String resposta = "";

        try {

            jo.put("email", login);
            jo.put("senha", senha);

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            StringEntity se = new StringEntity(jo.toString());
            se.setContentType("application/json;charset=UTF-8");
            //se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));

            chamadapost.setEntity(se);
            HttpResponse httpResponse = httpclient.execute(chamadapost);
            resposta = EntityUtils.toString(httpResponse.getEntity());
            //JSONObject object = new JSONObject(resposta);

            Log.i("POST :", jo.toString());
            Log.i("POST : ", resposta);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
          }

            return resposta;
        }



    }
