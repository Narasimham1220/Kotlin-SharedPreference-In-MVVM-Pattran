package com.example.sampletask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampletask.R
import com.example.sampletask.adapter.RecyclerViewAdapter
import java.util.*

class ListFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerViewAdapter
    var dataList: ArrayList<String> = ArrayList();


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = activity?.let { RecyclerViewAdapter(it, dataList) }!!
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        addAnimals()
        recyclerView.adapter = adapter
        return view
    }

    private fun addAnimals() {
        for (i in 0..15) {
            dataList.add("$i")
        }
    }


}