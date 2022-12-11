package com.asknilesh.jettrivia.utils

import android.os.Bundle
import androidx.navigation.NavType
import com.asknilesh.jettrivia.data.QuestionData
import com.google.gson.Gson

class QuestionParamType : NavType<QuestionData>(isNullableAllowed = false) {
  override fun get(bundle: Bundle, key: String): QuestionData? {
    return bundle.getParcelable(key)
  }

  override fun parseValue(value: String): QuestionData {
    return Gson().fromJson(value, QuestionData::class.java)
  }

  override fun put(bundle: Bundle, key: String, value: QuestionData) {
    bundle.putParcelable(key, value)
  }
}
