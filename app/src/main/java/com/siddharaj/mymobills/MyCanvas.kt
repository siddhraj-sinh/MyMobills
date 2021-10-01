package com.siddharaj.mymobills


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.siddharaj.mymobills.model.ItemModel

@SuppressLint("ViewConstructor")
class MyCanvas(context: Context?, attr:AttributeSet) : View(context) {




    // two variables for paint "myPaint" is used
    // for drawing shapes and we will use "myTitle"
    // for adding text in our PDF file.
    val myPaint = Paint()
    val myTitle = Paint()

    val customSimpleTypeface = ResourcesCompat.getFont(context!!, R.font.montserrat)
    val customBoldTypeface = ResourcesCompat.getFont(context!!, R.font.montserrat_bold)




    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)



        //header rectangle area
        myPaint.color = Color.RED
        canvas.drawRect(0F, 0F, canvas.width.toFloat(), 5F, myPaint)
        /* //logo area
         canvas.drawBitmap(temp, 20F, 30F, myPaint)*/
        //company name
        myTitle.textSize = 30F
        myTitle.typeface = customBoldTypeface
        businessName?.let { canvas.drawText(it, 20F, 50F, myTitle) }
        //company address
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("C-115-A, Suncity Opp. Ambe School, Manjalpur", 20F, 70F, myTitle)
        //city state pin
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("Vadodara, Gujarat - 390011", 20F, 86F, myTitle)
        //Company Phone Number
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("Phone No :", 20F, 102F, myTitle)
        //compant Phone Number
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("1234567890", 85F, 102F, myTitle)
        //company email
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("Email :", 20F, 118F, myTitle)
        //company email
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("owner_email@yahoo.com", 60F, 118F, myTitle)
        //company website
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("Website :", 20F, 134F, myTitle)
        //compant Website
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("www.website.com", 73F, 134F, myTitle)
        //Bill to
        myTitle.textSize = 18F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("BILL TO", 20F, 160F, myTitle)
        //Client name
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText(clientCompanyName!!, 20F, 185F, myTitle)
        //Client Address
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText(clientAddress!!, 20F, 201F, myTitle)
        //client address
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("$clientCity$clientState-$clientPincode", 20F, 217F, myTitle)
        //client phone
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("Phone No. :", 20F, 233F, myTitle)
        //client Phone
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText(clientPhoneNumber!!, 85F, 233F, myTitle)
        //client GSTIN
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("GSTIN :", 20F, 249F, myTitle)
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText(clientGSTIN!!, 85F, 249F, myTitle)
        //item rectangle
        myPaint.style = Paint.Style.STROKE
        myPaint.strokeWidth = 2F
        myPaint.color = Color.RED
        canvas.drawRect(20F, 256F, canvas.width.toFloat() - 20F, 276F, myPaint)
        //Sr no,description, qty,total
        myTitle.textSize = 12F
        myTitle.typeface = customBoldTypeface
        canvas.drawText("Sr. No.", 25F, 271F, myTitle)
        canvas.drawText("Item Description", 150F, 271F, myTitle)
        canvas.drawText("Qty.", 350F, 271F, myTitle)
        canvas.drawText("Unit Rate", 415F, 271F, myTitle)
        canvas.drawText("Total", 520F, 271F, myTitle)
        //draw lines
        myPaint.style = Paint.Style.FILL
        canvas.drawLine(70F, 256F, 70F, 276F, myPaint)
        canvas.drawLine(330F, 256F, 330F, 276F, myPaint)
        canvas.drawLine(400F, 256F, 400F, 276F, myPaint)
        canvas.drawLine(480F, 256F, 480F, 276F, myPaint)

        //items
        /**
         * hardcoding items using SampleAdapter SampleModel
         */
        val items = ArrayList<ItemModel>()
        items.add(ItemModel("50 KVAR APFC Panel", 10, 100, 1000))
        items.add(ItemModel("100 KVAR PDB Panel", 10, 100, 1000))
        items.add(ItemModel("Item 200", 20, 200, 4000))
        items.add(ItemModel("Item 200", 20, 200, 4000))
        items.add(ItemModel("Item 200", 20, 200, 4000))
        items.add(ItemModel("Item 200", 20, 200, 4000))
        items.add(ItemModel("Item 200", 20, 200, 4000))
        items.add(ItemModel("Item 200", 20, 200, 4000))
        items.add(ItemModel("Item 200", 20, 200, 4000))
        items.add(ItemModel("Item 200", 20, 200, 4000))
        items.add(ItemModel("Item 200", 20, 200, 4000))

        items.add(ItemModel("11th Generation Intel® Core™ i5-11300H Processor", 1, 76989, 76989))
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface

        var serialNumber = 1
        var y = 290F
        val subItemStringArray = ArrayList<String>()
        for (i in 0 until items.size) {

            val currentItem = items[i]

            canvas.drawText("$serialNumber", 25F, y, myTitle)

            val originalStringLength = currentItem.itemName.length

            val parts = originalStringLength / 50
            var temp1 = 0
            var temp2 = 50
            var tempString: String

            if (originalStringLength < 50) {
                canvas.drawText(currentItem.itemName, 76F, y, myTitle)
            } else {
                for (k in 0..parts) {
                    if (temp2 < originalStringLength) {
                        tempString = currentItem.itemName.substring(temp1, temp2)

                    } else {
                        tempString = currentItem.itemName.substring(temp1, originalStringLength)
                    }
                    subItemStringArray.add(tempString)
                    temp1 += 51
                    temp2 += 51

                }
                var z = 0F
                var c = 0F
                for (j in 0 until subItemStringArray.size) {
                    canvas.drawText(subItemStringArray[j], 76F, y + z, myTitle)
                    c = y + z
                    z += 12F
                }
                y = c
            }
            canvas.drawText(currentItem.itemQuantity.toString(), 340F, y, myTitle)
            canvas.drawText(currentItem.itemUnitCost.toString(), 410F, y, myTitle)
            canvas.drawText(currentItem.itemTotal.toString(), 490F, y, myTitle)
            y += 20F
            serialNumber += 1
        }
        val lastItemRow = y
