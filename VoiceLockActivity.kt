package com.javed.ai

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class VoiceLockActivity : AppCompatActivity() {

    private lateinit var devicePolicyManager: DevicePolicyManager
    private lateinit var componentName: ComponentName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        devicePolicyManager = getSystemService(Context.DEVICE_POLICY_MANAGER) as DevicePolicyManager
        componentName = ComponentName(this, MyAdminReceiver::class.java)

        // चेक करेगा कि एडमिन परमिशन है या नहीं, फिर फोन लॉक कर देगा
        if (devicePolicyManager.isAdminActive(componentName)) {
            devicePolicyManager.lockNow()
        } else {
            // अगर परमिशन नहीं होगी तो यह सेटिंग पेज पर ले जाएगा
            val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
                putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName)
                putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "जावेद को फोन लॉक करने की अनुमति चाहिए")
            }
            startActivity(intent)
        }
        finish()
    }
}
