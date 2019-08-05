package com.example.testtask.base.network.converter

/**
 * Интерфейс конвертера из класса T, в класс S
 */
abstract class OneWayConverter<T, S> {

    /**
     * Сконвертировать T в S
     * @param source    исходная модель
     *
     * @return  сконвертированная модель
     */
    abstract fun convert(source: T?): S?

    /**
     * То же самое, что и [convert], но для списков
     * @param source    список исходных моделей
     *
     * @return  список сконвертированных моделей
     */
    fun convert(source: List<T?>): List<S> {
        val result = mutableListOf<S>()
        source.forEach { item ->
            convert(item)?.let { result.add(it) }
        }
        return result
    }
}