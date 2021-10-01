package com.siddharaj.mymobills.model

import androidx.room.Embedded
import androidx.room.Relation
import com.siddharaj.mymobills.model.entities.Invoice
import com.siddharaj.mymobills.model.entities.Items

//data class to get items corresponding to invoice numbers
data class InvoiceWithItems(@Embedded val invoice: Invoice,
                            @Relation(
                                parentColumn = "invoiceNumber",
                                entityColumn = "invoice_id"
                            ) val items: List<Items>
)