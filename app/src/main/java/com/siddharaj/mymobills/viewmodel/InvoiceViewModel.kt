package com.siddharaj.mymobills.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.siddharaj.mymobills.model.InvoiceWithItems
import com.siddharaj.mymobills.model.database.InvoiceDatabase
import com.siddharaj.mymobills.model.database.InvoiceRepository
import com.siddharaj.mymobills.model.entities.Invoice
import com.siddharaj.mymobills.model.entities.Items
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InvoiceViewModel(application: Application) : AndroidViewModel(application) {

    val invoice : LiveData<List<InvoiceWithItems>>
    private val repository:InvoiceRepository
    init {
        val database = InvoiceDatabase.getDatabase(application)
        val dao = database.getInvoice()
         repository =  InvoiceRepository(dao)
        invoice = repository.allInvoice
    }

    fun insertInvoice(inv:Invoice) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(inv)
    }

    fun insertItem(item:Items) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertItem(item)
    }
    fun updateInvoice(inv: Invoice) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(inv)
    }

}