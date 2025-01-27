package com.tiny.spending_tracker.tracker.presentation.tracker_add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tiny.spending_tracker.tracker.data.repository.Category
import com.tiny.spending_tracker.tracker.presentation.ColorBackground
import com.tiny.spending_tracker.tracker.presentation.tracker_add.components.TrackerAddHeader
import com.tiny.spending_tracker.tracker.presentation.tracker_add.components.TrackerAddInputAmount
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun TrackerAddScreenRoot(viewModel: TrackerAddViewModel = koinViewModel(), onBack: () -> Unit) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    TrackerAddScreen(listCategory = state.listCategory, onAction = { action ->
        when (action) {
            is TrackerAddAction.OnClickSelectCategory -> {

            }

            is TrackerAddAction.OnClickClose -> {
                onBack()
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
            skipPartiallyExpanded = true, confirmValueChange = {
                true
            }, density = density
        )
    }

    BottomSheetScaffold(
        scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState),
        sheetContent = {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
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
            modifier = Modifier.fillMaxSize().background(color = ColorBackground).padding(16.dp)
        ) {
            TrackerAddHeader(onClickClose = {
                onAction(TrackerAddAction.OnClickClose)
            })

            Spacer(modifier = Modifier.height(130.dp))

            TrackerAddInputAmount(modifier = Modifier.align(Alignment.CenterHorizontally))

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