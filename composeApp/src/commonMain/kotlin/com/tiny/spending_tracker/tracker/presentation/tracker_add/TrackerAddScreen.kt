package com.tiny.spending_tracker.tracker.presentation.tracker_add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tiny.spending_tracker.tracker.data.repository.Category
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun TrackerAddScreenRoot(viewModel: TrackerAddViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    TrackerAddScreen(listCategory = state.listCategory, onAction = { action ->
        when (action) {
            is TrackerAddAction.OnClickSelectCategory -> {

            }
        }
        viewModel.onAction(action)
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackerAddScreen(
    listCategory: List<Category>,
    onAction: (TrackerAddAction) -> Unit,
) {
    val scope = rememberCoroutineScope()
    val density = LocalDensity.current
    val bottomSheetState = remember {
        SheetState(
            skipPartiallyExpanded = true,
            confirmValueChange = {
                true
            },
            density = density
        )
    }

    BottomSheetScaffold(
        scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState),
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Bottom sheet content")
                Button(onClick = {
                    scope.launch {
                        bottomSheetState.hide()
                    }
                }) {
                    Text("Close")
                }
            }
        },
        sheetPeekHeight = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(onClick = {
                scope.launch {
                    bottomSheetState.show()
                }
            }) {
                Text("Open bottom sheet")
            }
        }
    }
}