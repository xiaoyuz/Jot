package xiaoyuz.com.jot.activity

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import xiaoyuz.com.jot.R
import xiaoyuz.com.jot.contract.presenter.MainPresenter
import xiaoyuz.com.jot.contract.view.MainFragment
import xiaoyuz.com.jot.util.addFragment
import xiaoyuz.com.jot.util.checkSDExists
import xiaoyuz.com.jot.util.createFolder
import xiaoyuz.com.jot.util.folderExists

class MainActivity : AppCompatActivity() {

    private lateinit var mMainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        checkPicStorage()

        fab.setOnClickListener { view ->
            // Jump to camera.
        }

        val mainFragment = MainFragment().also { addFragment(it) }
        mMainPresenter = MainPresenter(mainFragment)
    }

    private fun checkPicStorage() {
        // Check sd is exist.
        if (checkSDExists() && !folderExists()) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
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

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
        when(requestCode) {
            1 -> if (grantResults[0]== PackageManager.PERMISSION_GRANTED) {
                createFolder()
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        super.onKeyDown(keyCode, event)
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (supportFragmentManager.backStackEntryCount == 1) {
                finish()
            }
            return supportFragmentManager.backStackEntryCount >= 1
        }
        return false
    }
}
