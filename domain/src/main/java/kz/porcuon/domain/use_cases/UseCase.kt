package kz.porcuon.domain.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kz.porcuon.domain.functional.Either

abstract class UseCase<out Type, in Params> where Type : Any {

    /**
     * Runs the actual logic of the use case.
     */
    abstract suspend fun run(params: Params): Either<Throwable, Type>

    suspend operator fun invoke(params: Params, onSuccess: (Type) -> Unit, onFailure: (Throwable) -> Unit) {
        val result = run(params)
        coroutineScope {
            launch(Dispatchers.Main) {
                result.fold(
                    failed = { onFailure(it) },
                    succeeded = { onSuccess(it) }
                )
            }
        }
    }

    /**
     * Placeholder for a use case that doesn't need any input parameters.
     */
    object None
}