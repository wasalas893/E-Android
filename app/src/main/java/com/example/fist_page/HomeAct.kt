package com.example.fist_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_home.*
import java.util.ArrayList

class HomeAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var url="http://172.18.6.49/SalesWeb/get_cat.php"
        var list=ArrayList<String>()
        var rq:RequestQueue=Volley.newRequestQueue(this)
        var jar=JsonArrayRequest(Request.Method.GET,url,null,Response.Listener { response ->

            for (x in 0..response.length()-1)
                list.add(response.getJSONObject(x).getString("category"))

            var adp=ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
            home_cat.adapter=adp

        },Response.ErrorListener { error ->
         Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })
        rq.add(jar)
    }
}
