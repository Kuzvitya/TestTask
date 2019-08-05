package com.example.testtask.base.network.gsonadapters

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.DateTimeParseException
import java.io.IOException


class LocalDateAdapter: TypeAdapter<LocalDate>() {

    private val formatters = listOf(
        DateTimeFormatter.ISO_LOCAL_DATE,
        DateTimeFormatter.ofPattern("yyyy.MM.dd"),
        DateTimeFormatter.ofPattern("dd-MM-yyyy"),
        DateTimeFormatter.ofPattern("dd.MM.yyyy")
    )

    @Throws(IOException::class)
    override fun write(out: JsonWriter, value: LocalDate?) {
        if (value == null) {
            out.nullValue()
            return
        }
        out.value(DateTimeFormatter.ISO_LOCAL_DATE.format(value))
    }

    @Throws(IOException::class)
    override fun read(input: JsonReader): LocalDate? {
        if (input.peek() == JsonToken.NULL) {
            input.nextNull()
            return null
        }
        val dateString = input.nextString()
        formatters.forEach {  formatter ->
            val date: LocalDate
            try {
                date = LocalDate.parse(dateString, formatter)
                return date
            } catch (ex: DateTimeParseException) {
            }
        }
        return null
    }
}