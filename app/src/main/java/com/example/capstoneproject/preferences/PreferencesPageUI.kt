package com.example.capstoneproject.preferences

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.ui.theme.PartyPink
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

class PreferencesPageUI {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BuildPreferencesUI(navController: NavHostController,
                           capstoneViewModel: CapstoneViewModel,
                           user: User?,
                           userPref: UserPreferences?) {
        var userClassification by remember{mutableStateOf("")}
        var userFoodPreferences = remember { mutableStateListOf("") }
        var userBudget by remember { mutableIntStateOf(0) }

        Scaffold(
            topBar = {
                Surface(
                    shadowElevation = 2.dp,
                ) {
                    TopAppBar(title = { Text("Preferences") },
                        navigationIcon = {
                            IconButton(onClick = { navController.navigate(Routes.Selection.route) }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close",
                                    tint = PartyPink
                                )
                            }
                        }
                    )
                }
            }
        ) { //to do list view from firebase
                paddingValue ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = paddingValue.calculateTopPadding() + 8.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
            ) {
                //halal/non-halal/...
                UserClassificationChoiceTextUI()
                userClassification = selectUserClassification(userPref?.userClassification ?: "")
                if(userClassification != ""){
                    FoodPreferenceChoiceTextUI()
                    when(userClassification ){
                        "Halal", "Non-Halal", "No Preference" ->
                            userFoodPreferences = multiSelectForHalalOrNonHalal(userPref?.userFoodClassification ?: emptyList())

                        "Vegan/Vegetarian" ->
                                userFoodPreferences = multiSelectForVegetarianOrVegan(userPref?.userFoodClassification?: emptyList())
                    }
                    if(userFoodPreferences.isNotEmpty()){
                        Row{
                            Text("Budget:",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(end = 16.dp))
                            //if(userPref != null){
                            //    userBudget = userPref.userBudget.toInt()
                            //}
                            Text("$${userBudget}",
                                fontSize = 20.sp)
                        }
                           userBudget = budgetSlider(userPref?.userBudget?.toInt() ?: 0)
                    }
                }

                //save button
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
                    colors = ButtonDefaults.buttonColors(PartyPink),
                    onClick = {
                        var userFoodPreferenceslist: ArrayList<String>
                        capstoneViewModel.viewModelScope.launch {
                           userFoodPreferenceslist = addToListForInsert(userFoodPreferences)
                            if (user != null) {
                                if(userPref != null){
                                    capstoneViewModel.updateAllUserPreferences(
                                        UserPreferences(
                                            user.userId,
                                            userClassification,
                                            userFoodPreferenceslist,
                                            userBudget.toDouble()
                                        ))
                                } else {
                                    capstoneViewModel.insertUserPref(
                                        UserPreferences(
                                            user.userId,
                                            userClassification,
                                            userFoodPreferenceslist,
                                            userBudget.toDouble()
                                        )
                                    )
                                    if (!user.userPref) {
                                        capstoneViewModel.updateUserPref(true)
                                    }
                                }
                            }
                        }
                        navController.navigate(Routes.Selection.route)
                         }) {
                    Text("Save")
                }
            }
        }
    }

    @Composable
    fun UserClassificationChoiceTextUI() {
        Text(
            "Are you ...",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text("(Choose one only)")
    }

    @Composable
    fun FoodPreferenceChoiceTextUI(){
        Text(
            "What type of food do you like?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
        Text("(Multiple choices allowed)")
    }

    private fun addToListForInsert(list: SnapshotStateList<String>) : ArrayList<String>{
        val itemList: ArrayList<String> = ArrayList()
        itemList.addAll(list)
        return itemList
    }

    @Composable
    fun selectUserClassification(userPref: String) : String {
        val selectedOption: MutableState<String> = if(userPref != "") {
            remember { mutableStateOf(userPref)}
        }else{
            remember { mutableStateOf("")}
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SingleSelectItem("Halal", selectedOption) { selectedOption.value = it }
            SingleSelectItem("Non-Halal", selectedOption) { selectedOption.value = it }
            SingleSelectItem("Vegan/Vegetarian", selectedOption) { selectedOption.value = it }
            SingleSelectItem("No Preference", selectedOption) { selectedOption.value = it }
        }
        Log.i("single", selectedOption.value)

        return selectedOption.value
    }

    @Composable
    fun SingleSelectItem(
        text: String,
        selectedOption: MutableState<String>,
        onSelected: (String) -> Unit
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onSelected(text) }
        ) {
            RadioButton(
                colors = RadioButtonDefaults.colors(
                    selectedColor = PartyPink,
                ),
                selected = text == selectedOption.value,
                onClick = null // null disables manual clicking, rely on the clickable modifier
            )
            Text(
                text = text,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }

    @Composable
    fun multiSelectForHalalOrNonHalal(userFoodClassification: List<String>) : SnapshotStateList<String> {
        val options = listOf(
            "Meat",
            "Rice",
            "Dessert",
            "Noodles",
            "Seafood",
            "Fast food",
        )
        var selectedOptions: SnapshotStateList<String> = remember { mutableStateListOf() }
        if(userFoodClassification.isNotEmpty()) {
            selectedOptions = remember {
                convertToSnapshotStateList(userFoodClassification, options)
            }
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)) {
            options.forEach { option ->
                CheckboxItem(
                    text = option,
                    isChecked = selectedOptions.contains(option),
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selectedOptions.add(option)
                        } else {
                            selectedOptions.remove(option)
                        }
                    }
                )
            }
        }
        return selectedOptions
    }

    @Composable
    fun multiSelectForVegetarianOrVegan(userFoodClassification: List<String>) : SnapshotStateList<String> {
        val options = listOf(
            "Rice",
            "Soup",
            "Salad",
            "Dessert",
            "Noodles",
            "Fast food",
        )
        var selectedOptions: SnapshotStateList<String> = remember { mutableStateListOf() }
        if(userFoodClassification.isNotEmpty()) {
            selectedOptions = remember {
                convertToSnapshotStateList(userFoodClassification, options)
            }
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)) {
            options.forEach { option ->
                CheckboxItem(
                    text = option,
                    isChecked = selectedOptions.contains(option),
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selectedOptions.add(option)
                        } else {
                            selectedOptions.remove(option)
                        }
                    }
                )
            }
        }
        return selectedOptions
    }

    private fun convertToSnapshotStateList(arrayList: List<String>, checkList: List<String>): SnapshotStateList<String>{
        val snapshotStateList = SnapshotStateList<String>()

        for (item in arrayList) {
            for (items in checkList) {
                if (item == items)
                    snapshotStateList.add(item)
            }
        }

        return snapshotStateList
    }

    @Composable
    fun CheckboxItem(
        text: String,
        isChecked: Boolean,
        onCheckedChange: (Boolean) -> Unit
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onCheckedChange(!isChecked) }
        ) {
            Checkbox(
                colors= CheckboxDefaults.colors(
                    checkedColor = PartyPink
                ),
                checked = isChecked,
                onCheckedChange = null // null disables manual clicking, rely on the clickable modifier
            )
            Text(
                text = text,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }

    @Composable
    fun budgetSlider(userBudget: Int) : Int{
        val userBudgetCost: MutableState<Int> = if(userBudget != 0) {
            remember { mutableIntStateOf(userBudget) }
        }else{
            remember { mutableIntStateOf(0)}
        }
        Slider(
            value = userBudgetCost.value.toFloat(),
            onValueChange = {
                    newValue -> userBudgetCost.value = newValue.toInt()
            },
            valueRange = 0.00f..100.00f,
            steps = 100,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(48.dp)
        )
        return userBudgetCost.value
    }
}
