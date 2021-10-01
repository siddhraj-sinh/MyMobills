package com.siddharaj.mymobills.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.siddharaj.mymobills.view.adapter.CreateInvoiceViewPagerAdapter
import com.siddharaj.mymobills.R
import com.google.android.material.tabs.TabLayout


class CreateInvoiceFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = view.findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab)
       viewPager.adapter = CreateInvoiceViewPagerAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(viewPager)


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_create_invoice, container, false)
    }



}