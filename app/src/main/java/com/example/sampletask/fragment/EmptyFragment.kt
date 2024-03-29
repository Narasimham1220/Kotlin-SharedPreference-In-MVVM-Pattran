package com.example.sampletask.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampletask.R
import com.example.sampletask.viewmodel.EmptyViewModel

class EmptyFragment : Fragment() {

    companion object {
        fun newInstance() = EmptyFragment()
    }

    private lateinit var viewModel: EmptyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_empty, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EmptyViewModel::class.java)
    }

}
