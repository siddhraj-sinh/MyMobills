package com.siddharaj.mymobills.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "invoice_table")
data class Invoice(
    @PrimaryKey(autoGenerate = true)  var invoiceNumber : Int = 0,
    @ColumnInfo(name = "invoice_date") val invoiceDate: String,
    @ColumnInfo(name = "invoice_due_date") val invoiceDueDate: String,
    @ColumnInfo(name = "client_name") val clientName: String,
    @ColumnInfo(name = "client_gst_in") val clientGSTIN: String,
    @ColumnInfo(name="client_phone_number") val clientPhoneNumber:String,
    @ColumnInfo(name = "client_address") val clientAddress: String,
    @ColumnInfo(name="client_city") val clientCity:String,
    @ColumnInfo(name="client_pin_code") val clientPincode:String,
    @ColumnInfo(name="client_state") val clientState:String,
    @ColumnInfo(name = "total_amount") val totalAmount: String,
    @ColumnInfo(name = "sgst_percentage") val SGST: String,
    @ColumnInfo(name = "sgst_amount") val SGSTAmount: String,
    @ColumnInfo(name = "cgst_percentage") val CGST: String,
    @ColumnInfo(name = "cgst_amount") val CGSTAmount: String,
    @ColumnInfo(name = "igst_percentage") val IGST: String,
    @ColumnInfo(name = "igst_amount") val IGSTAmount: String,
    @ColumnInfo(name = "grand_total") val grandTotal: String,
    @ColumnInfo(name = "is_paid") val isPaid: Boolean = false
)

@Entity(tableName = "items_table")
data class Items(
    @PrimaryKey val itemId: Int,
    @ColumnInfo(name = "invoice_id") val invoiceId: Int,
    @ColumnInfo(name = "item_description") val itemDescription: String,
    @ColumnInfo(name = "quantity") val quantity: String,
    @ColumnInfo(name = "unit_cost") val unitCost: String
)


