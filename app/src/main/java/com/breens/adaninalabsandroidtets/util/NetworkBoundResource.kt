package com.breens.adaninalabsandroidtets.util

import kotlinx.coroutines.flow.*


/**
 *The type arguments are to make this function work with different types of date(no hardcoding)
 *(1)"query" argument is used to get data from the db
 * (2)"fetch" argument is used to fetch new data from our API
 * (3)"saveFetchResult" argument stores the API response to the db
 * (4)"shouldFetch" argument gauges if the data in the db is old and we should get new data from -
 * our api
 * The flow block will start executing when we start collecting from it
 * */
inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow {
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(Resource.Loading(data))

        try {
            saveFetchResult(fetch())
            query().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            query().map { Resource.Error(throwable, it) }
        }
    } else {
        query().map { Resource.Success(it) }
    }
    emitAll(flow)
}