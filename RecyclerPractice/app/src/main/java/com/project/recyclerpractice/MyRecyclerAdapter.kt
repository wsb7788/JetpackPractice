package com.project.recyclerpractice

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter(myRecyclerviewInterface: MyRecyclerviewInterface) : RecyclerView.Adapter<MyViewHolder>(){

    val TAG: String = "로그"

    private var modelList = ArrayList<MyModel>()

    private var myRecyclerviewInterface: MyRecyclerviewInterface? =null

    //생성자
    init{
        this.myRecyclerviewInterface = myRecyclerviewInterface
    }
    // 뷰홀더 생성 되었을떄
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item, parent, false), this.myRecyclerviewInterface!!)
    }

     // 뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "MyRecyclerAdapter - onBindViewHolder() called / position: $position")
        holder.bind(this.modelList[position])
         // 클릭 리스너 설정
    }

    //목록의 아이템수
    override fun getItemCount() = this.modelList.size



    fun submitList(modelList: ArrayList<MyModel>){
        this.modelList = modelList
    }
}