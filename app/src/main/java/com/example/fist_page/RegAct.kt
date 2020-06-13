package com.example.fist_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_reg.*

class RegAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

       reg_signup.setOnClickListener {

           if(reg_password.text.toString().equals(reg_confirm.text.toString())) {

               var url =
                   "http://172.18.6.49/SalesWeb/add_user.php?mobile=" + reg_mobile.text.toString() + "&password=" + reg_password.text.toString() + "&name=" + reg_name.text.toString()
               
               
               var rq:RequestQueue=Volley.newRequestQueue(this)
               var sr=StringRequest(Request.Method.GET,url,Response.Listener { response ->
                   if(response.equals("0"))
                       Toast.makeText(this,"Mobile already used",Toast.LENGTH_SHORT).show()
                   else
                       Toast.makeText(this,"User Created",Toast.LENGTH_SHORT).show()

               },Response.ErrorListener { error ->
                   Toast.makeText(this,error.message,Toast.LENGTH_SHORT).show()
               })
               rq.add(sr)
           }else
               
               Toast.makeText(this,"password not match",Toast.LENGTH_SHORT).show()
       }




    }
}
