package com.example.zadanie

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.zadanie.R.id.liczba1
import com.example.zadanie.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        var pierwsza = 0;
        var druga = 0;
        var wynik = 0;

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            findViewById<Button>(R.id.podajtxt).setOnClickListener() {
                findViewById<TextView>(R.id.textview1).text = findViewById<EditText>(R.id.text).text
            }
            findViewById<Button>(R.id.zatwierdztxt).setOnClickListener() {
                findViewById<TextView>(R.id.textview2).text =
                    findViewById<TextView>(R.id.textview2).text.toString() + findViewById<EditText>(R.id.text).toString()
            }
            findViewById<Button>(R.id.btnsumuj).setOnClickListener() {
                pierwsza = findViewById<TextInputEditText>(R.id.liczba1).text.toString().toInt()
                druga = findViewById<TextInputEditText>(R.id.numer2).text.toString().toInt()
                wynik = pierwsza + druga
                findViewById<TextView>(R.id.wynik).text =
                    pierwsza.toString() + "+" + druga.toString() + "=" + wynik.toString()

            }


        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}