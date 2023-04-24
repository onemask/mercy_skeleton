package com.mercy.skeleton.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercy.skeleton.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val repository: Repository,
) : ViewModel() {

  private val _dogImage = MutableStateFlow<String?>(null)
  val dogImage: StateFlow<String?> = _dogImage.asStateFlow()
  private fun getDogImage() {
    viewModelScope.launch {
      _dogImage.update {
        Log.d("!!!", "getDogImage: ${_dogImage.value}")
        repository.getDog().message
      }
    }
  }

  init {
    getDogImage()
  }
}
