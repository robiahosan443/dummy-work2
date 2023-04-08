package vistula.sf.roomdb

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

import java.util.*


class CalenderActivity : AppCompatActivity() {

    lateinit var editText: EditText
    var datee: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)

        editText = findViewById(R.id.edtCalender);


        editText.setOnClickListener {
         //   DatePickerDialogClass().getDate(this)

            editText.setText(getDate())
        }
    }

    fun getDate(): String {

        var date: Calendar = Calendar.getInstance()
        var thisAYear = date.get(Calendar.YEAR).toInt()
        var thisAMonth = date.get(Calendar.MONTH).toInt()
        var thisADay = date.get(Calendar.DAY_OF_MONTH).toInt()
        var selectedDate: String


        val dpd = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { view2, thisYear, thisMonth, thisDay ->

                thisAMonth = thisMonth + 1
                thisADay = thisDay
                thisAYear = thisYear


                selectedDate = "Date: " + thisAMonth + "/" + thisDay + "/" + thisYear


            },
            thisAYear,
            thisAMonth,
            thisADay

        )

        dpd.show()
        Log.d("TAG", "getDateee: " + datee)
        return this.datee
    }


}

