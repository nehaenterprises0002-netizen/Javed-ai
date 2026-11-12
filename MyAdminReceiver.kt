package com.javed.ai

import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent

class MyAdminReceiver : DeviceAdminReceiver() {
    override fun onEnabled(context: Context, intent: Intent) {
        super.onEnabled(context, intent)
        // जब परमिशन मिल जाएगी
    }

    override fun onDisabled(context: Context, intent: Intent) {
        super.onDisabled(context, intent)
        // जब परमिशन हटाई जाएगी
    }
}
