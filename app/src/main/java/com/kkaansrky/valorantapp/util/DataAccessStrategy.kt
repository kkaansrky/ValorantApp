package com.kkaansrky.valorantapp.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.kkaansrky.valorantapp.util.Resource

fun <T> performNetworkOperation(call: suspend () -> Resource<T>): Flow<Resource<T>> =  flow {
    emit(Resource.loading())
    val networkCall = call.invoke()

    if (networkCall.status == Resource.Status.SUCCESS) {
        val data = networkCall.data!!
        emit(Resource.success(data))
    } else if (networkCall.status == Resource.Status.ERROR) {
        emit(
            Resource.error(
                "Error: ${networkCall.message}"
            )
        )
    }
}