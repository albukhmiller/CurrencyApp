package bukhmiller.alex.currencyapp.presentations.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import bukhmiller.alex.currencyapp.R
import android.content.Intent
import android.os.Handler


class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)


        Handler().postDelayed({
            val mainIntent = Intent(this@LaunchActivity, MainActivity::class.java)
            this@LaunchActivity.startActivity(mainIntent)
            this@LaunchActivity.finish()
        }, 1500)
    }
}
