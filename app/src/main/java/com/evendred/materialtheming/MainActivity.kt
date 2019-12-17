package com.evendred.materialtheming

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        private const val COLORS_FRAGMENT_TAG = "colorsFragmentTag"
        private const val ATOMS_FRAGMENT_TAG = "atomsFragmentTag"
        private const val BLOCKS_FRAGMENT_TAG = "blocksFragmentTag"
        private const val BARS_FRAGMENT_TAG = "barsFragmentTag"
        private const val BUTTONS_FRAGMENT_TAG = "buttonsFragmentTag"
        private const val DIALOGS_FRAGMENT_TAG = "dialogsFragmentTag"
        private const val CONTROLS_FRAGMENT_TAG = "controlsFragmentTag"
        private const val FIELDS_FRAGMENT_TAG = "fieldsFragmentTag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerOpen)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        toolbar.setNavigationOnClickListener { drawerLayout.openDrawer(navigation) }
        navigation.setNavigationItemSelectedListener { onNavigationItemSelected(it) }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        navigation.checkedItem?.let { onNavigationItemSelected(it) }
    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean = true.also {
        drawerLayout.closeDrawer(navigation)
        item.isChecked = true
        when(item.itemId) {
            R.id.colors -> replaceFragment(R.string.navigationColors, COLORS_FRAGMENT_TAG) { ColorsFragment() }
            R.id.atoms -> replaceFragment(R.string.navigationAtoms, ATOMS_FRAGMENT_TAG) { AtomsFragment() }
            R.id.blocks -> replaceFragment(R.string.navigationBlock, BLOCKS_FRAGMENT_TAG) { BlocksFragment() }
            R.id.bars -> replaceFragment(R.string.navigationBars, BARS_FRAGMENT_TAG) { BarsFragment() }
            R.id.button -> replaceFragment(R.string.navigationButtons, BUTTONS_FRAGMENT_TAG) { ButtonsFragment() }
            R.id.dialogs -> replaceFragment(R.string.navigationDialogs, DIALOGS_FRAGMENT_TAG) { DialogsFragment() }
            R.id.controls -> replaceFragment(R.string.navigationControls, CONTROLS_FRAGMENT_TAG) { ControlsFragment() }
            R.id.fields -> replaceFragment(R.string.navigationFields, FIELDS_FRAGMENT_TAG) { FieldsFragment() }
        }
    }

    private fun <T: Fragment> replaceFragment(titleId: Int, tag: String, instance: () -> T) {
        title = getString(titleId)
        supportFragmentManager.apply {
            val fragment = findFragmentByTag(tag) ?: instance.invoke()
            beginTransaction().replace(R.id.fragment, fragment, tag).commit()
        }
    }
}
