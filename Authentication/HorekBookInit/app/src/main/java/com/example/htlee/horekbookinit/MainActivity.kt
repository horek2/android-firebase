package com.example.htlee.horekbookinit

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth;

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var auth: FirebaseAuth? = null
    var authListener: FirebaseAuth.AuthStateListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        authListener = FirebaseAuth.AuthStateListener { FirebaseAuth ->
            val user = FirebaseAuth.currentUser
            if (user != null) {
                // 로그인

            } else {

            }
        }
        //setSupportActionBar(toolbar)

        //fab.setOnClickListener { view ->
        //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //        .setAction("Action", null).show()
        // }
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

    override fun onStart() {
        super.onStart()
        auth?.addAuthStateListener(authListener!!)
    }

    override fun onPause() {
        super.onPause()
        auth?.removeAuthStateListener(authListener!!)
    }
}