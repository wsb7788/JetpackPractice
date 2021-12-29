package com.project.recyclerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyRecyclerviewInterface {

    var TAG: String = "로그"

    //데이터를 담을 그릇 즉 배열
    var modelList = ArrayList<MyModel>()

    private lateinit var myRecyclerAdapter: MyRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")
        Log.d(TAG, "MainActivity - this.modelList.size: ${this.modelList.size}")

        for(i in 1..10){
            val myModel = MyModel(name = "원승빈 $i", profileImage = "https://img1.daumcdn.net/thumb/C100x100.mplusfriend/?fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fcw9y4A%2FbtqQ6zLQWFA%2F2ByAaV1lrundgLkFkwklzK%2Fimg_s.jpg")

            this.modelList.add(myModel)
        }
        Log.d(TAG, "MainActivity - this.modelList.size: ${this.modelList.size}")

        // 어답터 인스턴스 생성
        myRecyclerAdapter = MyRecyclerAdapter(this)

        myRecyclerAdapter.submitList(this.modelList)


        my_recycler_view.apply {
            // 리사이클러뷰 설정
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

            //어답터 장착
            adapter = myRecyclerAdapter
        }
    }

    override fun onItemClicked(position: Int) {
        Log.d("TAG", "MainActivity - onItemClicked() called")
        Toast.makeText(this, "클릭됨!  $position",Toast.LENGTH_SHORT).show()
    }
}