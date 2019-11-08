package kz.porcuon.movien

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import kz.porcuon.data.isSessionIdPresent
import kz.porcuon.movien.login.LoginFragmentDirections

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isSessionIdPresent()) {
            val directions = LoginFragmentDirections.actionLoginFragmentToMoviesFragment()
            Navigation.findNavController(this, R.id.navHostFragment).navigate(directions)
        }
    }
}
