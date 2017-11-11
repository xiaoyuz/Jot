package xiaoyuz.com.jot.engine

import android.app.Application
import android.os.Environment

class JotApplication : Application() {

    companion object {
        val BASE_PIC_PATH = Environment.getExternalStorageDirectory().path + "/ZJot"
    }

    override fun onCreate() {
        super.onCreate()
    }
}