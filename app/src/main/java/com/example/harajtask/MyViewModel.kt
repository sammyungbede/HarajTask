package com.example.harajtask

import android.content.Context
import android.util.Log.e
import androidx.lifecycle.ViewModel
import java.io.IOException
import java.io.InputStream
import java.util.logging.Logger

class MyViewModel : ViewModel() {

   fun loadJSONFromAsset(context: Context): String? {
     var json: String? = null
     json = try {
       val inputStream: InputStream = context.assets.open("data.json")
       val size: Int = inputStream.available()
       val buffer = ByteArray(size)
       inputStream.read(buffer)
       inputStream.close()
       String(buffer, charset("UTF-8"))
     } catch (ex: IOException) {
         ex.printStackTrace()
       return null
     }
     return json
   }


//  object JsonReader {

    fun getJson(path: String, context: Context): String {
      return try {
        val jsonStream: InputStream = context.assets.open("$path")
        String(jsonStream.readBytes())
      } catch (exception: IOException) {
        exception.printStackTrace()
        throw exception
      }
    }

//  }

}