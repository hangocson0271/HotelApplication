package com.example.hotelapplication.ui.features.editprofile

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hotelapplication.R
import com.example.hotelapplication.extentions.hiltViewModel
import com.example.hotelapplication.ui.commonComponents.Texts.HeaderLabelScreen
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

enum class KeyBoardChoose{
    TEXT,
    PHONE,
    MAIL
}
enum class IconChoose{
    EDIT,
    CHECK,
    CLOSE
}

@Composable
fun EditProfileScreen(focusManager: FocusManager = LocalFocusManager.current
                      ,navController: NavController
) {
    val viewModel = hiltViewModel<EditProfileScreenViewModel>()
    val editProfileUiState by viewModel.editProfileUiState.collectAsState()
    var userNameChange by remember { mutableStateOf("") }
    var dateOfBirthChange by remember { mutableStateOf("") }
    var phoneChange by remember { mutableStateOf("") }
    var emailChange by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        focusManager.clearFocus()
        viewModel.getUserById()
    }
    SideEffect {
        userNameChange = editProfileUiState.userName
        dateOfBirthChange = editProfileUiState.dateOfBirth
        phoneChange = editProfileUiState.phone
        emailChange = editProfileUiState.email
    }
    HeaderLabelScreen(stringResource(R.string.txt_edit_profile), navController)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var visibleEdit by remember{mutableStateOf(true)}
        UserInfoInput(
            value = editProfileUiState.userName,
            textInput = stringResource(R.string.enter_username),
            KeyBoardChoose.TEXT,
            onChangeValue = {
                viewModel.setUserName(it)
                userNameChange = it
            }
        ){
            visibleEdit = false
        }
        DatePickerFieldToModal(
            dateOfBirth = editProfileUiState.dateOfBirth,
            onDateSelected = {
                viewModel.setDateOfBirth(convertMillisToDate(it?:0))
                dateOfBirthChange = convertMillisToDate(it?:0)
            }
        ){
            visibleEdit = false
        }
        UserInfoInput(
            value = editProfileUiState.phone,
            textInput = stringResource(R.string.enter_phonenumber),
            KeyBoardChoose.PHONE,
            onChangeValue = {
                viewModel.setPhone(it)
                phoneChange = it
            }
        ){
            visibleEdit = false
        }
        UserInfoInput(
            value = editProfileUiState.email,
            textInput = stringResource(R.string.enter_email),
            KeyBoardChoose.MAIL,
            onChangeValue = {
                viewModel.setEmail(it)
                emailChange = it
            }
        ){
            visibleEdit = false
        }
        AllButtonEdit(
            focusManager,
            visibleEdit,
            onClickEdit = {
                visibleEdit = false
            }
        ){
            visibleEdit = true
            viewModel.updateUserData(userNameChange, dateOfBirthChange, phoneChange, emailChange)
        }
        LanguageSelection()
    }
}
@Composable
fun LanguageSelection() {
    val context = LocalContext.current
    val viewModel = hiltViewModel<EditProfileScreenViewModel>()

    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Button(onClick = {
            Log.i("TAG" , "set language to English")
            viewModel.setAppLanguage(context, "en")
        }) {
            Text(stringResource(id = R.string.english))
        }
        Button(onClick = {
            Log.i("TAG" , "set language to Vietnamese")
            viewModel.setAppLanguage(context, "vi")
        }) {
            Text(stringResource(id = R.string.vietnamese))
        }
    }
}

@Composable
fun UserInfoInput(
    value: String,
    textInput: String,
    keyType: KeyBoardChoose,
    onChangeValue: (value: String) -> Unit,
    onGetFocus:() -> Unit) {
    val focusRequester = remember{ FocusRequester() }
    val keyBoardUse = when(keyType){
        KeyBoardChoose.TEXT-> KeyboardType.Text
        KeyBoardChoose.PHONE-> KeyboardType.Phone
        KeyBoardChoose.MAIL-> KeyboardType.Email
    }
    TextField(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .onFocusChanged {
                if (it.isFocused) {
                    onGetFocus()
                }
            },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(id = android.R.color.transparent),
            unfocusedContainerColor = colorResource(id = android.R.color.transparent),
            cursorColor = colorResource(id = R.color.main_color),
            focusedIndicatorColor = colorResource(id = R.color.main_color),
            unfocusedIndicatorColor = colorResource(id = R.color.gray)
        ),
        value = value,
        onValueChange = {onChangeValue(it) },
        placeholder = {Text(textInput)},
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyBoardUse
        ))
}

@Composable
fun DatePickerFieldToModal(modifier: Modifier = Modifier,
                           onDateSelected: (Long?) -> Unit,
                           dateOfBirth: String,
                           onGetFocus:() -> Unit) {
    var selectedDate by remember{mutableStateOf<Long?>(null)}
    var showModal by remember{mutableStateOf(false)}

    OutlinedTextField(
        value = selectedDate?.let{convertMillisToDate(it)}?:dateOfBirth,
        onValueChange = { },
        label = {Text(stringResource(R.string.txt_dob))},
        placeholder = {Text(stringResource(R.string.txt_format_dob))},
        trailingIcon = {
            Icon(Icons.Default.DateRange,contentDescription = stringResource(R.string.select_date))
        },
        modifier = modifier
            .fillMaxWidth()
            .pointerInput(selectedDate) {
                awaitEachGesture {
                    awaitFirstDown(pass = PointerEventPass.Initial)
                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                    if (upEvent != null) {
                        showModal = true
                    }
                }
            }
            .onFocusChanged {
                if (it.isFocused) {
                    onGetFocus()
                }
            }
    )

    if(showModal) {
        DatePickerModal(
            onDateSelected = {
                selectedDate = it
                onDateSelected(selectedDate) },
            onDismiss = {showModal = false}
        )
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }){
                Text(stringResource(R.string.txt_ok))
            } },
        dismissButton = {
            TextButton(onClick = onDismiss){
                Text(stringResource(R.string.txt_cancel))
            }
        }
    ){
        DatePicker(state = datePickerState)
    }
}

@Composable
fun AllButtonEdit(focusManager: FocusManager,
                  visibleEdit: Boolean,
                  onClickEdit:() -> Unit,
                  onClickCheckAndClose:() -> Unit) {
    Row(
        Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        ButtonFade(!visibleEdit, IconChoose.CLOSE){
            onClickCheckAndClose()
            focusManager.clearFocus()
        }
        Spacer(modifier = Modifier.width(50.dp))
        ButtonFade(visibleEdit, IconChoose.EDIT){
            onClickEdit()
            focusManager.clearFocus()
        }
        Spacer(modifier = Modifier.width(50.dp))
        ButtonFade(!visibleEdit, IconChoose.CHECK){
            onClickCheckAndClose()
            focusManager.clearFocus()
        }
    }
}

@Composable
fun ButtonFade(changeVisible: Boolean, iconChoose: IconChoose, onClick:() -> Unit) {
    val getIconChoose = when (iconChoose) {
        IconChoose.EDIT -> Icons.Filled.Edit
        IconChoose.CHECK -> Icons.Filled.Check
        IconChoose.CLOSE -> Icons.Filled.Close
    }
    AnimatedVisibility(
        visible = changeVisible,
        enter = fadeIn(
            initialAlpha = 0.3f
        ),
        exit = fadeOut()
    ) {
        ElevatedButton(onClick = {
            onClick()
        }) {
            Icon(
                getIconChoose,
                "",
                tint = colorResource(R.color.main_color)
            )
        }
    }
}
