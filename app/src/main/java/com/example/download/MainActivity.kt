package com.example.download

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.download.databinding.ActivityMainBinding
import com.orhanobut.logger.Logger
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.btnStart.setOnClickListener {
            Thread.currentThread().name.toLog()
            val okHttpClient = OkHttpClient()
            val build = Request.Builder().url("https://api.uomg.com/api/rand.qinghua?format=json").build()
            val newCall = okHttpClient.newCall(build)
            newCall.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
//                    response.body?.string().toString().toLog()
                   response.request.url.toString().toLog()



                }

            })
        }

        binding.btnStop.setOnClickListener {

        }
    }

    private fun downLoadApk(url: String, title: String) {

    }

}

fun log(any: Any) {
    Logger.d(any)
}

fun Any.toLog() {
    Logger.d(this)
}