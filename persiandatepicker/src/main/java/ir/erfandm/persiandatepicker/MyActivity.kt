package ir.erfandm.persiandatepicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MyActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MaterialDatePicker.Builder.dateRangePicker().build().show(supportFragmentManager, null)
    }
}