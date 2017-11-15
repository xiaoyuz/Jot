package xiaoyuz.com.jot.util

import android.os.Environment
import xiaoyuz.com.jot.engine.JotApplication
import java.io.File

fun checkSDExists() = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED

/**
 * Only check first level folder.
 */
fun folderExists(path: String = "") = File(JotApplication.BASE_PIC_PATH + "/" + path).exists()

/**
 * Only create first level folder.
 */
fun createFolder(path: String = "") = File(JotApplication.BASE_PIC_PATH + "/" + path).mkdirs()

/**
 * Only show first level folders.
 */
fun listFolders() = listFiles()

/**
 * Only show second level files.
 */
fun listFiles(path: String = "") = File(JotApplication.BASE_PIC_PATH + "/" + path).listFiles().toList()