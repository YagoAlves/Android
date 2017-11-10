package com.example.hduar.xatvexo.acess;

import android.os.StrictMode;
import android.util.Log;

import com.example.hduar.xatvexo.model.Locais;
import com.example.hduar.xatvexo.model.Usuario2;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yago_alves on 20/11/16.
 */
public class RestLocais {


    public List<Locais> getLocais (String url) {

        List<Locais> l = new ArrayList<Locais>();
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet chamadaget = new HttpGet(url);
        String retorno = "";

        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(chamadaget, responseHandler);
            retorno = responseBody;
            //Log.d("Retorno", retorno);

            JSONArray array = new JSONArray(retorno);
            for (int i=0 ;i < array.length(); i++) {

                JSONObject object = new JSONObject(array.getString(i));
                Locais locais = new Locais();
                locais.setId(object.getInt("id"));
                locais.setEndereco(object.getString("endereco"));
                locais.setLatitude((float) object.getDouble("latitude"));
                locais.setLongitude((float) object.getDouble("longitude"));
                locais.setNome(object.getString("nome"));

                Log.d("GET LOCAIS",locais.getNome());
                l.add(locais);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return l;
    }

    public List<Locais> getFavoritos (String url, Usuario2 u) {

        JSONObject jo = new JSONObject();
        List<Locais> l = new ArrayList<Locais>();
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost chamadapost = new HttpPost(url);
        String resposta = "";

        try {

            jo.put("id",u.getId());

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            StringEntity se = new StringEntity(jo.toString());
            se.setContentType("application/json;charset=UTF-8");

            chamadapost.setEntity(se);
            HttpResponse httpResponse = httpclient.execute(chamadapost);
            resposta = EntityUtils.toString(httpResponse.getEntity());
            //Log.d("Retorno", retorno);

            JSONArray array = new JSONArray(resposta);
            for (int i=0 ;i < array.length(); i++) {

                JSONObject object = new JSONObject(array.getString(i));
                Locais locais = new Locais();
                locais.setEndereco(object.getString("endereco"));
                locais.setId(object.getInt("id"));
                //locais.setLatitude((float) object.getDouble("latitude"));
                //locais.setLongitude((float) object.getDouble("longitude"));
                locais.setNome(object.getString("nome"));

                Log.d("GET LOCAIS",locais.getNome());
                l.add(locais);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return l;
    }

    public void inserirFavorito (String url, Usuario2 usuario, Locais local) {

        JSONObject jo = new JSONObject();
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost chamadapost = new HttpPost(url);
        String resposta = "";

        try {

            jo.put("id_usuario", usuario.getId());
            jo.put("id_local", local.getId());

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

        //return resposta;
    }

    public void apagarFavorito (String url, Locais locais) {

        JSONObject jo = new JSONObject();
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost chamadapost = new HttpPost(url);
        String resposta = "";

        try {

            jo.put("id", locais.getId());
            //jo.put("id_local", local.getId());

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

        //return resposta;
    }

    public void inserirLocal (String url, Locais local) {

        JSONObject jo = new JSONObject();
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost chamadapost = new HttpPost(url);
        String resposta = "";

        try {

            jo.put("nome", local.getNome());
            jo.put("endereco", local.getEndereco());
            jo.put("latitude", local.getLatitude());
            jo.put("longitude", local.getLongitude());

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

        //return resposta;
    }


}


