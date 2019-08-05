package com.example.testtask.base.network.converter

/**
 * Интерфейс фабрики конвероров
 */
interface ConverterFactory {

    /**
     * Получить конвертер
     * @param clazzFrom класс, который будем конвертировать
     * @param clazzTo   класс, в который будем конвертировать
     *
     * @return  конвертер
     */
    fun <T, S> getConverter(clazzFrom: Class<T>, clazzTo: Class<S>): OneWayConverter<T, S>
}