//vertical lines for items
        canvas.drawLine(20F, 276F, 20F, y, myPaint)
        canvas.drawLine(70F, 276F, 70F, y, myPaint)
        canvas.drawLine(330F, 276F, 330f, y, myPaint)
        canvas.drawLine(400F, 276F, 400F, y, myPaint)
        canvas.drawLine(480F, 276F, 480F, y, myPaint)
        canvas.drawLine(
            canvas.width.toFloat() - 20F,
            260F,
            canvas.width.toFloat() - 20F,
            y,
            myPaint
        )
        canvas.drawLine(20F, y, canvas.width.toFloat() - 20F, y, myPaint)
        //footer
        //bank name
        val rowOne = y + 20F
        val rowTwo = rowOne + 20F
        val rowThree = rowTwo + 20F
        val rowFour = rowThree + 20F
        val rowFive = rowFour + 20F
        val rowSix = rowFive + 20F
        myTitle.typeface = customBoldTypeface
        myTitle.textSize = 12F
        canvas.drawText("Bank Name :", 25F, rowOne, myTitle)
        myTitle.typeface = customSimpleTypeface
        myTitle.textSize = 10F
        canvas.drawText("Bank of Baroda", 110F, rowOne, myTitle)
        //subtotal
        myTitle.typeface = customBoldTypeface
        myTitle.textSize = 12F
        canvas.drawText("Subtotal", 410F, rowOne, myTitle)
        myTitle.typeface = customSimpleTypeface
        myTitle.textSize = 10F
        canvas.drawText("60000", 490F, rowOne, myTitle)
        //bank A/c
        myTitle.typeface = customBoldTypeface
        myTitle.textSize = 12F
        canvas.drawText("Bank A/c :", 25F, rowTwo, myTitle)
        myTitle.typeface = customSimpleTypeface
        myTitle.textSize = 10F
        canvas.drawText("012599439263", 110F, rowTwo, myTitle)
        //SGST
        myTitle.typeface = customBoldTypeface
        myTitle.textSize = 12F
        canvas.drawText("SGST 9%", 410F, rowTwo, myTitle)
        myTitle.typeface = customSimpleTypeface
        myTitle.textSize = 10F
        canvas.drawText("5400", 490F, rowTwo, myTitle)
        //ifsc code
        myTitle.typeface = customBoldTypeface
        myTitle.textSize = 12F
        canvas.drawText("IFSC CODE :", 25F, rowThree, myTitle)
        myTitle.typeface = customSimpleTypeface
        myTitle.textSize = 10F
        canvas.drawText("INDB0000172", 110F, rowThree, myTitle)
        //CGST
        myTitle.typeface = customBoldTypeface
        myTitle.textSize = 12F
        canvas.drawText("CGST 9%", 410F, rowThree, myTitle)
        myTitle.typeface = customSimpleTypeface
        myTitle.textSize = 10F
        canvas.drawText("5400", 490F, rowThree, myTitle)
        //Rs.
        myTitle.typeface = customBoldTypeface
        myTitle.textSize = 12F
        canvas.drawText("Rs.", 25F, rowFour, myTitle)
        myTitle.typeface = customSimpleTypeface
        myTitle.textSize = 10F
        canvas.drawText("Seventy thousand eight hundred only ", 110F, rowFour, myTitle)
        //IGST
        myTitle.typeface = customBoldTypeface
        myTitle.textSize = 12F
        canvas.drawText("IGST 0%", 410F, rowFour, myTitle)
        myTitle.typeface = customSimpleTypeface
        myTitle.textSize = 10F
        canvas.drawText("-", 490F, rowFour, myTitle)
        //other charges
        myTitle.typeface = customBoldTypeface
        myTitle.textSize = 12F
        canvas.drawText("Other", 410F, rowFive, myTitle)
        myTitle.typeface = customSimpleTypeface
        myTitle.textSize = 10F
        canvas.drawText("-", 490F, rowFive, myTitle)
        //Grant total
        myTitle.typeface = customBoldTypeface
        myTitle.textSize = 12F
        canvas.drawText("Grand Total", 410F, rowSix, myTitle)
        myTitle.typeface = customSimpleTypeface
        myTitle.textSize = 10F
        canvas.drawText("70800", 490F, rowSix, myTitle)
        //signature
        myTitle.textSize = 8F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText(
            "Certified that the particulars given above are true & correct",
            340F,
            rowSix + 30F,
            myTitle
        )
        // horizontal LINES
        canvas.drawLine(20F, y + 25F, canvas.width.toFloat() - 20F, y + 25F, myPaint)
        canvas.drawLine(20F, rowOne + 25F, canvas.width.toFloat() - 20F, rowOne + 25F, myPaint)
        canvas.drawLine(20F, rowTwo + 25F, canvas.width.toFloat() - 20F, rowTwo + 25F, myPaint)
        canvas.drawLine(400F, rowThree + 25F, canvas.width.toFloat() - 20F, rowThree + 25F, myPaint)
        canvas.drawLine(400F, rowFour + 25F, canvas.width.toFloat() - 20F, rowFour + 25F, myPaint)
        canvas.drawLine(20F, rowFive + 25F, canvas.width.toFloat() - 20F, rowFive + 25F, myPaint)
        //vertical
        canvas.drawLine(20F, lastItemRow, 20F, rowFive + 25F, myPaint)
        canvas.drawLine(400F, lastItemRow, 400F, rowFive + 25F, myPaint)
        canvas.drawLine(480F, lastItemRow, 480F, rowFive + 25F, myPaint)
        canvas.drawLine(
            canvas.width.toFloat() - 20F,
            lastItemRow,
            canvas.width.toFloat() - 20F,
            rowFive + 25F,
            myPaint
        )
        //vertical final footer sign
        canvas.drawLine(20F,rowFive + 25F,20F,rowFive + 150F,myPaint)
        canvas.drawLine(330F, rowFive + 25F, 330F, rowFive + 150F, myPaint)
        canvas.drawLine(canvas.width.toFloat()-20F,rowFive + 25F,canvas.width.toFloat()-20F,rowFive + 150F,myPaint)
        //horizontal final footer
        canvas.drawLine(20F,rowFive + 150F,canvas.width.toFloat()-20F,rowFive + 150F,myPaint)

        // invoice rectangle
        myPaint.style = Paint.Style.FILL
        myPaint.color = Color.RED
        canvas.drawRect(20F, 165F, 150F, 170F, myPaint)
        //Invoice text area
        myTitle.textSize = 26F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("INVOICE", canvas.width.toFloat() - 180F, 50F, myTitle)

        //rectangle area
        myPaint.style = Paint.Style.FILL
        myPaint.color = Color.RED
        canvas.drawRect(
            canvas.width.toFloat() - 180F,
            55F,
            canvas.width.toFloat() - 180F + 130F,
            60F,
            myPaint
        )
        //invoice number text
        myTitle.textSize = 12F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("Invoice No :", canvas.width.toFloat() - 180F, 80F, myTitle)
        //invoice number
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("1001", canvas.width.toFloat() - 180F + 70F, 80F, myTitle)

        //invoice date text

        myTitle.textSize = 12F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("Invoice Date :", canvas.width.toFloat() - 180F, 96F, myTitle)
        //invoice number
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("09/08/2021", canvas.width.toFloat() - 180F + 80F, 96F, myTitle)

        //GSTIN

        myTitle.textSize = 12F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("GSTIN :", canvas.width.toFloat() - 180F, 112F, myTitle)

        //GSTIN
        myTitle.textSize = 10F
        myTitle.typeface = customSimpleTypeface
        canvas.drawText("24AAQFR4066H1ZX", canvas.width.toFloat() - 180F + 50F, 112F, myTitle)


    }

    companion object{

        //owner details
        var businessName:String? = "Sample Name"
        var GSTIN:String? = "XXXX"

        //client details

        var clientCompanyName:String? = "Sample Client Name"
        var clientGSTIN:String? = "XXXX"
        var clientPhoneNumber:String? = "1234567890"
        var clientAddress :String? = "Sample Address"
        var clientCity:String? = "City"
        var clientState:String? = "State"
        var clientPincode:String? ="XXXX"
        

    }



}