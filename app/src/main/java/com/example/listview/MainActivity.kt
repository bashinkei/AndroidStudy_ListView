package com.example.listview

import android.content.Intent
import android.icu.util.TimeZone
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //画面のレイアウトを固定する
        setContentView(R.layout.activity_main)

        //リスtpで表示するタイムゾーン一覧
        val timeZones = TimeZone.getAvailableIDs()

        //リストをレイアウトから探す
        val listView = findViewById<ListView>(R.id.timeZoneList)

        //アダプターを作成
        val adapter = ArrayAdapter<String>(
            this,
            R.layout.list_time_zone_row,
            R.id.timezone,
            timeZones
        )

        //リストにアダプターをセットする
        listView.adapter = adapter

        //リストのアイテムタップ時の動作
        listView.setOnItemClickListener { parent, view, position, id ->
            //  アダプターから押された位置のタイムゾーンを得る
            val timeZone = adapter.getItem(position)

            //Toastで表示
            Toast.makeText(this, timeZone, Toast.LENGTH_SHORT).show()

            //main2へ移動
            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("select", timeZone)
            startActivity(intent)
            //これ以下って実行されんの？

        }


    }
}
