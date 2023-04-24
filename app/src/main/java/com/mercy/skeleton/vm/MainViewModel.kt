package com.mercy.skeleton.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercy.skeleton.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val repository: Repository,
) : ViewModel() {
  fun getDog() {
    viewModelScope.launch {
      val response = repository.getDog()
      Log.d("!! ", "$response")
    }
  }
}
