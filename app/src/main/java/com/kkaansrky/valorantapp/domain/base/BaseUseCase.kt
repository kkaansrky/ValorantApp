package com.kkaansrky.valorantapp.domain.base

import kotlinx.coroutines.flow.Flow

interface IParams

interface BaseUseCase<T : Any, R : Any> {
    suspend operator fun invoke(param: T): Flow<R>
}