package kz.porcuon.movien.flow.registration

import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import kotlinx.android.synthetic.main.fragment_registration.*
import kz.porcuon.movien.R
import kz.porcuon.movien.support.AbstractFragment

private const val URL = "https://www.themoviedb.org/account/signup"

class RegistrationFragment : AbstractFragment() {

    override val layoutId = R.layout.fragment_registration

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        webView.loadUrl(URL)
    }

    override fun onDestroyView() {
        webView?.destroy()
        super.onDestroyView()
    }

    private fun setupUI() {
        CookieManager.getInstance().acceptThirdPartyCookies(webView)
        webView.settings.apply {
            domStorageEnabled = true
            builtInZoomControls = false
            javaScriptEnabled = true
            cacheMode = WebSettings.LOAD_NO_CACHE
        }
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress == 100) {
                    pbPageLoad.visibility = View.GONE
                    webView.visibility = View.VISIBLE
                } else {
                    pbPageLoad.progress = newProgress
                }
            }
        }
    }
}