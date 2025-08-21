package com.toolrental

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import kotlinx.android.synthetic.main.activity_payment.*
import org.json.JSONObject

class PaymentActivity : AppCompatActivity(), PaymentResultListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        Checkout.preload(applicationContext)

        payButton.setOnClickListener {
            startPayment()
        }
    }

    private fun startPayment() {
        val checkout = Checkout()
        checkout.setKeyID("YOUR_KEY_ID") // Replace with your key ID

        try {
            val options = JSONObject()
            options.put("name", "Tool Rental")
            options.put("description", "Tool Rental Payment")
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("theme.color", "#3399cc")
            options.put("currency", "INR")
            options.put("amount", "10000") // Amount in paise
            options.put("prefill.email", "test@example.com")
            options.put("prefill.contact", "9876543210")
            checkout.open(this, options)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(razorpayPaymentId: String?) {
        // Handle payment success
    }

    override fun onPaymentError(code: Int, response: String?) {
        // Handle payment failure
    }
}
