package vistula.sf.roomdb

import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.widget.EditText
import java.util.*
import kotlin.reflect.KMutableProperty0

 class DatePickerDialogClass {
companion object{
    fun getDate(context: Context, myCallback: (result: String?) -> Unit): String {

        var date: String? = null
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(context,
            { view, year, monthOfYear, dayOfMonth ->
                date = "$dayOfMonth $month, $year"
                myCallback.invoke(date)
            }, year, month - 1, day
        )

        dpd.show()
        Log.d("TAG", "DatePickerDialogClass: " + date)
        return dpd.datePicker.toString()
    }
}



}