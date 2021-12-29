package com.project.koroutinepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.internal.tls.OkHostnameVerifier
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coroutine()
    }

    fun coroutine(){

        CoroutineScope(Dispatchers.Main).launch {

            val html = CoroutineScope(Dispatchers.Default).async {
                //network
                getHtmlStr()
            }.await() //이녀석이 끈나기를 기다린다
            /*val mTextMain = findViewById<TextView>(R.id.mTextMain)
            mTextMain.text = html*/
            // main thread이므로 UI변경

        }
    }

    fun getHtml():String {
        //okhttp의 큰 흐름
        //1. 클라이언트 만들기
        val client = OkHttpClient.Builder().build()
        //2. 요청
        val req = Request.Builder().url("https://www.google.com").build()
        //3. 응답
        client.newCall(req).execute().use {
            response -> return if(response.body != null){
                response.body!!.toString()
        } else{
            "body null"
        }
        }
    }
    fun getHtmlStr() {
        //okhttp의 큰 흐름
        //1. 클라이언트 만들기
        val client = OkHttpClient.Builder().build()
        //2. 요청
        val req = Request.Builder().url("https://www.google.com").build()
        //3. 응답
        client.newCall(req).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                response.body!!.toString()
                CoroutineScope(Dispatchers.Main).launch {
                    val mTextMain = findViewById<TextView>(R.id.mTextMain)
                    mTextMain.text = response.body.toString()
                }
            }


        })
        /* execute().use {
             response -> return if(response.body != null){
                 response.body!!.toString()
         } else{
             "body null"
         }
         }*/

    }
}
