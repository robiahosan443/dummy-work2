package vistula.sf.roomdb.callback

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import vistula.sf.roomdb.DatePickerDialogClass
import vistula.sf.roomdb.DatePickerDialogClass.Companion.getDate
import vistula.sf.roomdb.R

class FirstActivity : AppCompatActivity() {
    private lateinit var btnClick: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        btnClick = findViewById(R.id.btnClick)

        btnClick.setOnClickListener {
            getDate(this) {result ->

                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }

        };
    }
}