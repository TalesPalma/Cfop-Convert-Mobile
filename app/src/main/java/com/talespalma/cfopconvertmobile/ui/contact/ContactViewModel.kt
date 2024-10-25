package com.talespalma.cfopconvertmobile.ui.contact

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


data class  ContactInfos(
    val name: String = "",
    val email: String = "",
    val menssage: String = ""
)


@HiltViewModel
class ContactViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(ContactInfos())
    val uiState : StateFlow<ContactInfos>
        get() = _uiState.asStateFlow()

    fun updateName(newName: String){
        _uiState.value = _uiState.value.copy(name = newName)
    }

    fun updateEmail(newEmail: String){
        _uiState.value = _uiState.value.copy(email = newEmail)
    }

    fun updateMessage(newMessage: String){
        _uiState.value = _uiState.value.copy(menssage = newMessage)
    }

    fun sendEmailIntent() : Intent{
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // Apenas apps de e-mail receberão a intent
            putExtra(Intent.EXTRA_EMAIL, arrayOf(_uiState.value.email))
            putExtra(Intent.EXTRA_SUBJECT, "Contato pelo app")
            putExtra(Intent.EXTRA_TEXT, _uiState.value.menssage)
        }
        return Intent.createChooser(emailIntent, "Escolha um aplicativo de email:")
    }



}