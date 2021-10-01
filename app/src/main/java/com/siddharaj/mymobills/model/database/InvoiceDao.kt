package com.siddharaj.mymobills.model.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.siddharaj.mymobills.model.InvoiceWithItems
import com.siddharaj.mymobills.model.entities.Invoice
import com.siddharaj.mymobills.model.entities.Items

@Dao
interface InvoiceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(invoice: Invoice)

    @Insert
    suspend fun insertItem(item:Items)


    @Update
    suspend fun update(invoice:Invoice)
    @Transaction
    @Query("Select * from invoice_table")
    fun getItemsAndInvoice(): LiveData<List<InvoiceWithItems>>
}