package dev.hmyh.easymobile

import android.app.Application
import dev.hmyh.easymobile.data.models.EasyMobileModelImpl
import org.opencv.android.BaseLoaderCallback

class EasyMobileApp: Application() {

    override fun onCreate() {
        super.onCreate()

        EasyMobileModelImpl.init(applicationContext)
    }
}