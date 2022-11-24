package com.example.parayo.intro

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.parayo.api.ParayoApi
import com.example.parayo.signin.SigninActivity
import com.example.parayo.signup.SignupActivity
import kotlinx.coroutines.*

import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class IntroActivity : Activity() {

    val TAG = IntroActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        IntroActivityUI().setContentView(this)

        GlobalScope.launch {
            delay(1000)
            startActivity<SigninActivity>()
            finish()
        }
//        runBlocking {
//            try {
//                val response = ParayoApi.instance.hello()
//                Log.e(TAG, response.data)
//            } catch (e: java.lang.Exception){
//                Log.e(TAG, "Hello API 호출 오류", e)
//            }
//        }
    }
}





