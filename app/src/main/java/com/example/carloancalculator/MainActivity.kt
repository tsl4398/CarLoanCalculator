package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val buttonReset = findViewById<Button>(R.id.buttonReset)

        buttonCalculate.setOnClickListener {
            calculate(it)
        }

        buttonReset.setOnClickListener {
            resetApp(it)
        }
    }

    private fun calculate(viewThatIsClicked: View)
    {
        val editTextCarPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val editTextDownPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val editTextLoanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val editTextInterestRate = findViewById<EditText>(R.id.editTextInterestRate)

        val textViewLoan = findViewById<TextView>(R.id.textViewLoan)
        val textViewInterest = findViewById<TextView>(R.id.textViewInterest)
        val textViewMonthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        val TextCarPrice = editTextCarPrice.text.toString()
        val TextDownPayment = editTextDownPayment.text.toString()
        val TextLoanPeriod = editTextLoanPeriod.text.toString()
        val TextInterestRate = editTextInterestRate.text.toString()

        if (TextCarPrice.length > 0 && TextDownPayment.length > 0 && TextLoanPeriod.length > 0 && TextInterestRate.length > 0)
        {
            var interestRate = editTextInterestRate.text.toString().toDouble() / 100

            var carLoan =
                editTextCarPrice.text.toString().toDouble() - editTextDownPayment.text.toString().toDouble()
            var interest = carLoan * interestRate * editTextLoanPeriod.text.toString().toDouble()

            var carLoanInterestSum = carLoan + interest

            var monthlyRepayment = carLoanInterestSum / editTextLoanPeriod.text.toString().toDouble() / 12

            textViewLoan.text = "Loan : RM " + String.format("%.2f", carLoan)
            textViewInterest.text = "Interest : RM " + String.format("%.2f", interest)
            textViewMonthlyRepayment.text = "Monthly Repayment : RM " + String.format("%.2f", monthlyRepayment)

            Toast.makeText(this, "Calculated!", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(this, "One or more fields are empty!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun resetApp (viewThatIsClicked: View)
    {
        val editTextCarPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val editTextDownPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val editTextLoanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val editTextInterestRate = findViewById<EditText>(R.id.editTextInterestRate)

        val textViewLoan = findViewById<TextView>(R.id.textViewLoan)
        val textViewInterest = findViewById<TextView>(R.id.textViewInterest)
        val textViewMonthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextLoanPeriod.text.clear()
        editTextInterestRate.text.clear()

        textViewLoan.text = "Loan :"
        textViewInterest.text = "Interest :"
        textViewMonthlyRepayment.text = "Monthly Repayment :"
    }
}
