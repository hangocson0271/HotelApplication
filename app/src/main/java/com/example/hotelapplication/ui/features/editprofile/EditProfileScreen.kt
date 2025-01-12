package com.example.hotelapplication.ui.features.editprofile

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R
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
fun EditProfileScreen(focusManager: FocusManager) {
    Header(stringResource(R.string.txt_edit_profile))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var visibleEdit by remember{mutableStateOf(true)}
        UserInfoInput(label = stringResource(R.string.txt_username),
            textInput = stringResource(R.string.enter_username),
            KeyBoardChoose.TEXT){
            visibleEdit = false
        }
        DatePickerFieldToModal{
            visibleEdit = false
        }
        UserInfoInput(label = stringResource(R.string.txt_phone),
            textInput = stringResource(R.string.enter_phonenumber),
            KeyBoardChoose.PHONE){
            visibleEdit = false
        }
        UserInfoInput(label = stringResource(R.string.txt_email),
            textInput = stringResource(R.string.enter_email),
            KeyBoardChoose.MAIL){
            visibleEdit = false
        }
        AllButtonEdit(
            focusManager,
            visibleEdit,
            onClickEdit = {visibleEdit = false}
        ){
            visibleEdit = true
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(title: String) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        }
    )
}

@Composable
fun UserInfoInput(label: String,
                  textInput: String,
                  keyType: KeyBoardChoose,
                  onGetFocus:() -> Unit) {
    val focusRequester = remember{ FocusRequester() }
    var inputString by remember{mutableStateOf("")}
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
            .onFocusChanged{
                if(it.isFocused) {
                    onGetFocus()
                }
            },
        value = inputString,
        onValueChange = {inputString = it },
        label = {Text(text = label,color = Color.Gray)},
        placeholder = {Text(textInput)},
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyBoardUse
        ))
}

@Composable
fun DatePickerFieldToModal(modifier: Modifier = Modifier,
                           onGetFocus:() -> Unit) {
    var selectedDate by remember{mutableStateOf<Long?>(null)}
    var showModal by remember{mutableStateOf(false)}

    OutlinedTextField(
        value = selectedDate?.let{convertMillisToDate(it)}?:"",
        onValueChange = { },
        label = {Text(stringResource(R.string.txt_dob))},
        placeholder = {Text(stringResource(R.string.txt_format_dob))},
        trailingIcon = {
            Icon(Icons.Default.DateRange,contentDescription = stringResource(R.string.select_date))
        },
        modifier = modifier
            .fillMaxWidth()
            .pointerInput(selectedDate){
                awaitEachGesture{
                    awaitFirstDown(pass = PointerEventPass.Initial)
                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                    if(upEvent != null) {
                        showModal = true
                    }
                } }
            .onFocusChanged{
                if(it.isFocused) {
                    onGetFocus()
                }
            }
    )

    if(showModal) {
        DatePickerModal(
            onDateSelected = {selectedDate = it },
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
    Row(Modifier
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
            Icon(getIconChoose, "")
        }
    }
}