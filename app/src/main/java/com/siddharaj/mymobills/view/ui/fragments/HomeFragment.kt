package com.siddharaj.mymobills.view.ui.fragments


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.siddharaj.mymobills.view.adapter.InvoiceViewPagerAdapter
import com.siddharaj.mymobills.view.ui.activities.MainActivity
import com.siddharaj.mymobills.R
import com.google.android.material.tabs.TabLayout


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = view.findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab)
        viewPager.adapter = InvoiceViewPagerAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        (activity as MainActivity).supportActionBar?.elevation = 0F

        return view
    }

   override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.first_fragment_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}