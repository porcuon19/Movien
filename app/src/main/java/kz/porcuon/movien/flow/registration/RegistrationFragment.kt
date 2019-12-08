package kz.porcuon.movien.flow.registration

import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import kotlinx.android.synthetic.main.fragment_registration.*
import kz.porcuon.movien.R
import kz.porcuon.movien.support.AbstractFragment

class RegistrationFragment : AbstractFragment() {

    override val layoutId = R.layout.fragment_registration

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView.loadUrl("https://www.themoviedb.org/account/signup")
        CookieManager.getInstance().acceptThirdPartyCookies(webView)
    }
}