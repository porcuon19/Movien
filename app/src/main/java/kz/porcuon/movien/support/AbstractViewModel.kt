package kz.porcuon.movien.support

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.plus
import org.koin.core.KoinComponent

abstract class AbstractViewModel : ViewModel(), KoinComponent {

    protected var job = Job()

    protected val scope = CoroutineScope(Dispatchers.IO) + job

    override fun onCleared() {
        job.cancel()
    }
}