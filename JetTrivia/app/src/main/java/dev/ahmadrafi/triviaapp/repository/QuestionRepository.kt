package dev.ahmadrafi.triviaapp.repository

import android.util.Log
import dev.ahmadrafi.triviaapp.data.DataOrException
import dev.ahmadrafi.triviaapp.model.QuestionItem
import dev.ahmadrafi.triviaapp.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi
) {
    private val dataOrException =
        DataOrException<ArrayList<QuestionItem>,
                Boolean,
                Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, java.lang.Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        }catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("Exc", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")

        }
        return dataOrException
    }



}