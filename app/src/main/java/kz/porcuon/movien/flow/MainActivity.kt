package kz.porcuon.movien.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import kz.porcuon.data.sources.preferences.isSessionIdPresent
import kz.porcuon.movien.R
import kz.porcuon.movien.flow.login.LoginFragmentDirections

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isSessionIdPresent()) {
            val directions = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
            Navigation.findNavController(this, R.id.navHostFragment).navigate(directions)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.navHostFragment).navigateUp()
    }
}
