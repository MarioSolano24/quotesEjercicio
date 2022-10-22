package edu.itvo.ejercicioquots.presentation.view

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import edu.itvo.ejercicioquots.R
import edu.itvo.ejercicioquots.databinding.ActivityNavDraBinding

class Nav_Dra_Activity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityNavDraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavDraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        val contexto = this
        with(binding){
            setSupportActionBar(toolbar)
            drawer = drawerLayout
            toggle = ActionBarDrawerToggle(contexto, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
            //toggle = addActionBarDrawer(toolbar)
            drawer.addDrawerListener(toggle)

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeButtonEnabled(true)

            val navigationView: NavigationView = findViewById(R.id.quoetesnav_dra)
            navigationView.setNavigationItemSelectedListener(contexto)
        }
    }

    fun addActionBarDrawer(toolbar: Toolbar): ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.add_item -> Toast.makeText(this, "Agregar Citas", Toast.LENGTH_SHORT).show()
            R.id.toshow_item -> Toast.makeText(this, "Mostrar Cita Random", Toast.LENGTH_SHORT).show()
            R.id.yospecify_item -> Toast.makeText(this, "Buscar Cita", Toast.LENGTH_SHORT).show()
            R.id.ready_item -> Toast.makeText(this, "Lista de Citas", Toast.LENGTH_SHORT).show()
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}