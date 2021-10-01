package com.siddharaj.mymobills.model.database

import androidx.lifecycle.LiveData
import com.siddharaj.mymobills.model.InvoiceWithItems
import com.siddharaj.mymobills.model.entities.Invoice
import com.siddharaj.mymobills.model.entities.Items

class InvoiceRepository(private val invoiceDao:InvoiceDao) {
    val allInvoice : LiveData<List<InvoiceWithItems>> = invoiceDao.getItemsAndInvoice()

    suspend fun insert(invoice:Invoice){
        invoiceDao.insert(invoice)
    }

    suspend fun insertItem(item:Items){
        invoiceDao.insertItem(item)
    }

  suspend fun update(invoice: Invoice){
      invoiceDao.update(invoice)
  }
}