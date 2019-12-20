package com.example.sampletask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sampletask.R
import kotlinx.android.synthetic.main.fragment_empty.view.*
import java.util.*

class TimeZoneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_empty, container, false);
        view.txt_data.text = timeZone()
        return view
    }


    fun timeZone(): String {
        val tz = TimeZone.getTimeZone("GMT+05:30");
        val c = Calendar.getInstance(tz);
        val time = String.format("%02d", c.get(Calendar.HOUR_OF_DAY)) + ":" +
                String.format("%02d", c.get(Calendar.MINUTE)) + ":" + String.format(
            "%02d",
            c.get(Calendar.SECOND)
        ) + ":" + String.format("%03d", c.get(Calendar.MILLISECOND));
        return time
    }
}