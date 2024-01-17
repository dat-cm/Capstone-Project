package com.example.capstoneproject.preferences

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import kotlinx.coroutines.launch

// PreferencesViewModel.kt - ViewModel for managing preferences UI
class PreferencesViewModel(private val capstoneViewModel: CapstoneViewModel) : ViewModel() {
    fun saveUserPreferences(
        user: User?,
        userPref: UserPreferences?,
        userClassification: String,
        userFoodPreferencesList: List<String>,
        userBudget: Double,
    ) {
        viewModelScope.launch {
            if (user != null) {
                if (userPref != null) {
                    capstoneViewModel.updateAllUserPreferences(
                        UserPreferences(
                            user.userId,
                            userClassification,
                            userFoodPreferencesList,
                            userBudget,
                        ),
                    )
                } else {
                    capstoneViewModel.insertUserPref(
                        UserPreferences(
                            user.userId,
                            userClassification,
                            userFoodPreferencesList,
                            userBudget,
                        ),
                    )
                    if (!user.userPref) {
                        capstoneViewModel.updateUserPref(true)
                    }
                }
            }
        }
    }
}
