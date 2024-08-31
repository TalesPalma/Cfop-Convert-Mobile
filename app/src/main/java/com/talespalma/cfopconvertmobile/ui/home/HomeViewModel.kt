package com.talespalma.cfopconvertmobile.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.talespalma.cfopconvertmobile.database.AppDatabase
import com.talespalma.cfopconvertmobile.database.entitys.ICfopEntity
import com.talespalma.cfopconvertmobile.models.CfopDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeScreenState(
    var categorySelected: Int = 1,
    val cfops: MutableList<CfopDTO> = emptyList<CfopDTO>().toMutableList(),
    var expanded: Boolean = false,
    var cfopSelected: String = "",
    var cfopConvetido: String = ""
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val db: AppDatabase?
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState>
        get() = _uiState.asStateFlow()

    fun selectDataBase() {
        viewModelScope.launch {
            when (uiState.value.categorySelected) {
                1 -> loadCfops(db?.cfopConsumoDao()?.getAll())
                2 -> loadCfops(db?.cfopRevendaDao()?.getAll())
                3 -> loadCfops(db?.cfopIndustrializacaoDao()?.getAll())
            }
        }
    }


    fun updateCategory(category: Int) {
        _uiState.value = _uiState.value.copy(categorySelected = category)
        Log.i(
            "HomeViewModel",
            "updateCategory: ${_uiState.value.categorySelected}"
        )
    }

    fun updateExpanded(expanded: Boolean) {
        _uiState.value = _uiState.value.copy(expanded = expanded)
        Log.i(
            "HomeViewModel",
            "updateExpanded: ${_uiState.value.expanded}"
        )
    }

    private fun updateViewCfops() {
        if(uiState.value.cfops.isNotEmpty()) {
            updateCfopSelected(uiState.value.cfops[0].code)
            updateCfopConvetido(uiState.value.cfops[0].covertindCode)
        }
    }

    fun updateCfopSelected(cfopSelected: String) {
        _uiState.value = _uiState.value.copy(cfopSelected = cfopSelected)
        Log.i(
            "HomeViewModel",
            "updateCfopSelected: ${_uiState.value.cfopSelected}"
        )
    }

    fun updateCfopConvetido(cfopConvetido: String) {
        _uiState.value = _uiState.value.copy(cfopConvetido = cfopConvetido)
        Log.i(
            "HomeViewModel",
            "updateCfopConvetido: ${_uiState.value.cfopConvetido}"
        )
    }

    private fun loadCfops(cfopsFlow: Flow<List<ICfopEntity>>?) {
        viewModelScope.launch {
            cfopsFlow?.collect { cfops ->
                _uiState.value = _uiState.value.copy(
                    cfops = cfops.map { it.converterToDto() }.toMutableList()
                )
            }
        }
        updateViewCfops()
    }


}