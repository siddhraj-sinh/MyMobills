package com.siddharaj.mymobills.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.siddharaj.mymobills.R
import com.siddharaj.mymobills.view.adapter.SampleAdapter


import com.siddharaj.mymobills.model.SampleModel
import com.siddharaj.mymobills.model.Suppliers


class AllFragment : Fragment() {
    private lateinit var mAdapter: SampleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView:RecyclerView = view.findViewById(R.id.rv_all_invoice)
             recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mAdapter = SampleAdapter(Suppliers.sampleList)
        recyclerView.adapter=mAdapter
      val searchView:SearchView = view.findViewById(R.id.search_all)
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
             filter(newText)
                return false
            }

        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all, container, false)
    }



     fun filter(newText: String?) {
        val filteredList= ArrayList<SampleModel>()

        for(i in Suppliers.sampleList){
            if(i.name.toLowerCase().contains(newText?.toLowerCase().toString())){
                filteredList.add(i)
            }
        }
        if (filteredList.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(requireContext(), "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            mAdapter.filterList(filteredList)
        }
    }

}