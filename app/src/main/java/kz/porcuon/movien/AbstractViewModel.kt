package kz.porcuon.movien

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class AbstractViewModel : ViewModel() {
    protected open val scope = CoroutineScope(Dispatchers.IO)
}